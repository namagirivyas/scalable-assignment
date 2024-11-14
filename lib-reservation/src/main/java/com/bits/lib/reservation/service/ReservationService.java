package com.bits.lib.reservation.service;

import com.bits.lib.reservation.entity.Books;
import com.bits.lib.reservation.entity.Reservations;
import com.bits.lib.reservation.repo.ReservationRepository;
import jakarta.ws.rs.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    private BookClient bookManagementClient;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservations> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservations getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public Reservations reserveBook(Long userId, Long bookId) {

        Books books = bookManagementClient.getBookById(bookId);

        if (books == null) {
            throw new BadRequestException("Book with ID " + bookId + " not found.");
        }

        Reservations reservation = new Reservations(userId, books.getId(), LocalDateTime.now(), "ACTIVE");
        return reservationRepository.save(reservation);
    }

    public Reservations cancelReservation(Long id) {
        Reservations reservation = reservationRepository.findById(id).orElseThrow();
        reservation.setStatus("CANCELLED");
        return reservationRepository.save(reservation);
    }
}