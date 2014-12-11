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
package com.alignace.chargeio.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;

import com.alignace.chargeio.mapper.JsonMapper;
import com.alignace.chargeio.net.exception.ChargeIOException;

public class ChargeIORequester {

	private static final String CHARSET = "UTF-8";
	private static Requestor requestor = null;
	
	private static Requestor getRequestor() {
		
		if(requestor == null)
			requestor = new Requestor();
		
		return requestor;
	}

	public String postJson(String url, String secretKey, String data)
			throws ChargeIOException, IOException {

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		return post(url, secretKey, headers, data);
	}

	private String post(String url, String secretKey,
			Map<String, String> headers, String data) throws ChargeIOException,
			IOException {

		ServerResponse serverResponse = null;
		Map<String, String> header = getBasicHeader(secretKey);
		if (headers != null)
			header.putAll(headers);
		try {
			serverResponse = getRequestor().post(url, header, data);
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
		String response = processResponse(serverResponse);
		return response;
	}

	public String delete(String url, String secretKey)
			throws ChargeIOException, IOException {

		ServerResponse serverResponse = null;
		Map<String, String> header = getBasicHeader(secretKey);
		serverResponse = getRequestor().delete(url, header);
		String response = processResponse(serverResponse);

		return response;
	}

	public String get(String url, String secretKey) throws ChargeIOException,
			IOException {

		ServerResponse serverResponse = null;
		Map<String, String> header = getBasicHeader(secretKey);
		serverResponse = getRequestor().get(url, header);
		String response = processResponse(serverResponse);

		return response;
	}

	// private Methods

	private String processResponse(ServerResponse serverResponse)
			throws ChargeIOException, IOException {

		String responseBody = null;
		try {
			int responseCode = serverResponse.getStatusCode();
			responseBody = getResponseBody(serverResponse.getResponseStream());

			if (responseCode != 200) {
				JsonMapper<ChargeIOException> mapper = new JsonMapper<ChargeIOException>();
				ChargeIOException exception = mapper.fromJson(responseBody,
						ChargeIOException.class);
				exception.setStatusCode(responseCode);
				exception.setMessage(exception.getMessages().get(0)
						.getMessage());

				throw exception;
			}

		} catch (IOException e) {
			throw e;
		}
		return responseBody;
	}

	private String getResponseBody(InputStream responseStream)
			throws IOException {

		@SuppressWarnings("resource")
		String response = new Scanner(responseStream, CHARSET).useDelimiter(
				"\\A").next();
		responseStream.close();
		return response;
	}

	private Map<String, String> getBasicHeader(String secretKey) {

		Map<String, String> header = new HashMap<String, String>();
		header.put("Authorization",
				getAuthorizationHeaderValue(secretKey + ":"));

		return header;
	}

	private String getAuthorizationHeaderValue(String secretKey) {
		return "Basic " + Base64.encodeBase64String(secretKey.getBytes());
	}

}
