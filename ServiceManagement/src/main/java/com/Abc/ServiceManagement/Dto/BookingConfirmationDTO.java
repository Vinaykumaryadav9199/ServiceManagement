package com.Abc.ServiceManagement.Dto;

public class BookingConfirmationDTO {

    private int id;
    private String userId;
    private String categoryName;
    private String subcategoryName;
    private String vendorName;
    private String bookingDateStr;
    private String bookingTimeStr;
    private String serviceAddress;

    public BookingConfirmationDTO(int id, String userId, String categoryName, String subcategoryName,
                                  String vendorName, String bookingDateStr, String bookingTimeStr,
                                  String serviceAddress) {
        this.id = id;
        this.userId = userId;
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
        this.vendorName = vendorName;
        this.bookingDateStr = bookingDateStr;
        this.bookingTimeStr = bookingTimeStr;
        this.serviceAddress = serviceAddress;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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
