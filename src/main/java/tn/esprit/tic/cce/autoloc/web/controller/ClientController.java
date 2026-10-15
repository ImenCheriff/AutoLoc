package tn.esprit.tic.cce.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.cce.autoloc.domain.Client;
import tn.esprit.tic.cce.autoloc.service.ClientService;

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
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Créer un client")
    @ApiResponse(responseCode = "201", description = "Client créé")
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @Operation(summary = "Mettre à jour un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client mis à jour"),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @Operation(summary = "Récupérer un client par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public Client retrieveClient(@PathVariable("id") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @Operation(summary = "Supprimer un client")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Client supprimé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable("id") Long idClient) {
        clientService.removeClient(idClient);
    }

    @Operation(summary = "Ajouter plusieurs clients")
    @PostMapping("/batch")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.addClients(clients);
    }
}
