@Configuration
@ConfigurationProperties("email")
public class EmailProperties {

	private static final String FROM_EMAIL = "from-email";
	private static final String FROM_NAME = "from-name";
	private static final String TO_EMAIL = "to-email";
	private static final String TO_NAME = "to-name";
	private static final String SUBJECT = "subject";
	private String url;
	private String apiKey;

	private Map<String, Map<String, String>> forgotPassword = new HashMap<>();
	private Map<String, Map<String, String>> registration = new HashMap<>();
	private Map<String, Map<String, String>> order = new HashMap<>();
	private Map<String, Map<String, String>> expiredOrder = new HashMap<>();
	private Map<String, Map<String, String>> orderReport = new HashMap<>();
	private Map<String, Map<String, String>> newClient = new HashMap<>();
	private final Map<String, Map<String, String>> watchlist = new HashMap<>();
	private Map<String, String> application = new HashMap<>();
	private String mandrill;
	private Map<String, Map<String, String>> template = new HashMap<>();
	private Map<String, Map<String, String>> accountsReport = new HashMap<>();
	private Map<String, Map<String, String>> userWelcome = new HashMap<>();
	private Map<String, String> zeroBounce = new HashMap<>();
	private String[] exportGroupedDomains;

	public Map<String, String> getApplication() {
		return application;
	}

	public void setApplication(final Map<String, String> application) {
		this.application = application;
	}

	public Map<String, Map<String, String>> getRegistration() {
		return registration;
	}

	public void setRegistration(final Map<String, Map<String, String>> registration) {
		this.registration = registration;
	}

	public Map<String, Map<String, String>> getForgotPassword() {
		return forgotPassword;
	}

	public Map<String, Map<String, String>> getExpiredOrder() {
		return expiredOrder;
	}

	public void setExpiredOrder(final Map<String, Map<String, String>> expiredOrder) {
		this.expiredOrder = expiredOrder;
	}

	public void setForgotPassword(final Map<String, Map<String, String>> forgotPassword) {
		this.forgotPassword = forgotPassword;
	}

	public Map<String, Map<String, String>> getNewClient() {
		return newClient;
	}

	public void setNewClient(final Map<String, Map<String, String>> newClient) {
		this.newClient = newClient;
	}

	public String getMandrill() {
		return mandrill;
	}

	public void setMandrill(final String mandrill) {
		this.mandrill = mandrill;
	}

	public Map<String, String> getZeroBounce() {
		return zeroBounce;
	}

	public void setZeroBounce(final Map<String, String> zeroBounce) {
		this.zeroBounce = zeroBounce;
	}

	public List<String> getExportGroupedDomains() {
		return Arrays.asList(exportGroupedDomains);
	}

	public void setExportGroupedDomains(String[] exportGroupedDomains) {
		this.exportGroupedDomains = exportGroupedDomains;
	}

	public String getExpiredOrderFromName(final String regionId) {
		return expiredOrder.get(regionId).get(FROM_NAME);
	}

	public String getExpiredOrderFromEmail(final String regionId) {
		return expiredOrder.get(regionId).get(FROM_EMAIL);
	}

	public String getExpiredOrderSubject(final String regionId) {
		return expiredOrder.get(regionId).get(SUBJECT);
	}

	public String getExpiredOrderToName(final String regionId) {
		return expiredOrder.get(regionId).get(TO_NAME);
	}

	public String getExpiredOrderToEmail(final String regionId) {
		return expiredOrder.get(regionId).get(TO_EMAIL);
	}

	public String getExpiredOrderBody(final String regionId) {
		return expiredOrder.get(regionId).get("body");
	}

	public String getForgotPasswordFrom(final String regionId) {
		return forgotPassword.get(regionId).get("from");
	}

	public String getForgotPasswordFromName(final String regionId) {
		return forgotPassword.get(regionId).get(FROM_NAME);
	}

	public String getForgotPasswordSubject(final String regionId) {
		return forgotPassword.get(regionId).get(SUBJECT);
	}

	public String getRegistrationFrom(final String regionId) {
		return registration.get(regionId).get("from");
	}

	public String getRegistrationSubject(final String regionId) {
		return registration.get(regionId).get(SUBJECT);
	}

	public String getSupportEmail() {
		return application.get("support-email");
	}

