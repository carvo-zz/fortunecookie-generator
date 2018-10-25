package com.monsanto.interview.FortuneCookieGenerator.integration;

public class Response {
    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}