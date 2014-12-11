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

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Charge extends Transaction {

	@SerializedName("amount")
	private String amountInCent;
	
	private String currency;

	private IPaymentMethod method;

	@SerializedName("amount_refunded")
	private String amountRefunded;

	@SerializedName("gratuity")
	private int gratuityInCent;

	@SerializedName("cvv_result")
	private String cvvResult;

	@SerializedName("avs_result")
	private String avsResult;

	private String reference;

	@SerializedName("capture_reference")
	private String captureReference;

	@SerializedName("void_reference")
	private String voidReference;

	private List<Refund> refunds;

	public String getAmountInCent() {
		return amountInCent;
	}

	public void setAmountInCent(String amountInCent) {
		this.amountInCent = amountInCent;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public IPaymentMethod getMethod() {
		return method;
	}

	public void setMethod(IPaymentMethod method) {
		this.method = method;
	}

	public String getAmountRefunded() {
		return amountRefunded;
	}

	public void setAmountRefunded(String amountRefunded) {
		this.amountRefunded = amountRefunded;
	}

	public int getGratuityInCent() {
		return gratuityInCent;
	}

	public void setGratuityInCent(int gratuityInCent) {
		this.gratuityInCent = gratuityInCent;
	}

	public String getCvvResult() {
		return cvvResult;
	}

	public void setCvvResult(String cvvResult) {
		this.cvvResult = cvvResult;
	}

	public String getAvsResult() {
		return avsResult;
	}

	public void setAvsResult(String avsResult) {
		this.avsResult = avsResult;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCaptureReference() {
		return captureReference;
	}

	public void setCaptureReference(String captureReference) {
		this.captureReference = captureReference;
	}

	public String getVoidReference() {
		return voidReference;
	}

	public void setVoidReference(String voidReference) {
		this.voidReference = voidReference;
	}

	public List<Refund> getRefunds() {
		return refunds;
	}

	public void setRefunds(List<Refund> refunds) {
		this.refunds = refunds;
	}

}
