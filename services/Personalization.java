@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "to", "subject" })
public class Personalization {

	@JsonProperty("to")
	public List<ExternalEmail> to = new ArrayList<>();

	@JsonProperty("subject")
	public String subject;

	public Personalization() {
		super();
	}

	public Personalization(final List<ExternalEmail> to, final String subject) {
		super();
		this.to = to;
		this.subject = subject;
	}

	public List<ExternalEmail> getTo() {
		return to;
	}

	public void setTo(final List<ExternalEmail> to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

}
