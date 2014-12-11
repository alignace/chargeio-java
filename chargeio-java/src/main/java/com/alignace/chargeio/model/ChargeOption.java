/**
 * Copyright 2014 Alignace LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.alignace.chargeio.model;

import com.google.gson.annotations.SerializedName;

public class ChargeOption {

	@SerializedName("amount")
	private int amountInCent;

	private String currency;

	@SerializedName("account_id")
	private String accountId;

	@SerializedName("auto_capture")
	private boolean autoCapture;

	@SerializedName("gratuity")
	private int gratuityInCent;

	private TransactionSignature signature;

	private String reference;

	private String data;

	private IPaymentMethod method;

	public int getAmountInCent() {
		return amountInCent;
	}

	public void setAmountInCent(int amountInCent) {
		this.amountInCent = amountInCent;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public boolean getAutoCapture() {
		return autoCapture;
	}

	public void setAutoCapture(boolean autoCapture) {
		this.autoCapture = autoCapture;
	}

	public int getGratuityInCent() {
		return gratuityInCent;
	}

	public void setGratuityInCent(int gratuityInCent) {
		this.gratuityInCent = gratuityInCent;
	}

	public TransactionSignature getSignature() {
		return signature;
	}

	public void setSignature(TransactionSignature signature) {
		this.signature = signature;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public IPaymentMethod getMethod() {
		return method;
	}

	public void setMethod(IPaymentMethod method) {
		this.method = method;
	}

}
