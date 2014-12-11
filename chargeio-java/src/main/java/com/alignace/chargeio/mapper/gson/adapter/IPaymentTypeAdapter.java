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
package com.alignace.chargeio.mapper.gson.adapter;

import java.lang.reflect.Type;

import com.alignace.chargeio.model.Bank;
import com.alignace.chargeio.model.Card;
import com.alignace.chargeio.model.IPaymentMethod;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class IPaymentTypeAdapter implements JsonDeserializer<IPaymentMethod> {

	public IPaymentMethod deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {

		final JsonObject wrapper = (JsonObject) json;
		final JsonElement typeName = get(wrapper, "type");
		final Type actualType = typeForName(typeName);
		IPaymentMethod response = context.deserialize(json, actualType);
		return response;
	}

	private Type typeForName(final JsonElement typeElem) {

		Type type = null;
		try {

			String typeName = typeElem.getAsString();
			if (typeName.equals("card"))
				type = Card.class;
			else if (typeName.equals("bank"))
				type = Bank.class;
			else
				type = Class.forName(typeElem.getAsString());
		} catch (ClassNotFoundException e) {
			throw new JsonParseException(e);
		}

		return type;
	}

	private JsonElement get(final JsonObject wrapper, String memberName) {
		final JsonElement elem = wrapper.get(memberName);
		if (elem == null)
			throw new JsonParseException(
					"no '"
							+ memberName
							+ "' member found in what was expected to be an interface wrapper");
		return elem;
	}

}
