@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "value" })
public class Content {

	@JsonProperty("type")
	public String type;

	@JsonProperty("value")
	public String value;

	public Content() {
		super();
	}

	public Content(final String type, final String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
