package com.example.rent.Mapper.Apartment.Get;


import com.example.rent.DTO.Apartment.Get.GetApartmentRenterDTO;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.BaseEntityMapper;
import com.example.rent.Mapper.Flat.Get.GetFlatDTOFromEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GetFlatDTOFromEntityMapper.class})
public interface GetApartmentRenterDTOFromEntityMapper extends BaseEntityMapper<Renter, GetApartmentRenterDTO> {
    @Mapping(source = "id", target = "renterId")
    @Override
    GetApartmentRenterDTO fromEntityToDTO(Renter renter);
}
