package com.Abc.ServiceManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abc.ServiceManagement.Dto.BookingConfirmationDTO;
import com.Abc.ServiceManagement.Dto.BookingRequestDTO;
import com.Abc.ServiceManagement.Dto.UserResponseDto;
import com.Abc.ServiceManagement.Entity.BookingEntity;
import com.Abc.ServiceManagement.Entity.ServiceCategoryEntity;
import com.Abc.ServiceManagement.Entity.SubcategoryEntity;
import com.Abc.ServiceManagement.Entity.UserEntity;
import com.Abc.ServiceManagement.Entity.VendorEntity;
import com.Abc.ServiceManagement.Repo.*;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ServiceCategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public BookingConfirmationDTO createBooking(BookingRequestDTO bookingRequest, HttpSession session) {
        // Get the userId from the session
        UserResponseDto userResponse = (UserResponseDto) session.getAttribute("user");
        System.out.println(userResponse.getName());
        if (userResponse == null) {
            throw new IllegalArgumentException("User not logged in");
        }
        String userId = userResponse.getUserId();
        UserEntity user = userRepository.findByUserId(userId).get();

        // Validate the provided IDs
        Optional<ServiceCategoryEntity> categoryOptional = categoryRepository.findById(bookingRequest.getCategoryId());
        Optional<SubcategoryEntity> subcategoryOptional = subcategoryRepository.findById(bookingRequest.getSubcategoryId());
        Optional<VendorEntity> vendorOptional = vendorRepository.findById(bookingRequest.getVendorId());

        if (categoryOptional.isEmpty() || subcategoryOptional.isEmpty() || vendorOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid category, subcategory, or vendor ID");
        }

        // Create and save the booking
        BookingEntity bookingEntity = new BookingEntity(
        		user,
                categoryOptional.get(),
                subcategoryOptional.get(),
                vendorOptional.get(),
                bookingRequest.getBookingDateStr(),
                bookingRequest.getBookingTimeStr(),
                bookingRequest.getServiceAddress()
        );
        bookingEntity = bookingRepository.save(bookingEntity);

        // Return booking confirmation
        return new BookingConfirmationDTO(
                bookingEntity.getId(),
                bookingEntity.getUser().getUserId(),
                bookingEntity.getCategory().getName(),
                bookingEntity.getSubcategory().getName(),
                bookingEntity.getVendor().getName(),
                bookingEntity.getBookingDateStr(),
                bookingEntity.getBookingTimeStr(),
                bookingEntity.getServiceAddress()
        );
    }

    public Optional<BookingConfirmationDTO> getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId)
                .map(bookingEntity -> new BookingConfirmationDTO(
                        bookingEntity.getId(),
                        bookingEntity.getUser().getUserId(),
                        bookingEntity.getCategory().getName(),
                        bookingEntity.getSubcategory().getName(),
                        bookingEntity.getVendor().getName(),
                        bookingEntity.getBookingDateStr(),
                        bookingEntity.getBookingTimeStr(),
                        bookingEntity.getServiceAddress()
                ));
    }
    
    public List<BookingConfirmationDTO> getBookingsByUser(HttpSession session) {
        UserResponseDto user = (UserResponseDto) session.getAttribute("user");

        if (user == null) {
            throw new IllegalArgumentException("User not logged in");
        }

        return bookingRepository.findByUser_UserId(user.getUserId())
                .stream()
                .map(booking -> new BookingConfirmationDTO(
                        booking.getId(),
                        booking.getUser().getUserId(),
                        booking.getCategory().getName(),
                        booking.getSubcategory().getName(),
                        booking.getVendor().getName(),
                        booking.getBookingDateStr(),
                        booking.getBookingTimeStr(),
                        booking.getServiceAddress()
                ))
                .collect(Collectors.toList());
    }

}

