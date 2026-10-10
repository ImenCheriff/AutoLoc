package tn.esprit.tic.cce.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.service.VehiculeService;

import java.util.List;

@Controller
@AllArgsConstructor
public class VehiculeController {

    VehiculeService vehiculeService;

    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    public Vehicule updateVehicule(Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    public void removeVehicule(Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }

    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return vehiculeService.addVehicules(vehicules);
    }
}
