package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterPaymentDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Entity.Payment.Payment;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {GetRenterFileEntityToDTOMapper.class})
public interface GetRenterPaymentEntityToDTOMapper extends BaseEntityMapper<Payment, GetRenterPaymentDTO> {
    @Mapping(source = "id", target = "paymentId")
    @Mapping(source = "flat.flatNumber", target = "flatNumber")
    @Mapping(source = "flat.apartment", target = "address", qualifiedByName = "getAddressFromApartment")
    @Override
    GetRenterPaymentDTO fromEntityToDTO(Payment payment);

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
