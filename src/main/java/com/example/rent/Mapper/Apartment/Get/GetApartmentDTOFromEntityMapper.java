package com.example.rent.Mapper.Apartment.Get;

import com.example.rent.DTO.Apartment.Get.GetApartmentDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Mapper.BaseEntityMapper;
import com.example.rent.Mapper.Flat.Get.GetFlatDTOFromEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GetFlatDTOFromEntityMapper.class})
public interface GetApartmentDTOFromEntityMapper extends BaseEntityMapper<Apartment, GetApartmentDTO> {
    @Mapping(source = "id", target = "apartmentId")
    @Override
    GetApartmentDTO fromEntityToDTO(Apartment apartment);
}