package am.workfront.event;

import org.apache.commons.lang.builder.*;
import org.codehaus.jackson.annotate.*;

/**
 * Created by Garik on 2/14/15.
 */
public class MessageEvent extends ApplicationEvent {

	public static enum MessageType {

		ALL		(0, "all"),
		CHAT 	(1, "chat"),
		SMS  	(2, "sms"),
		EMAIL	(3, "email");

		MessageType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public static MessageType valueOf(int value) {
			for (MessageType e : MessageType.values()) {
				if (e.value == value) {
					return e;
				}
			}
			return null;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		private final int value;
		private final String name;
	}

	private long id;

	private MessageType type;

	private String content;

	@Override
	@JsonIgnore
	public String getEventType() {
		return "message.event";
	}

	public long getId() {
		return id;
	}

	public MessageType getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(id)
			.append(content)
			.append(type)
			.toString();
	}

	public static class Builder implements GeneralBuilder {

		private MessageEvent event = new MessageEvent();

		public Builder setId(long id) {
			event.id = id;
			return this;
		}

		public Builder setType(MessageType type) {
			event.type = type;
			return this;
		}

		public Builder setContent(String content) {
			event.content = content;
			return this;
		}

		@Override
		public MessageEvent build() {
			return event;
		}
	}
}
