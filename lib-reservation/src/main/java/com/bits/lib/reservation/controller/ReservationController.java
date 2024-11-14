package com.bits.lib.reservation.controller;

import com.bits.lib.reservation.entity.Reservations;
import com.bits.lib.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserve")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservations> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservations getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public Reservations reserveBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return reservationService.reserveBook(userId, bookId);
    }

    @DeleteMapping("/{id}")
    public Reservations cancelReservation(@PathVariable Long id) {
        return reservationService.cancelReservation(id);
    }
}