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

public class MeetingRestriction_VersionStructure
        extends InfrastructureLinkRestriction_VersionStructure {

    protected VehicleTypeRefStructure forVehicleTypeRef;
    protected VehicleTypeRefStructure againstVehicleTypeRef;

    public VehicleTypeRefStructure getForVehicleTypeRef() {
        return forVehicleTypeRef;
    }

    public void setForVehicleTypeRef(VehicleTypeRefStructure value) {
        this.forVehicleTypeRef = value;
    }

    public VehicleTypeRefStructure getAgainstVehicleTypeRef() {
        return againstVehicleTypeRef;
    }

    public void setAgainstVehicleTypeRef(VehicleTypeRefStructure value) {
        this.againstVehicleTypeRef = value;
    }

}
