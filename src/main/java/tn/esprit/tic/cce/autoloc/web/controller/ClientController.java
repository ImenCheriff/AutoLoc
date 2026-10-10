package tn.esprit.tic.cce.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import tn.esprit.tic.cce.autoloc.domain.Client;
import tn.esprit.tic.cce.autoloc.service.ClientService;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {

    ClientService clientService;

    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    public Client addClient(Client client) {
        return clientService.addClient(client);
    }

    public Client updateClient(Client client) {
        return clientService.updateClient(client);
    }

    public Client retrieveClient(Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    public void removeClient(Long idClient) {
        clientService.removeClient(idClient);
    }

    public List<Client> addClients(List<Client> clients) {
        return clientService.addClients(clients);
    }
}
