/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package org.rutebanken.tiamat.service;

import com.hazelcast.core.HazelcastInstance;
import org.junit.Test;
import org.rutebanken.tiamat.TiamatIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rutebanken.tiamat.service.MutateLock.LOCK_MAX_LEASE_TIME_SECONDS;
import static org.rutebanken.tiamat.service.MutateLock.WAIT_FOR_LOCK_SECONDS;


public class MutateLockTest extends TiamatIntegrationTest {

    @Autowired
    private HazelcastInstance hazelcastInstance;


    @Test
    public void testWaitingForLock() throws InterruptedException {
        MutateLock mutateLock = new MutateLock(hazelcastInstance);

        long sleep = 1000;

        AtomicBoolean threadGotLock = new AtomicBoolean(false);
        Thread t1 = new Thread(() -> {
            mutateLock.executeInLock(() -> {
                threadGotLock.set(true);
                try {
                    System.out.println("Sleeping for " + sleep + " millis");
                    Thread.sleep(sleep);
                    System.out.println("Slept" + sleep + " millis");
                    return null;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        });
        long started = System.currentTimeMillis();
        t1.start();
        // Make sure the thread gets the lock first
        while(!threadGotLock.get()) {}
        long gotLock = mutateLock.executeInLock(() -> System.currentTimeMillis());

        long waited = gotLock - started;
        assertThat(waited)
                .as("waited ms")
                .isGreaterThanOrEqualTo(sleep)
                .as("ms thread slept within lock");
    }

    @Test(expected = MutateLockException.class)
    public void testWaitingForLocktTimeout() throws InterruptedException {

        int waitTimeout = 300;
        MutateLock mutateLock = new MutateLock(hazelcastInstance, waitTimeout, TimeUnit.MILLISECONDS);

        // Sleep more than the wait time to trigger exception
        long sleep = waitTimeout + 100;
        AtomicBoolean threadGotLock = new AtomicBoolean(false);

        Thread t1 = new Thread(() -> {
            mutateLock.executeInLock(() -> {
                try {
                    threadGotLock.set(true);
                    System.out.println("Sleeping " + sleep + " millis");
                    Thread.sleep(sleep);
                    System.out.println("Slept " + sleep + " millis");
                    return null;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        });

        t1.start();
        // Make sure the thread gets the lock first
        while(!threadGotLock.get()) {}
        // Should throw exception because the wait time was too long
        mutateLock.executeInLock(() -> System.currentTimeMillis());
    }
}