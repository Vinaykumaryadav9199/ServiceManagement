package com.Abc.ServiceManagement.Dto;

public class BookingRequestDTO {
   
    private int categoryId;
    private int subcategoryId;
    private int vendorId;
    private String bookingDateStr;  // String representation of date
    private String bookingTimeStr;  // String representation of time
    private String serviceAddress;

    

    public BookingRequestDTO(int categoryId, int subcategoryId, int vendorId, String bookingDateStr,
			String bookingTimeStr, String serviceAddress) {
		
		this.categoryId = categoryId;
		this.subcategoryId = subcategoryId;
		this.vendorId = vendorId;
		this.bookingDateStr = bookingDateStr;
		this.bookingTimeStr = bookingTimeStr;
		this.serviceAddress = serviceAddress;
	}

	public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getBookingDateStr() {
        return bookingDateStr;
    }

    public void setBookingDateStr(String bookingDateStr) {
        this.bookingDateStr = bookingDateStr;
    }

    public String getBookingTimeStr() {
        return bookingTimeStr;
    }

    public void setBookingTimeStr(String bookingTimeStr) {
        this.bookingTimeStr = bookingTimeStr;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}

