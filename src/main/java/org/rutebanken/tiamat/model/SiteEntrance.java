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

import java.math.BigDecimal;


public class SiteEntrance extends SiteComponent_VersionStructure {

    protected String publicCode;
    protected MultilingualStringEntity label;
    protected EntranceEnumeration entranceType;
    protected Boolean isExternal;
    protected Boolean isEntry;
    protected Boolean isExit;
    protected BigDecimal width;
    protected BigDecimal height;
    protected Boolean droppedKerbOutside;
    protected Boolean dropOffPointClose;

    public String getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(String value) {
        this.publicCode = value;
    }

    public MultilingualStringEntity getLabel() {
        return label;
    }

    public void setLabel(MultilingualStringEntity value) {
        this.label = value;
    }

    public EntranceEnumeration getEntranceType() {
        return entranceType;
    }

    public void setEntranceType(EntranceEnumeration value) {
        this.entranceType = value;
    }

    public Boolean isIsExternal() {
        return isExternal;
    }

    public void setIsExternal(Boolean value) {
        this.isExternal = value;
    }

    public Boolean isIsEntry() {
        return isEntry;
    }

    public void setIsEntry(Boolean value) {
        this.isEntry = value;
    }

    public Boolean isIsExit() {
        return isExit;
    }

    public void setIsExit(Boolean value) {
        this.isExit = value;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal value) {
        this.width = value;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal value) {
        this.height = value;
    }

    public Boolean isDroppedKerbOutside() {
        return droppedKerbOutside;
    }

    public void setDroppedKerbOutside(Boolean value) {
        this.droppedKerbOutside = value;
    }

    public Boolean isDropOffPointClose() {
        return dropOffPointClose;
    }

    public void setDropOffPointClose(Boolean value) {
        this.dropOffPointClose = value;
    }

}
