package com.Abc.ServiceManagement.Dto;

public class UserResponseDto {
    private String userId;
    private String name;
    private String email;
    private String mobile;
    private String address;

    // Getters and setters
    
    

    public UserResponseDto(String userId, String name, String email, String mobile, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

    public UserResponseDto() {
		
	}

	public String getUserId() {
    	return userId;
    }
	public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
