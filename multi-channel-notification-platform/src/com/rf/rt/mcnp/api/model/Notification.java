package com.rf.rt.mcnp.api.model;

import com.rf.rt.mcnp.api.enums.Priority;

public class Notification {
	private String title;
	private String message;
	private String recipient;
	private Priority priority;

	public Notification(NotificationBuilder builder) {
		this.title = builder.title;
		this.message = builder.message;
		this.recipient = builder.recipient;
		this.priority = builder.priority;
	}

	@Override
	public String toString() {
		return "Notification [title=" + title + ", message=" + message + ", recipient=" + recipient + ", priority="
				+ priority + "]";
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public String getRecipient() {
		return recipient;
	}

	public Priority getPriority() {
		return priority;
	}

	public static class NotificationBuilder {
		private String title;
		private String message;
		private String recipient;
		private Priority priority;

		public NotificationBuilder() {
		}

		public NotificationBuilder(String title) {
			this.title = title;
		}

		public NotificationBuilder setTitle(String title) {
			this.title = title;
			return this;
		}

		public NotificationBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public NotificationBuilder setRecipient(String recipient) {
			this.recipient = recipient;
			return this;
		}

		public NotificationBuilder setPriority(Priority priority) {
			this.priority = priority;
			return this;
		}

		public Notification build() {
			return new Notification(this);
		}
	}
}
