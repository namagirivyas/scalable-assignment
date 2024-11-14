package com.bits.lib.reservation.repo;

import com.bits.lib.reservation.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {
}
