package org.rutebanken.tiamat.versioning;


import org.rutebanken.tiamat.model.Parking;
import org.rutebanken.tiamat.repository.EntityInVersionRepository;
import org.rutebanken.tiamat.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ParkingVersionedSaverService extends VersionedSaverService<Parking> {

    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    public EntityInVersionRepository<Parking> getRepository() {
        return parkingRepository;
    }
}