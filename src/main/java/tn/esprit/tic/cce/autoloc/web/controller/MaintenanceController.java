package tn.esprit.tic.cce.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import tn.esprit.tic.cce.autoloc.domain.Maintenance;
import tn.esprit.tic.cce.autoloc.service.MaintenanceService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MaintenanceController {

    MaintenanceService maintenanceService;

    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    public Maintenance updateMaintenance(Maintenance maintenance) {
        return maintenanceService.updateMaintenance(maintenance);
    }

    public Maintenance retrieveMaintenance(Long idMaintenance) {
        return maintenanceService.retrieveMaintenance(idMaintenance);
    }

    public void removeMaintenance(Long idMaintenance) {
        maintenanceService.removeMaintenance(idMaintenance);
    }

    public List<Maintenance> addMaintenances(List<Maintenance> maintenances) {
        return maintenanceService.addMaintenances(maintenances);
    }
}
