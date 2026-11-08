package tn.esprit.tic.cce.autoloc.web;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.web.dto.VehiculeDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(target = "nomAgence", source = "agence.nom")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(target = "idVehicule", ignore = true)
    @Mapping(target = "agence", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "equipements", ignore = true)
    Vehicule toEntity(VehiculeDTO dto);

    List<VehiculeDTO> toDtoList(List<Vehicule> vehicules);

    List<Vehicule> toEntityList(List<VehiculeDTO> dtos);

    @Mapping(target = "idVehicule", ignore = true)
    @Mapping(target = "agence", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "equipements", ignore = true)
    void updateEntity(VehiculeDTO dto, @MappingTarget Vehicule vehicule);
}
