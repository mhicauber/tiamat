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

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


public class ServiceCalendar_VersionStructure
        extends DataManagedObjectStructure {

    protected MultilingualStringEntity name;
    protected MultilingualStringEntity shortName;
    protected XMLGregorianCalendar fromDate;
    protected XMLGregorianCalendar toDate;
    protected XMLGregorianCalendar earliestTime;
    protected Duration dayLength;
    protected DayTypes_RelStructure dayTypes;
    protected Timebands_RelStructure timebands;
    protected OperatingDays_RelStructure operatingDays;
    protected OperatingPeriods_RelStructure operatingPeriods;
    protected DayTypeAssignments_RelStructure dayTypeAssignments;

    public MultilingualStringEntity getName() {
        return name;
    }

    public void setName(MultilingualStringEntity value) {
        this.name = value;
    }

    public MultilingualStringEntity getShortName() {
        return shortName;
    }

    public void setShortName(MultilingualStringEntity value) {
        this.shortName = value;
    }

    public XMLGregorianCalendar getFromDate() {
        return fromDate;
    }

    public void setFromDate(XMLGregorianCalendar value) {
        this.fromDate = value;
    }

    public XMLGregorianCalendar getToDate() {
        return toDate;
    }

    public void setToDate(XMLGregorianCalendar value) {
        this.toDate = value;
    }

    public XMLGregorianCalendar getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(XMLGregorianCalendar value) {
        this.earliestTime = value;
    }

    public Duration getDayLength() {
        return dayLength;
    }

    public void setDayLength(Duration value) {
        this.dayLength = value;
    }

    public DayTypes_RelStructure getDayTypes() {
        return dayTypes;
    }

    public void setDayTypes(DayTypes_RelStructure value) {
        this.dayTypes = value;
    }

    public Timebands_RelStructure getTimebands() {
        return timebands;
    }

    public void setTimebands(Timebands_RelStructure value) {
        this.timebands = value;
    }

    public OperatingDays_RelStructure getOperatingDays() {
        return operatingDays;
    }

    public void setOperatingDays(OperatingDays_RelStructure value) {
        this.operatingDays = value;
    }

    public OperatingPeriods_RelStructure getOperatingPeriods() {
        return operatingPeriods;
    }

    public void setOperatingPeriods(OperatingPeriods_RelStructure value) {
        this.operatingPeriods = value;
    }

    public DayTypeAssignments_RelStructure getDayTypeAssignments() {
        return dayTypeAssignments;
    }

    public void setDayTypeAssignments(DayTypeAssignments_RelStructure value) {
        this.dayTypeAssignments = value;
    }

}
