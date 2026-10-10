package tn.esprit.tic.cce.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import tn.esprit.tic.cce.autoloc.domain.Employe;
import tn.esprit.tic.cce.autoloc.service.EmployeService;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeController {

    EmployeService employeService;

    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    public Employe addEmploye(Employe employe) {
        return employeService.addEmploye(employe);
    }

    public Employe updateEmploye(Employe employe) {
        return employeService.updateEmploye(employe);
    }

    public Employe retrieveEmploye(Long idEmploye) {
        return employeService.retrieveEmploye(idEmploye);
    }

    public void removeEmploye(Long idEmploye) {
        employeService.removeEmploye(idEmploye);
    }

    public List<Employe> addEmployes(List<Employe> employes) {
        return employeService.addEmployes(employes);
    }
}
