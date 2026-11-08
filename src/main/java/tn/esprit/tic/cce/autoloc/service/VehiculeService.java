package tn.esprit.tic.cce.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.repository.VehiculeRepository;
import tn.esprit.tic.cce.autoloc.web.VehiculeMapper;
import tn.esprit.tic.cce.autoloc.web.dto.VehiculeDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeService implements IVehiculeService{

    VehiculeRepository vehiculeRepository;
    VehiculeMapper mp;

    @Override
    public List<VehiculeDTO> retrieveAllVehicules() {
        return mp.toDtoList(vehiculeRepository.findAll());    }

    @Override
    public VehiculeDTO addVehicule(VehiculeDTO v) {
        return mp.toDto(vehiculeRepository.save(mp.toEntity(v)));
    }

    @Override
    public VehiculeDTO updateVehicule(Long idVehicule, VehiculeDTO dto) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        if (vehicule == null) {
            return null;
        }
        else {
            mp.updateEntity(dto, vehicule);
            return mp.toDto(vehiculeRepository.save(vehicule));
        }
    }

    @Override
    public VehiculeDTO retrieveVehicule(Long idVehicule) {
        return mp.toDto(vehiculeRepository.findById(idVehicule).orElse(null));
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    public List<VehiculeDTO> addVehicules(List<VehiculeDTO> vehicules) {
        return mp.toDtoList(vehiculeRepository.saveAll(mp.toEntityList(vehicules)));
    }
}
