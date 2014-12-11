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
package com.alignace.chargeio.net.exception;

import java.util.List;

public class ChargeIOException extends Exception {

	private static final long serialVersionUID = 1L;

	private int statusCode;
	private String message;
	private List<ErrorMessage> messages;

	public ChargeIOException(int statusCode, String message,
			List<ErrorMessage> messages) {

		this.statusCode = statusCode;
		this.message = message;
		this.messages = messages;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ErrorMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ErrorMessage> messages) {
		this.messages = messages;
	}

}
