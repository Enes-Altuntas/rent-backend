package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterFlatDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Mapper.BaseEntityMapper;
import com.example.rent.Mapper.Currency.GetCurrencyDTOFromEntityMapper;
import com.example.rent.Mapper.FlatType.GetFlatTypeDTOFromEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {GetCurrencyDTOFromEntityMapper.class, GetFlatTypeDTOFromEntityMapper.class})
public interface GetRenterFlatEntityToDTOMapper extends BaseEntityMapper<Flat, GetRenterFlatDTO> {
    @Mapping(source = "id", target = "flatId")
    @Mapping(source = "apartment", target = "address", qualifiedByName = "getAddressFromApartment")
    @Override
    GetRenterFlatDTO fromEntityToDTO(Flat flat);

    @Named("getAddressFromApartment")
    default String getAddressFromApartment(Apartment apartment) {
        return apartment.getNeighborhood() +
                " Mah. " +
                apartment.getStreetName() +
                " Sok. " +
                apartment.getApartmentName() +
                " Apt. " +
                "No. " +
                apartment.getNumber() +
                " " +
                apartment.getState() +
                "/" +
                apartment.getCity();
    }
}
