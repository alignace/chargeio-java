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
package com.alignace.chargeio.mapper;

import com.alignace.chargeio.mapper.gson.adapter.IPaymentTypeAdapter;
import com.alignace.chargeio.mapper.gson.adapter.TokenReferenceAdapter;
import com.alignace.chargeio.model.IPaymentMethod;
import com.alignace.chargeio.model.TokenReferenceOption;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonMapper<T> {

	private static Gson gson = null;

	private static Gson getGson() {

		if (gson == null) {

			GsonBuilder builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			builder.registerTypeAdapter(IPaymentMethod.class,
					new IPaymentTypeAdapter());
			builder.registerTypeAdapter(TokenReferenceOption.class,
					new TokenReferenceAdapter());
			gson = builder.create();
		}

		return gson;
	}

	public T fromJson(String contain, Class<T> classz) {

		T response = getGson().fromJson(contain, classz);
		return response;
	}

	public String toJson(Object object) {

		return getGson().toJson(object);
	}

}
