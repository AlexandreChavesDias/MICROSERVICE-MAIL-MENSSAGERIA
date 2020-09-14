@Component
public class EmailBuilder {

	@Autowired
	EmailProperties emailProperties;

	@Autowired
	CalendarService calendarService;

	@Autowired
	BlobStorageProperties blobStorageProperties;

	@Autowired
	ApiProperties apiProperties;

	@Autowired
	SkuRepository skuRepository;

	@Autowired
	CmsService cmsService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailBuilder.class);

	private static final String LICENSE = "License";
	private static final String DOCUMENT = "Document";

	private final VelocityEngine velocityEngine = new VelocityEngine();
	private final Properties properties = new Properties();
	private final VelocityContext velocityContext = new VelocityContext();
	private Template template;

	private void initVelocity(final String htmlTemplate) {
		properties.setProperty("resource.loader", "class");
		properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.init(properties);
		template = velocityEngine.getTemplate(htmlTemplate);
		velocityContext.put("imagesBaseUrl", blobStorageProperties.getBaseUrl());
	}

	public EmailRequest buildForgotPasswordEmail(final Country regionId, final User user, final String temporaryPassword) {
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderReceivedEmail(final Country regionId, final User user, final Order order, final String oldOrderKey) {
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderProcessingEmail(final Country regionId, final User user) {
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderItemPriceUpdatedEmail(final Country regionId, final User user, final Order order) {
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderStockUpdateEmail(final Country regionId, final User user, final Order order) {
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderDeadlineEmail(final Country regionId, final User user) {
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderDeliveryWindowExceeded(final Country regionId, final User user, final Order order) {
			final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderDeliveryDateWithProblem(final Country regionId, final User user, final Order order) {
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	public EmailRequest buildOrderExceededCreditLimitEmail(final Country regionId, final User user, final Order order, final Double orderDifference,
		final EmailRequest emailRequest = new EmailRequest();
		final String regionKey = regionId.key();
		emailRequest.setFrom(new ExternalEmail());
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getForgotPasswordSubject());
		emailRequest.setMessage());
		return emailRequest;
	}

	private String buildOrderExceededCreditLimitHtml(final String htmlTemplate, final Country regionId, final Double orderDifference, final Order order,
			final List<RetrievedEmpty> empties) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("orderNumber", order.getOrderKey());
			velocityContext.put("orderDifference", "$" + String.format("%.2f", orderDifference));
			if (!empties.isEmpty()) {
				velocityContext.put("empties", buildEmptiesDetails(order.getEmpties(), empties));
			}
		}
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildEmptiesDetails(final Set<Empty> orderEmpties, final List<RetrievedEmpty> retrievedEmpties) {
		final StringBuilder tableItems = new StringBuilder();
		for (final RetrievedEmpty retrievedEmpty : retrievedEmpties) {
			final Empty empty = orderEmpties.stream().filter(item -> item.getEmptiesId().equalsIgnoreCase(retrievedEmpty.getId())).findFirst().orElse(null);
			if (empty != null) {
				tableItems.append("<tr>");
				tableItems.append("<td>");
				tableItems.append(empty.getItemCount());
				tableItems.append("</td>");
				tableItems.append("<td>");
				tableItems.append(retrievedEmpty.getName());
				tableItems.append("</td>");
				tableItems.append("</tr>");
			}

		}

		return tableItems.toString();
	}

	private String buildOrderDeliveryWindowExceededHtml(final String htmlTemplate, final Country regionId, final Order order) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("orderId", order.getOrderKey());
			if (!StringUtils.isEmpty(order.getExpectedDeliveryDate())) {
				velocityContext.put("deliveryDate",
						convertDateFormat(order.getExpectedDeliveryDate(), MI_MODELO_ORDER_RECEIVED_DEFAULT_PATTERN, MI_MODELO_DELIVERY_DATE_PROBLEM_PATTERN));
			} else {
				velocityContext.put("deliveryDate", "noDate");
			}

		}
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildOrderDeliveryDateWithProblemHtml(final String htmlTemplate, final Country regionId, final Order order) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("orderId", order.getOrderKey());
			if (!StringUtils.isEmpty(order.getExpectedDeliveryDate())) {
				velocityContext.put("deliveryDate",
						convertDateFormat(order.getExpectedDeliveryDate(), MI_MODELO_ORDER_DELIVERY_DATE_PROBLEM_DEFAULT_PATTERN, MI_MODELO_DELIVERY_DATE_PROBLEM_PATTERN));
			} else {
				velocityContext.put("deliveryDate", "noDate");
			}

		}
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildOrderPriceUpdatedHtml(final String htmlTemplate, final Country regionId, final String name, final Order order) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("name", name);
			velocityContext.put("itemsDetails", buildItemsDetails(order));
		}
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildOrderItemWithoutStock(final String htmlTemplate, final Country regionId, final String name, final Order order) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("name", name);
			velocityContext.put("itemsDetails", buildItemsDetails(order));
		}
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildOrderProcessingHtml(final String htmlTemplate, final Country regionId, final String name) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("name", name);
		}
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildForgotPasswordHtml(final String htmlTemplate, final Country regionId, final String name, final String temporaryPassword) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("name", name);
			velocityContext.put("temporaryPassword", temporaryPassword);
		}
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildOrderReceivedEmail(final String htmlTemplate, final Country regionId, final String name, final Order order, final String oldOrderKey) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		if (Country.equals(regionId)) {
			velocityContext.put("name", name);
			velocityContext.put("orderNumber", order.getOrderKey());
			velocityContext.put("oldOrderNumber", oldOrderKey);
			velocityContext.put("orderId", order.getOrderId());
			velocityContext.put("createdAt",
					calendarService.getStringFromTimestampWithSalesOrganizationTimezoneAndPattern(order.getCreatedAt(), MI_MODELO_ORDER_RECEIVED_PATTERN,
							order.getAccount().getSalesOrganization()));
			if (!StringUtils.isEmpty(order.getExpectedDeliveryDate())) {
				velocityContext.put("expectedDeliveryDate",
						convertDateFormat(order.getExpectedDeliveryDate(), MI_MODELO_ORDER_RECEIVED_DEFAULT_PATTERN, MI_MODELO_ORDER_RECEIVED_PATTERN));
			} else {
				velocityContext.put("expectedDeliveryDate", "noDate");
			}
		}
		template.merge(velocityContext, writer);
		return writer.toString();

	}

	public EmailRequest buildNewCustomerRegisteredEmailNotificationHtml(final NewClientInformation newClientInformation,
			final List<CustomerDocumentReference> documentsReference,
			final Country regionId) {
		final EmailRequest emailRequest = new EmailRequest();
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("firstName", newClientInformation.getName());
		parameters.put("email", newClientInformation.getEmail());
		parameters.put("lastName", newClientInformation.getLastName());
			for (final CustomerDocumentReference cdr : documentsReference) {
			if (cdr.getImageAddress().contains(LICENSE)) {
				parameters.put("licenseUrl", buildApiCustomerImages(cdr));
			} else if (cdr.getImageAddress().contains(DOCUMENT)) {
				parameters.put("documentUrl", buildApiCustomerImages(cdr));
			} else {
				parameters.put("addressUrl", buildApiCustomerImages(cdr));
			}
		}

		emailRequest.setFrom(new ExternalEmail(emailProperties.getNewClientFromName(regionId.key()), emailProperties.getNewClientFromEmail(regionId.key())));
		final List<String> toAddresses = getCustomerServicesEmail(emailProperties.getNewClientToEmail(regionId.key()));
		for (final String address : toAddresses) {
			emailRequest.addTo(new ExternalEmail(emailProperties.getNewClientToName(regionId.key()), address));
		}
		emailRequest.setSubject(emailProperties.getNewClientSubjectNotification(regionId.key()));
		emailRequest.setMessage(buildEmailWithParameters(MI_MODELO_NEW_CLIENT_REGISTERED_HTML, parameters));
		return emailRequest;
	}

	private List<String> getCustomerServicesEmail(final String customerServiceEmail) {
		final List<String> customerServices = new ArrayList<>();
		final String[] addresses = customerServiceEmail.split(",");
		for (final String address : addresses) {
			customerServices.add(address.trim());
		}
		return customerServices;
	}

	private String buildApiCustomerImages(final CustomerDocumentReference cdr) {

		final String baseApiUrl = apiProperties.getBaseUrl();

		final StringBuilder sb = new StringBuilder();
		sb.append(baseApiUrl);

		if (!baseApiUrl.endsWith("/")) {
			sb.append("/");
		}

		sb.append(CustomerResource.BASE_PATH).append("/");
		sb.append("img").append("/");
		sb.append(cdr.getNewClientInformation().getId()).append("/");
		sb.append(cdr.getHash());

		return sb.toString();

	}

	public EmailRequest buildNewCustomerRegisteredEmailNotificationToUserHtml(final NewClientInformation user, final Country regionId) {
		final EmailRequest emailRequest = new EmailRequest();
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("firstName", user.getName());
		emailRequest.setFrom(new ExternalEmail(emailProperties.getNewClientFromName(regionId.key()), emailProperties.getNewClientFromEmail(regionId.key())));
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject(emailProperties.getNewClientSubjectRegistered(regionId.key()));
		emailRequest.setMessage(buildEmailWithParameters(MI_MODELO_NEW_CLIENT_REGISTERED_TO_USER_HTML, parameters));
		return emailRequest;
	}

	private String buildEmailWithParameters(final String htmlTemplate, final Map<String, Object> parameters) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		parameters.forEach(velocityContext::put);
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildTemplateWithoutAdditionalInfo(final String htmlTemplate) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	private String buildItemsDetails(final Order order) {
		final StringBuilder tableItems = new StringBuilder();
		final Set<String> itemKeys = order.getPricing().getOrderItems().stream().map(OrderItem::getItemKey).collect(Collectors.toSet());
		final List<Sku> skus = skuRepository.findSkuByItemKeyIn(itemKeys);
		final List<OrderItem> orderItems = order.getPricing().getOrderItems();
		if (CollectionUtils.isNotEmpty(orderItems)) {
			orderItems.forEach(orderItem -> {
				final Sku sku = skus.parallelStream().filter(s -> s.getItemKey().equalsIgnoreCase(orderItem.getItemKey())).findFirst().orElse(null);
				if (orderItem != null && sku != null) {
					tableItems.append("<tr>");
					tableItems.append("<td>");
					tableItems.append(orderItem.getItemCount());
					tableItems.append("</td>");
					tableItems.append("<td>");
					tableItems.append(sku.getName());
					tableItems.append("</td>");
					tableItems.append("<td>");
					tableItems.append("$ ").append(String.format("%.2f", orderItem.getCost()));
					tableItems.append("</td>");
					tableItems.append("</tr>");
				}
			});
			tableItems.append("<tr>");
			tableItems.append("<td></td>");
			tableItems.append("<td>");
			tableItems.append("Total");
			tableItems.append("</td>");
			tableItems.append("<td>");
			tableItems.append("$ ").append(String.format("%.2f", order.getPricing().getCost()));
			tableItems.append("</td>");
			tableItems.append("</tr>");
		}

		return tableItems.toString();
	}

	private String convertDateFormat(final String dateFrom, final String patternFrom, final String patternTo) {
		try {
			final SimpleDateFormat simpleDateFormatFrom = new SimpleDateFormat(patternFrom);
			final SimpleDateFormat simpleDateFormatTo = new SimpleDateFormat(patternTo);
			final Date date = simpleDateFormatFrom.parse(dateFrom);
			return simpleDateFormatTo.format(date);
		} catch (final ParseException ex) {
			LOGGER.error("Parse Exception: ", ex);
			return dateFrom;
		}
	}

	public EmailRequest buildNewWatchListEmailNotification(final List<WatchlistEmailNotificationItem> items, final List<ExternalEmail> emails, final Country regionId) {

		final EmailRequest emailRequest = new EmailRequest();
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("items", items);

		emailRequest.setFrom(new ExternalEmail(emailProperties.getWatchListFromName(regionId.key()), emailProperties.getWatchListFromEmail(regionId.key())));
		emailRequest.setTo(emails);
		emailRequest.setSubject(emailProperties.getWatchListSubjectNotification(regionId.key()));
		emailRequest.setMessage(buildEmailWithParameters(MI_MODELO_WATCHLIST_NOTIFICATION_HTML, parameters));
		return emailRequest;
	}

	public EmailRequest buildReportMasterDataEmail(final List<AccountsEmailReport> listAccountsReport) {
		final LocalDateTime now = LocalDateTime.now();
		final String currentDate = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		final EmailRequest emailRequest = new EmailRequest();
		emailRequest.setFrom(new ExternalEmail(emailProperties.getTemplateFromName()));
		emailRequest.addTo(new ExternalEmail(emailProperties.getTemplateToName()));
		emailRequest.setSubject(String.format(emailProperties.getAccountsReportSubject(), currentDate));
		emailRequest.setMessage(buildAccountsWithError(MI_MODELO_REPORT_MASTER_DATA_HTML, listAccountsReport, currentDate));
		return emailRequest;
	}

	private String buildAccountsWithError(final String htmlTemplate, final List<AccountsEmailReport> listAccountsReport, final String currentDate) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		velocityContext.put("currentDate", currentDate);
		velocityContext.put("accountsReport", listAccountsReport);
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	public EmailRequest buildUserWelcomeEmail(final User user) {
		final EmailRequest emailRequest = new EmailRequest();
		emailRequest.setFrom(new ExternalEmail(emailProperties.getTemplateFromName()));
		emailRequest.addTo(new ExternalEmail(user.getName(), user.getEmail()));
		emailRequest.setSubject();
		emailRequest.setMessage();
		return emailRequest;
	}

	private String buildUserWelcomeTemplate(final String htmlTemplate, final String name, final String userLogin) {
		initVelocity(htmlTemplate);
		final StringWriter writer = new StringWriter();
		velocityContext.put("name", name);
		velocityContext.put("userLogin", userLogin);
		template.merge(velocityContext, writer);
		return writer.toString();
	}
}
