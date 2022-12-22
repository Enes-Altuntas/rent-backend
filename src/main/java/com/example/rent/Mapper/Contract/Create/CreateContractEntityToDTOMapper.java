package com.example.rent.Mapper.Contract.Create;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Mapper.Apartment.Get.GetApartmentRenterDTOFromEntityMapper;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GetApartmentRenterDTOFromEntityMapper.class})
public interface CreateContractEntityToDTOMapper extends BaseEntityMapper<Flat, CreateContractDTO> {
    @Mapping(source = "apartment.id", target = "apartmentId")
    @Mapping(source = "id", target = "flatId")
    @Override
    CreateContractDTO fromEntityToDTO(Flat flat);
}
