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

package org.rutebanken.tiamat.model;

import javax.xml.bind.JAXBElement;
import java.math.BigInteger;


public class VehicleEquipmentProfile_VersionStructure
        extends DataManagedObjectStructure {

    protected MultilingualStringEntity name;
    protected JAXBElement<? extends EquipmentRefStructure> equipmentRef;
    protected BigInteger units;
    protected MultilingualStringEntity manufacturer;
    protected PurposeOfEquipmentProfileRefStructure purposeOfEquipmentProfileRef;

    public MultilingualStringEntity getName() {
        return name;
    }

    public void setName(MultilingualStringEntity value) {
        this.name = value;
    }

    public JAXBElement<? extends EquipmentRefStructure> getEquipmentRef() {
        return equipmentRef;
    }

    public void setEquipmentRef(JAXBElement<? extends EquipmentRefStructure> value) {
        this.equipmentRef = value;
    }

    public BigInteger getUnits() {
        return units;
    }

    public void setUnits(BigInteger value) {
        this.units = value;
    }

    public MultilingualStringEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(MultilingualStringEntity value) {
        this.manufacturer = value;
    }

    public PurposeOfEquipmentProfileRefStructure getPurposeOfEquipmentProfileRef() {
        return purposeOfEquipmentProfileRef;
    }

    public void setPurposeOfEquipmentProfileRef(PurposeOfEquipmentProfileRefStructure value) {
        this.purposeOfEquipmentProfileRef = value;
    }

}
