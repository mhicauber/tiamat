package org.rutebanken.tiamat.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class SiteElement extends AddressablePlace {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlternativeName> alternativeNames;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    protected AccessibilityAssessment accessibilityAssessment;
    @Transient
    protected List<AccessModeEnumeration> accessModes;
    @Transient
    protected MultilingualStringEntity nameSuffix;
    @Transient
    protected MultilingualStringEntity crossRoad;

    @Transient
    protected MultilingualStringEntity landmark;

    @Transient
    protected PublicUseEnumeration publicUse;

    protected CoveredEnumeration covered;

    @Transient
    protected GatedEnumeration gated;

    @Transient
    protected LightingEnumeration lighting;

    protected Boolean allAreasWheelchairAccessible;

    @Transient
    protected BigInteger personCapacity;

    @Transient
    protected SiteFacilitySets_RelStructure facilities;

    public SiteElement(EmbeddableMultilingualString name) {
        super(name);
    }

    public SiteElement() {
    }

    public AccessibilityAssessment getAccessibilityAssessment() {
        return accessibilityAssessment;
    }

    public void setAccessibilityAssessment(AccessibilityAssessment value) {
        this.accessibilityAssessment = value;
    }

    public List<AccessModeEnumeration> getAccessModes() {
        if (accessModes == null) {
            accessModes = new ArrayList<AccessModeEnumeration>();
        }
        return this.accessModes;
    }

    public MultilingualStringEntity getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(MultilingualStringEntity value) {
        this.nameSuffix = value;
    }

    public List<AlternativeName> getAlternativeNames() {
        if (alternativeNames == null) {
            alternativeNames = new ArrayList<>();
        }
        return alternativeNames;
    }

    public MultilingualStringEntity getCrossRoad() {
        return crossRoad;
    }

    public void setCrossRoad(MultilingualStringEntity value) {
        this.crossRoad = value;
    }

    public MultilingualStringEntity getLandmark() {
        return landmark;
    }

    public void setLandmark(MultilingualStringEntity value) {
        this.landmark = value;
    }

    public PublicUseEnumeration getPublicUse() {
        return publicUse;
    }

    public void setPublicUse(PublicUseEnumeration value) {
        this.publicUse = value;
    }

    public CoveredEnumeration getCovered() {
        return covered;
    }

    public void setCovered(CoveredEnumeration value) {
        this.covered = value;
    }

    public GatedEnumeration getGated() {
        return gated;
    }

    public void setGated(GatedEnumeration value) {
        this.gated = value;
    }

    public LightingEnumeration getLighting() {
        return lighting;
    }

    public void setLighting(LightingEnumeration value) {
        this.lighting = value;
    }

    public Boolean isAllAreasWheelchairAccessible() {
        return allAreasWheelchairAccessible;
    }

    public void setAllAreasWheelchairAccessible(Boolean value) {
        this.allAreasWheelchairAccessible = value;
    }

    public BigInteger getPersonCapacity() {
        return personCapacity;
    }

    public void setPersonCapacity(BigInteger value) {
        this.personCapacity = value;
    }

    public SiteFacilitySets_RelStructure getFacilities() {
        return facilities;
    }

    public void setFacilities(SiteFacilitySets_RelStructure value) {
        this.facilities = value;
    }

}
