package by.it_academy.jd2.core.dto;

import java.time.LocalDateTime;

public class Message {
    private final LocalDateTime dtSend;
    private final String sender;
    private final String receiver;
    private final String message;
    private Message(LocalDateTime dtSend, String sender, String receiver, String message) {
        this.dtSend = dtSend;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }
    public static Builder builder() {
        return new Builder();
    }

    public LocalDateTime getDtSend() {
        return dtSend;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public static class Builder {
        private LocalDateTime dtSend;
        private String sender;
        private String receiver;
        private String message;
        public Builder dtSend(LocalDateTime dtSend) {
            this.dtSend = dtSend;
            return this;
        }
        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }
        public Builder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Message build() {
            return new  Message(dtSend, sender, receiver, message);
        }
    }
}
