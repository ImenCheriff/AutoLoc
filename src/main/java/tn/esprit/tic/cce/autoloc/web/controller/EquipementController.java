package tn.esprit.tic.cce.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import tn.esprit.tic.cce.autoloc.domain.Equipement;
import tn.esprit.tic.cce.autoloc.service.EquipementService;

import java.util.List;

@Controller
@AllArgsConstructor
public class EquipementController {

    EquipementService equipementService;

    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    public Equipement addEquipement(Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    public Equipement updateEquipement(Equipement equipement) {
        return equipementService.updateEquipement(equipement);
    }

    public Equipement retrieveEquipement(Long idEquipement) {
        return equipementService.retrieveEquipement(idEquipement);
    }

    public void removeEquipement(Long idEquipement) {
        equipementService.removeEquipement(idEquipement);
    }

    public List<Equipement> addEquipements(List<Equipement> equipements) {
        return equipementService.addEquipements(equipements);
    }
}
