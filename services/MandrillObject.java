@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "key", "message" })
public class MandrillObject {

	@JsonProperty("key")
	private String key;
	@JsonProperty("message")
	private Message message;

	@JsonIgnore
	public MandrillObject() {
		super();
	}

	@JsonIgnore
	public MandrillObject(final String key, final Message message) {
		super();
		this.key = key;
		this.message = message;
	}

	@JsonIgnore
	public MandrillObject(final Message message) {
		super();
		this.message = message;
		key = "";
	}

	@JsonProperty("key")
	public String getKey() {
		return key;
	}

	@JsonProperty("key")
	public void setKey(final String key) {
		this.key = key;
	}

	@JsonProperty("message")
	public Message getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(final Message message) {
		this.message = message;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "from_email", "from_name", "html", "subject", "to", "attachments" })
	public static class Message {

		@JsonProperty("from_email")
		private String fromEmail;
		@JsonProperty("from_name")
		private String fromName;
		@JsonProperty("html")
		private String html;
		@JsonProperty("subject")
		private String subject;
		@JsonProperty("to")
		private List<ExternalEmail> to = new ArrayList<>();
		@JsonProperty("attachments")
		private List<Attachment> attachments = new ArrayList<>();

		@JsonProperty("from_email")
		public String getFromEmail() {
			return fromEmail;
		}

		@JsonProperty("from_email")
		public void setFromEmail(final String fromEmail) {
			this.fromEmail = fromEmail;
		}

		@JsonProperty("from_name")
		public String getFromName() {
			return fromName;
		}

		@JsonProperty("from_name")
		public void setFromName(final String fromName) {
			this.fromName = fromName;
		}

		@JsonProperty("html")
		public String getHtml() {
			return html;
		}

		@JsonProperty("html")
		public void setHtml(final String html) {
			this.html = html;
		}

		@JsonProperty("subject")
		public String getSubject() {
			return subject;
		}

		@JsonProperty("subject")
		public void setSubject(final String subject) {
			this.subject = subject;
		}

		@JsonProperty("to")
		public List<ExternalEmail> getTo() {
			return to;
		}

		@JsonProperty("to")
		public void setTo(final List<ExternalEmail> to) {
			this.to = to;
		}

		@JsonProperty("attachments")
		public List<Attachment> getAttachments() {
			return attachments;
		}

		@JsonProperty("attachments")
		public void setAttachments(final List<Attachment> attachments) {
			this.attachments = attachments;
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonPropertyOrder({ "type", "name", "content" })
		public static class Attachment {

			@JsonProperty("type")
			private String type;
			@JsonProperty("name")
			private String name;
			@JsonProperty("content")
			private String content;

			@JsonProperty("type")
			public String getType() {
				return type;
			}

			@JsonProperty("type")
			public void setType(final String type) {
				this.type = type;
			}

			@JsonProperty("name")
			public String getName() {
				return name;
			}

			@JsonProperty("name")
			public void setName(final String name) {
				this.name = name;
			}

			@JsonProperty("content")
			public String getContent() {
				return content;
			}

			@JsonProperty("content")
			public void setContent(final String content) {
				this.content = content;
			}

		}

	}
}