	public String getApplicationFrom() {
		return application.get("from");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(final String apiKey) {
		this.apiKey = apiKey;
	}

	public Map<String, Map<String, String>> getOrder() {
		return order;
	}

	public void setOrder(final Map<String, Map<String, String>> order) {
		this.order = order;
	}

	public String getOrderFrom(final String regionId) {
		return order.get(regionId).get("from");
	}

	public String getOrderFromName(final String regionId) {
		return order.get(regionId).get(FROM_NAME);
	}

	public String getOrderReceived(final String regionId) {
		return order.get(regionId).get("subject-received");
	}

	public String getOrderProcessing(final String regionId) {
		return order.get(regionId).get("subject-processing");
	}

	public String getOrderItemWithoutStock(final String regionId) {
		return order.get(regionId).get("subject-item-without-stock");
	}

	public String getOrderPriceUpdate(final String regionId) {
		return order.get(regionId).get("subject-price-updated");
	}

	public String getOrderDeadline(final String regionId) {
		return order.get(regionId).get("subject-order-deadline");
	}

	public String getOrderExceededCreditLimit(final String regionId) {
		return order.get(regionId).get("subject-exceeded-credit-limit");
	}

	public String getOrdeDeliveryDateWithProblem(final String regionId) {
		return order.get(regionId).get("subject-delivery-date-problem");
	}

	public String getOrdeDeliveryWindowExceeded(final String regionId) {
		return order.get(regionId).get("subject-delivery-window-exceeded");
	}

	public String getNewClientSubjectRegistered(final String regionId) {
		return newClient.get(regionId).get("subject-registered");
	}

	public String getNewClientSubjectNotification(final String regionId) {
		return newClient.get(regionId).get("subject-notification");
	}

	public String getNewClientFromEmail(final String regionId) {
		return newClient.get(regionId).get(FROM_EMAIL);
	}

	public String getNewClientFromName(final String regionId) {
		return newClient.get(regionId).get(FROM_NAME);
	}

	public String getNewClientToEmail(final String regionId) {
		return newClient.get(regionId).get(TO_EMAIL);
	}

	public String getNewClientToName(final String regionId) {
		return newClient.get(regionId).get(TO_NAME);
	}

	public Map<String, Map<String, String>> getWatchlist() {
		return watchlist;
	}

	public String getWatchListBottle(final String regionId) {
		return watchlist.get(regionId).get("bottle");
	}

	public String getWatchListQuarterBarrel(final String regionId) {
		return watchlist.get(regionId).get("quarter-barrel");
	}

	public String getWatchListCan12Oz(final String regionId) {
		return watchlist.get(regionId).get("can-12-oz");
	}

	public String getWatchListSubjectNotification(final String regionId) {
		return watchlist.get(regionId).get("subject-notification");
	}

	public String getWatchListFromEmail(final String regionId) {
		return watchlist.get(regionId).get(FROM_EMAIL);
	}

	public String getWatchListFromName(final String regionId) {
		return watchlist.get(regionId).get(FROM_NAME);
	}

	public String getOrderReportFromName(final String regionId) {
		return orderReport.get(regionId).get(FROM_NAME);
	}

	public String getOrderReportFromEmail(final String regionId) {
		return orderReport.get(regionId).get(FROM_EMAIL);
	}

	public String getOrderReportSubject(final String regionId) {
		return orderReport.get(regionId).get(SUBJECT);
	}

	public String getOrderReportToName(final String regionId) {
		return orderReport.get(regionId).get(TO_NAME);
	}

	public String getOrderReportToEmail(final String regionId) {
		return orderReport.get(regionId).get(TO_EMAIL);
	}

	public String getOrderReportBody(final String regionId) {
		return orderReport.get(regionId).get("body");
	}

	public Map<String, Map<String, String>> getOrderReport() {
		return orderReport;
	}

	public void setOrderReport(final Map<String, Map<String, String>> orderReport) {
		this.orderReport = orderReport;
	}

	public Map<String, Map<String, String>> getTemplate() {
		return template;
	}

	public void setTemplate(Map<String, Map<String, String>> template) {
		this.template = template;
	}

	public Map<String, Map<String, String>> getAccountsReport() {
		return accountsReport;
	}

	public Map<String, Map<String, String>> getUserWelcome() {
		return userWelcome;
	}

	public String getTemplateFromEmail(final String regionId) {
		return template.get(regionId).get(FROM_EMAIL);
	}

	public String getTemplateFromName(final String regionId) {
		return template.get(regionId).get(FROM_NAME);
	}

	public String getTemplateToEmail(final String regionId) {
		return template.get(regionId).get(TO_EMAIL);
	}

	public String getTemplateToName(final String regionId) {
		return template.get(regionId).get(TO_NAME);
	}

	public String getAccountsReportSubject(final String regionId) {
		return accountsReport.get(regionId).get(SUBJECT);
	}

	public String getUserWelcomeSubject(final String regionId) {
		return userWelcome.get(regionId).get(SUBJECT);
	}

	public String getZeroBounceApiUrl() {
		return zeroBounce.get("url");
	}

	public String getZeroBounceApiKey() {
		return zeroBounce.get("api-key");
	}

	public Boolean isZeroBounceEnabled() {
		return Boolean.parseBoolean(zeroBounce.get("enabled"));
	}

	public List<String> getZeroBounceValidStatus() {
		if(zeroBounce.get("valid-status") == null){
			return new ArrayList<>();
		}
		return Arrays.asList(zeroBounce.get("valid-status").split(","));
	}

	public List<String> getZeroBounceValidSubStatus() {
		if(zeroBounce.get("valid-sub-status") == null){
			return new ArrayList<>();
		}
		return Arrays.asList(zeroBounce.get("valid-sub-status").split(","));
	}

	public Boolean newClientEmailBusinessEnabled(final String regionId) {
		return Boolean.parseBoolean(newClient.get(regionId).get("business-email"));
	}
}
