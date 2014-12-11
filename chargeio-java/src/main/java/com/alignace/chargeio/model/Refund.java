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

public class Refund extends Transaction {

	@SerializedName("amount")
	private int amountInCent;

	private String currency;

	@SerializedName("charge_id")
	private String chargeId;

	private IPaymentMethod method;
	
	private String reference;

	@SerializedName("void_reference")
	private String voidReference;

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

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public IPaymentMethod getMethod() {
		return method;
	}

	public void setMethod(IPaymentMethod method) {
		this.method = method;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getVoidReference() {
		return voidReference;
	}

	public void setVoidReference(String voidReference) {
		this.voidReference = voidReference;
	}

}
