package com.example.rent.Mapper.Apartment.Update;

import com.example.rent.DTO.Apartment.Update.UpdateApartmentDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Mapper.BaseEntityMapper;
import com.example.rent.Mapper.Flat.Get.GetFlatDTOFromEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {GetFlatDTOFromEntityMapper.class})
public interface UpdateApartmentDTOFromEntityMapper extends BaseEntityMapper<Apartment, UpdateApartmentDTO> {
    @Mapping(source = "id",target = "apartmentId")
    @Override
    UpdateApartmentDTO fromEntityToDTO(Apartment apartment);
}
