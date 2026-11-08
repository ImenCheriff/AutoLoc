package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.web.dto.ClientDTO;

import java.util.List;

public interface IClientService {

    List<ClientDTO> retrieveAllClients();
    ClientDTO addClient(ClientDTO c);
    ClientDTO updateClient(Long idClient, ClientDTO c);
    ClientDTO retrieveClient(Long idClient);
    void removeClient(Long idClient);
    List<ClientDTO> addClients (List<ClientDTO> clients);
}
