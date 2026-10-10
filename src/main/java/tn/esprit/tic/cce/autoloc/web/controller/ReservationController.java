package tn.esprit.tic.cce.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import tn.esprit.tic.cce.autoloc.domain.Reservation;
import tn.esprit.tic.cce.autoloc.service.ReservationService;

import java.util.List;

@Controller
@AllArgsConstructor
public class ReservationController {

    ReservationService reservationService;

    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    public Reservation retrieveReservation(Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }

    public void removeReservation(Long idReservation) {
        reservationService.removeReservation(idReservation);
    }

    public List<Reservation> addReservations(List<Reservation> reservations) {
        return reservationService.addReservations(reservations);
    }
}
