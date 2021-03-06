
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

package org.rutebanken.tiamat.nvdb.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "navn",
    "verdi",
    "definisjon",
    "enumVerdi"
})
public class Egenskap {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("navn")
    private String navn;
    @JsonProperty("verdi")
    private String verdi;
    @JsonProperty("definisjon")
    private Definisjon_ definisjon;
    @JsonProperty("enumVerdi")
    private EnumVerdi enumVerdi;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The navn
     */
    @JsonProperty("navn")
    public String getNavn() {
        return navn;
    }

    /**
     * 
     * @param navn
     *     The navn
     */
    @JsonProperty("navn")
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * 
     * @return
     *     The verdi
     */
    @JsonProperty("verdi")
    public String getVerdi() {
        return verdi;
    }

    /**
     * 
     * @param verdi
     *     The verdi
     */
    @JsonProperty("verdi")
    public void setVerdi(String verdi) {
        this.verdi = verdi;
    }

    /**
     * 
     * @return
     *     The definisjon
     */
    @JsonProperty("definisjon")
    public Definisjon_ getDefinisjon() {
        return definisjon;
    }

    /**
     * 
     * @param definisjon
     *     The definisjon
     */
    @JsonProperty("definisjon")
    public void setDefinisjon(Definisjon_ definisjon) {
        this.definisjon = definisjon;
    }

    /**
     * 
     * @return
     *     The enumVerdi
     */
    @JsonProperty("enumVerdi")
    public EnumVerdi getEnumVerdi() {
        return enumVerdi;
    }

    /**
     * 
     * @param enumVerdi
     *     The enumVerdi
     */
    @JsonProperty("enumVerdi")
    public void setEnumVerdi(EnumVerdi enumVerdi) {
        this.enumVerdi = enumVerdi;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
