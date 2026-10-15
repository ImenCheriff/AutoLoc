package tn.esprit.tic.cce.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.service.VehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@AllArgsConstructor
@Tag(name = "Véhicules", description = "CRUD des véhicules")
public class VehiculeController {

    private VehiculeService vehiculeService;

    @Operation(summary = "Lister tous les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Créer un véhicule")
    @ApiResponse(responseCode = "201", description = "Véhicule créé")
    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @Operation(summary = "Mettre à jour un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule mis à jour"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    @Operation(summary = "Récupérer un véhicule par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public Vehicule retrieveVehicule(@PathVariable("id") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @Operation(summary = "Supprimer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void removeVehicule(@PathVariable("id") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }

    @Operation(summary = "Ajouter plusieurs véhicules")
    @PostMapping("/batch")
    public List<Vehicule> addVehicules(@RequestBody List<Vehicule> vehicules) {
        return vehiculeService.addVehicules(vehicules);
    }
}