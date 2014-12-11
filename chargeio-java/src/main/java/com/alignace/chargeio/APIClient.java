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
package com.alignace.chargeio;

import java.io.IOException;

import com.alignace.chargeio.mapper.JsonMapper;
import com.alignace.chargeio.model.Card;
import com.alignace.chargeio.model.Charge;
import com.alignace.chargeio.model.ChargeOption;
import com.alignace.chargeio.model.Refund;
import com.alignace.chargeio.model.RefundOption;
import com.alignace.chargeio.model.Transaction;
import com.alignace.chargeio.net.ChargeIORequester;
import com.alignace.chargeio.net.exception.ChargeIOException;
import com.alignace.chargeio.util.Urls;

public class APIClient {
	
	private static ChargeIORequester requestor = null;
	
	private static ChargeIORequester getRequester() {
		
		if(requestor == null)
			requestor =  new ChargeIORequester();

		return requestor;
	}

	public Charge charge(String secretKey, ChargeOption chargeOption)
			throws ChargeIOException, IOException {

		chargeOption.setAutoCapture(true);

		JsonMapper<ChargeOption> mapper1 = new JsonMapper<ChargeOption>();
		String json = mapper1.toJson(chargeOption);

		String response = getRequester().postJson(Urls.CHARGE_URL, secretKey, json);

		JsonMapper<Charge> mapper2 = new JsonMapper<Charge>();
		Charge charge = mapper2.fromJson(response, Charge.class);

		return charge;
	}

	public Card deleteCard(String secretKey, String cardId)
			throws ChargeIOException, IOException {

		String url = String.format("%1$s/%2$s", Urls.CARD_URL, cardId);
		String response = getRequester().delete(url, secretKey);

		JsonMapper<Card> mapper = new JsonMapper<Card>();
		Card card = mapper.fromJson(response, Card.class);

		return card;
	}

	public Refund refund(String secretKey, String chargeId,
			RefundOption refundOption) throws ChargeIOException, IOException {

		String url = String.format("%1$s/%2$s/refund", Urls.CHARGE_URL,
				chargeId);

		JsonMapper<RefundOption> mapper1 = new JsonMapper<RefundOption>();
		String json = mapper1.toJson(refundOption);

		String response = getRequester().postJson(url, secretKey, json);

		JsonMapper<Refund> mapper2 = new JsonMapper<Refund>();
		Refund refund = mapper2.fromJson(response, Refund.class);

		return refund;
	}

	public Transaction getTransaction(String secretKey, String transactionId)
			throws ChargeIOException, IOException {

		String url = String.format("%1$s/%2$s", Urls.TRANSACTION_URL,
				transactionId);

		String response = getRequester().get(url, secretKey);

		JsonMapper<Transaction> mapper = new JsonMapper<Transaction>();
		Transaction transaction = mapper.fromJson(response, Transaction.class);

		return transaction;

	}

}
