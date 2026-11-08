package tn.esprit.tic.cce.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tic.cce.autoloc.domain.CategorieVehicule;
import tn.esprit.tic.cce.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeDTO {
    @NotBlank(message = "L'immatriculation est obligatoire")
    @Size(max = 20, message = "20 caractères maximum")
    private String immatriculation;

    @NotBlank(message = "La marque est obligatoire")
    @Size(max = 50, message = "50 caractères maximum")
    private String marque;

    @NotBlank(message = "Le modèle est obligatoire")
    @Size(max = 50, message = "50 caractères maximum")
    private String modele;

    @NotNull(message = "La catégorie est obligatoire")
    private CategorieVehicule categorie;

    @NotNull(message = "Le tarif journalier est obligatoire")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le tarif doit être positif")
    private BigDecimal tarifJournalier;

    @NotNull(message = "Le statut est obligatoire")
    private StatutVehicule statut;

    private String nomAgence;
}
