package com.example.rent.Mapper.Flat.Get;

import com.example.rent.DTO.Flat.Get.GetFlatDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Mapper.Apartment.Get.GetApartmentRenterDTOFromEntityMapper;
import com.example.rent.Mapper.BaseEntityMapper;
import com.example.rent.Mapper.Currency.GetCurrencyDTOFromEntityMapper;
import com.example.rent.Mapper.FlatType.GetFlatTypeDTOFromEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {GetApartmentRenterDTOFromEntityMapper.class, GetCurrencyDTOFromEntityMapper.class, GetFlatTypeDTOFromEntityMapper.class})
public interface GetFlatDTOFromEntityMapper extends BaseEntityMapper<Flat, GetFlatDTO> {
    @Mapping(source = "id", target = "flatId")
    @Mapping(source = "apartment.id", target = "apartmentId")
    @Override
    GetFlatDTO fromEntityToDTO(Flat flat);
}