package com.bits.lib.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDateTime reservationDate;
    private String status;

    public Reservations(Long userId, Long bookId, LocalDateTime reservationDate, String status) {
        this.userId = userId;
        this.bookId = bookId;
        this.reservationDate = reservationDate;
        this.status = status;
    }
}