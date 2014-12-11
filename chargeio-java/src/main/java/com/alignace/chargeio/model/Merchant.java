package com.alignace.chargeio.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Merchant {

	private String id;
	
	private Date created;
	private Date modified;

	private String name;

	@SerializedName("contact_name")
	private String contactName;

	@SerializedName("contact_email")
	private String contactEmail;

	@SerializedName("contact_phone")
	private String contactPhone;

	private String address1;
	private String address2;
	private String city;

	private String state;

	@SerializedName("postal_code")
	private String postalCode;
	private String country;

	private String timezone;

	private String merchantAccounts;

	@SerializedName("ach_accounts")
	private List<ACHAccount> achAccounts;

	@SerializedName("api_allowed_ip_address_ranges")
	private String apiAllowedIpAddressRanges;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getMerchantAccounts() {
		return merchantAccounts;
	}

	public void setMerchantAccounts(String merchantAccounts) {
		this.merchantAccounts = merchantAccounts;
	}

	public List<ACHAccount> getAchAccounts() {
		return achAccounts;
	}

	public void setAchAccounts(List<ACHAccount> achAccounts) {
		this.achAccounts = achAccounts;
	}

	public String getApiAllowedIpAddressRanges() {
		return apiAllowedIpAddressRanges;
	}

	public void setApiAllowedIpAddressRanges(String apiAllowedIpAddressRanges) {
		this.apiAllowedIpAddressRanges = apiAllowedIpAddressRanges;
	}

}
