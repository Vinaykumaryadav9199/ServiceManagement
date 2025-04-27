package com.Abc.ServiceManagement.Exception;

import java.time.LocalDateTime;

public class ApiResponse {

	 private String message;
	    private int status;
	    private LocalDateTime timestamp;

	    public ApiResponse(String message, int status) {
	        this.message = message;
	        this.status = status;
	        this.timestamp = LocalDateTime.now();
	    }

	    // Getters and Setters
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public int getStatus() {
	        return status;
	    }

	    public void setStatus(int status) {
	        this.status = status;
	    }

	    public LocalDateTime getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(LocalDateTime timestamp) {
	        this.timestamp = timestamp;
	    }
}
