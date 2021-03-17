package pojos;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "rates",
        "base",
        "date"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Money {

    @JsonProperty("rates")
    private Rates rates;
    @JsonProperty("base")
    private String base;
    @JsonProperty("date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Money() {
    }

    /**
     *
     * @param date
     * @param rates
     * @param base
     */
    public Money(Rates rates, String base, String date) {
        this.rates = rates;
        this.base = base;
        this.date = date;
    }

    @JsonProperty("rates")
    public Rates getRates() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRates(Rates rates) {
        this.rates = rates;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rates", rates).append("base", base).append("date", date).append("additionalProperties", additionalProperties).toString();
    }

}
