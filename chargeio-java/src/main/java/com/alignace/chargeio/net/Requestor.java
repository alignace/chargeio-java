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
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Requestor {

	private HttpClient client = HttpClientBuilder.create().build();

	public ServerResponse post(String url, Map<String, String> headers,
			String data) throws UnsupportedEncodingException {

		HttpPost post = new HttpPost(url);

		for (String key : headers.keySet())
			post.setHeader(key, headers.get(key));

		post.setEntity(new StringEntity(data));
		return executeRequest(post);
	}

	public ServerResponse delete(String url, Map<String, String> headers) {

		HttpDelete delete = new HttpDelete(url);

		for (String key : headers.keySet())
			delete.setHeader(key, headers.get(key));

		return executeRequest(delete);
	}
	
	public ServerResponse get(String url, Map<String, String> headers) {
		
		HttpGet get = new HttpGet(url);
		for (String key : headers.keySet())
			get.setHeader(key, headers.get(key));
		
		return executeRequest(get);
	}
	
	// private methods

	private ServerResponse executeRequest(HttpUriRequest request) {

		ServerResponse response = new ServerResponse();
		try {
			HttpResponse httpResponse = client.execute(request);
			response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
			response.setResponseStream(httpResponse.getEntity().getContent());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}
}
