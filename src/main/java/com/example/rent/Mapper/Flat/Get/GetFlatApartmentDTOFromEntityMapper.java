package com.example.rent.Mapper.Flat.Get;

import com.example.rent.DTO.Flat.Get.GetFlatApartmentDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GetFlatDTOFromEntityMapper.class})
public interface GetFlatApartmentDTOFromEntityMapper extends BaseEntityMapper<Apartment, GetFlatApartmentDTO> {
    @Mapping(source = "id", target = "apartmentId")
    @Override
    GetFlatApartmentDTO fromEntityToDTO(Apartment apartment);
}
