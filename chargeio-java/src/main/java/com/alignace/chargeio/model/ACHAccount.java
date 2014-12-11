package com.alignace.chargeio.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ACHAccount {

	private String id;

	private Date created;
	private Date modified;
	private String status;

	private String type;
	private String name;
	private boolean primary;

	@SerializedName("routing_number")
	private String routingNumber;

	@SerializedName("account_number")
	private String accountNumber;

	@SerializedName("account_type")
	private String accountType;

	@SerializedName("bank_name")
	private String bankName;

	@SerializedName("required_payment_fields")
	private String requiredPaymentFields;

	@SerializedName("transaction_allowed_countries")
	private String transactionAllowedCountries;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRequiredPaymentFields() {
		return requiredPaymentFields;
	}

	public void setRequiredPaymentFields(String requiredPaymentFields) {
		this.requiredPaymentFields = requiredPaymentFields;
	}

	public String getTransactionAllowedCountries() {
		return transactionAllowedCountries;
	}

	public void setTransactionAllowedCountries(
			String transactionAllowedCountries) {
		this.transactionAllowedCountries = transactionAllowedCountries;
	}

}
