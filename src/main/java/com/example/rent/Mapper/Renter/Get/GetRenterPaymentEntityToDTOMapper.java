package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterPaymentDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Payment.Payment;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {GetRenterFileEntityToDTOMapper.class})
public interface GetRenterPaymentEntityToDTOMapper extends BaseEntityMapper<Payment, GetRenterPaymentDTO> {
    @Mapping(source = "id", target = "paymentId")
    @Mapping(source = "flat", target = "address", qualifiedByName = "getAddressFromApartment")
    @Mapping(source = "flat.id", target = "flatId")
    @Override
    GetRenterPaymentDTO fromEntityToDTO(Payment payment);

    @Named("getAddressFromApartment")
    default String getAddressFromApartment(Flat flat) {
        return flat.getApartment().getNeighborhood() +
                " Mah. " +
                flat.getApartment().getStreetName() +
                " Sok. " +
                flat.getApartment().getApartmentName() +
                " Apt. " +
                "No." +
                flat.getApartment().getNumber() +
                " Daire: " +
                flat.getFlatNumber() +
                " " +
                flat.getApartment().getState() +
                " / " +
                flat.getApartment().getCity();
    }
}
