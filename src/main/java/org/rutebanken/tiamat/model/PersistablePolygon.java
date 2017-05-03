package org.rutebanken.tiamat.model;


import com.vividsolutions.jts.geom.Polygon;
import org.rutebanken.tiamat.model.identification.IdentifiedEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class PersistablePolygon implements Serializable {

    @Id
    @GeneratedValue(generator="sequence_per_table_generator")
    protected Long id;

    private Polygon polygon;

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }
}