@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "email" })
public class ExternalEmail {

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	public ExternalEmail() {
		super();
	}

	public ExternalEmail(final String name, final String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "ExternalEmail [name=" + name + ", email=" + email + "]";
	}

}
