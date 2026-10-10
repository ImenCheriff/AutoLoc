package tn.esprit.tic.cce.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import tn.esprit.tic.cce.autoloc.domain.Agence;
import tn.esprit.tic.cce.autoloc.service.AgenceService;
import tn.esprit.tic.cce.autoloc.service.IAgenceService;

import java.util.List;

@Controller
@AllArgsConstructor
public class AgenceController {

    AgenceService agenceService;

    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    public Agence addAgence(Agence agence) {
        return agenceService.addAgence(agence);
    }

    public Agence updateAgence(Agence agence) {
        return agenceService.updateAgence(agence);
    }

    public Agence retrieveAgence(Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    public void removeAgence(Long idAgence) {
        agenceService.removeAgence(idAgence);
    }

    public List<Agence> addAgences(List<Agence> agences) {
        return agenceService.addAgences(agences);
    }
}
