
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

package org.rutebanken.tiamat.nvdb.model.search;

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
    "antallReturnert",
    "antallFunnet",
    "returnertStrekningslengde",
    "totalStrekningslengde"
})
public class Statistikk {

    @JsonProperty("antallReturnert")
    private Integer antallReturnert;
    @JsonProperty("antallFunnet")
    private Integer antallFunnet;
    @JsonProperty("returnertStrekningslengde")
    private Integer returnertStrekningslengde;
    @JsonProperty("totalStrekningslengde")
    private Integer totalStrekningslengde;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The antallReturnert
     */
    @JsonProperty("antallReturnert")
    public Integer getAntallReturnert() {
        return antallReturnert;
    }

    /**
     * 
     * @param antallReturnert
     *     The antallReturnert
     */
    @JsonProperty("antallReturnert")
    public void setAntallReturnert(Integer antallReturnert) {
        this.antallReturnert = antallReturnert;
    }

    /**
     * 
     * @return
     *     The antallFunnet
     */
    @JsonProperty("antallFunnet")
    public Integer getAntallFunnet() {
        return antallFunnet;
    }

    /**
     * 
     * @param antallFunnet
     *     The antallFunnet
     */
    @JsonProperty("antallFunnet")
    public void setAntallFunnet(Integer antallFunnet) {
        this.antallFunnet = antallFunnet;
    }

    /**
     * 
     * @return
     *     The returnertStrekningslengde
     */
    @JsonProperty("returnertStrekningslengde")
    public Integer getReturnertStrekningslengde() {
        return returnertStrekningslengde;
    }

    /**
     * 
     * @param returnertStrekningslengde
     *     The returnertStrekningslengde
     */
    @JsonProperty("returnertStrekningslengde")
    public void setReturnertStrekningslengde(Integer returnertStrekningslengde) {
        this.returnertStrekningslengde = returnertStrekningslengde;
    }

    /**
     * 
     * @return
     *     The totalStrekningslengde
     */
    @JsonProperty("totalStrekningslengde")
    public Integer getTotalStrekningslengde() {
        return totalStrekningslengde;
    }

    /**
     * 
     * @param totalStrekningslengde
     *     The totalStrekningslengde
     */
    @JsonProperty("totalStrekningslengde")
    public void setTotalStrekningslengde(Integer totalStrekningslengde) {
        this.totalStrekningslengde = totalStrekningslengde;
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
