package org.rutebanken.tiamat.model;

import java.math.BigInteger;


public class ParkingArea_VersionStructure
        extends ParkingComponent_VersionStructure {

    protected BigInteger totalCapacity;
    protected ParkingProperties parkingProperties;
    protected ParkingBays_RelStructure bays;
    protected EntranceRefs_RelStructure entrances;

    public BigInteger getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(BigInteger value) {
        this.totalCapacity = value;
    }

    public ParkingProperties getParkingProperties() {
        return parkingProperties;
    }

    public void setParkingProperties(ParkingProperties value) {
        this.parkingProperties = value;
    }

    public ParkingBays_RelStructure getBays() {
        return bays;
    }

    public void setBays(ParkingBays_RelStructure value) {
        this.bays = value;
    }

    public EntranceRefs_RelStructure getEntrances() {
        return entrances;
    }

    public void setEntrances(EntranceRefs_RelStructure value) {
        this.entrances = value;
    }

}
