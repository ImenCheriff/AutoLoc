package tn.esprit.tic.cce.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Client;
import tn.esprit.tic.cce.autoloc.repository.ClientRepository;
import tn.esprit.tic.cce.autoloc.web.dto.ClientDTO;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService{

    ClientRepository clientRepository;

    @Override
    public List<ClientDTO> retrieveAllClients() {
        return clientRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public ClientDTO addClient(ClientDTO c) {
        return convertToDto(clientRepository.save(convertToEntity(c)));
    }

    @Override
    public ClientDTO updateClient(Long idClient, ClientDTO dto) {
        Client client = clientRepository.findById(idClient).orElse(null);
        if (client == null) {
            return null;
        }
        else {
            client.setNom(dto.getNom());
            client.setPrenom(dto.getPrenom());
            client.setEmail(dto.getEmail());
            client.setTelephone(dto.getTelephone());
            client.setNumPermis(dto.getNumPermis());
            client.setDateInscription(LocalDate.parse(dto.getDateInscription()));
            return convertToDto(clientRepository.save(client));
        }
    }

    @Override
    public ClientDTO retrieveClient(Long idClient) {
        return convertToDto(clientRepository.findById(idClient).orElse(null));
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public List<ClientDTO> addClients(List<ClientDTO> clients) {
        return clients.stream().map(this::addClient).toList();
    }

    private ClientDTO convertToDto(Client c) {
        ClientDTO dto = new ClientDTO();
        dto.setNom(c.getNom());
        dto.setPrenom(c.getPrenom());
        dto.setEmail(c.getEmail());
        dto.setTelephone(c.getTelephone());
        dto.setNumPermis(c.getNumPermis());
        dto.setDateInscription(String.valueOf(c.getDateInscription()));
        return dto;
    }

    private Client convertToEntity(ClientDTO dto) {
        Client c = new Client();
        c.setNom(dto.getNom());
        c.setPrenom(dto.getPrenom());
        c.setEmail(dto.getEmail());
        c.setTelephone(dto.getTelephone());
        c.setNumPermis(dto.getNumPermis());
        c.setDateInscription(LocalDate.parse(dto.getDateInscription()));
        return c;
    }
}
