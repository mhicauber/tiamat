package org.rutebanken.tiamat.importer;

import org.rutebanken.tiamat.model.DataManagedObjectStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class KeyValueListAppender {

    private static final Logger logger = LoggerFactory.getLogger(KeyValueListAppender.class);

    public boolean appendToOriginalId(String key, DataManagedObjectStructure newObject, DataManagedObjectStructure existingObject) {

        Set<String> existingObjectIds = existingObject.getOrCreateValues(key);
        Set<String> newObjectIds = newObject.getOrCreateValues(key);

        boolean changed = false;
        for(String newOriginalId : newObjectIds) {
            if(!existingObjectIds.contains(newOriginalId)) {
                logger.info("Adding new original ID '{}' to existing object {}", newOriginalId, existingObject);
                existingObjectIds.add(newOriginalId);
                changed = true;
            }
        }
        return changed;
    }
}