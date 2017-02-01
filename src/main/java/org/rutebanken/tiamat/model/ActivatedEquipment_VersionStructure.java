package org.rutebanken.tiamat.model;

public class ActivatedEquipment_VersionStructure
        extends Equipment_VersionStructure {

    protected TrafficControlPointRefStructure trafficControlPointRef;
    protected TypeOfActivationRefStructure typeOfActivationRef;
    protected ActivationAssignments_RelStructure assignments;

    public TrafficControlPointRefStructure getTrafficControlPointRef() {
        return trafficControlPointRef;
    }

    public void setTrafficControlPointRef(TrafficControlPointRefStructure value) {
        this.trafficControlPointRef = value;
    }

    public TypeOfActivationRefStructure getTypeOfActivationRef() {
        return typeOfActivationRef;
    }

    public void setTypeOfActivationRef(TypeOfActivationRefStructure value) {
        this.typeOfActivationRef = value;
    }

    public ActivationAssignments_RelStructure getAssignments() {
        return assignments;
    }

    public void setAssignments(ActivationAssignments_RelStructure value) {
        this.assignments = value;
    }

}
