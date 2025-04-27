package com.Abc.ServiceManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ServiceCategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", nullable = false)
    private SubcategoryEntity subcategory;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorEntity vendor;

    @Column(name = "service_address", nullable = false)
    private String serviceAddress;

    // Storing date and time purely as strings
    @Column(name = "booking_date_str", nullable = false)
    private String bookingDateStr;

    @Column(name = "booking_time_str", nullable = false)
    private String bookingTimeStr;

    public BookingEntity() {
    }

    public BookingEntity(UserEntity user, ServiceCategoryEntity category, SubcategoryEntity subcategory,
                         VendorEntity vendor, String bookingDateStr, String bookingTimeStr, String serviceAddress) {
        this.user = user;
        this.category = category;
        this.subcategory = subcategory;
        this.vendor = vendor;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ServiceCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ServiceCategoryEntity category) {
        this.category = category;
    }

    public SubcategoryEntity getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubcategoryEntity subcategory) {
        this.subcategory = subcategory;
    }

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
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
}

