@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "to", "from", "subject", "message" })
public class EmailRequest {

	@JsonProperty("from")
	public ExternalEmail from;

	@JsonProperty("to")
	public List<ExternalEmail> to = new ArrayList<>();

	@JsonProperty("subject")
	public String subject;

	@JsonProperty("message")
	public String message;

	public EmailRequest() {
		super();
	}

	public ExternalEmail getFrom() {
		return from;
	}

	public void setFrom(final ExternalEmail from) {
		this.from = from;
	}

	public List<ExternalEmail> getTo() {
		return to;
	}

	public void setTo(final List<ExternalEmail> to) {
		this.to = to;
	}

	public void addTo(final ExternalEmail emailTo) {
		to.add(emailTo);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmailRequest [from=" + from + ", to=" + to + ", subject=" + subject + ", message=" + message + "]";
	}

	
}
