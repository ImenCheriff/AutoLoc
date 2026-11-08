package tn.esprit.tic.cce.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.cce.autoloc.service.ClientService;
import tn.esprit.tic.cce.autoloc.web.dto.ClientDTO;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
@Tag(name = "Clients", description = "CRUD des clients")
public class ClientController {

    private ClientService clientService;

    @Operation(summary = "Lister tous les clients")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping
    public List<ClientDTO> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Créer un client")
    @ApiResponse(responseCode = "201", description = "Client créé")
    @PostMapping
    public ClientDTO addClient(@Valid @RequestBody ClientDTO client) {
        return clientService.addClient(client);
    }

    @Operation(summary = "Mettre à jour un client")
    @ApiResponse(responseCode = "200", description = "Client mis à jour")
    @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable("id") Long idClient,@Valid @RequestBody ClientDTO client) {
        return clientService.updateClient(idClient, client);
    }

    @Operation(summary = "Récupérer un client par id")
    @ApiResponse(responseCode = "200", description = "Client trouvé")
    @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    @GetMapping("/{id}")
    public ClientDTO retrieveClient(@PathVariable("id") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @Operation(summary = "Supprimer un client")
    @ApiResponse(responseCode = "204", description = "Client supprimé")
    @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable("id") Long idClient) {
        clientService.removeClient(idClient);
    }

    @Operation(summary = "Ajouter plusieurs clients")
    @PostMapping("/batch")
    public List<ClientDTO> addClients(@Valid @RequestBody List<ClientDTO> clients) {
        return clientService.addClients(clients);
    }
}
