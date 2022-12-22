package com.example.rent.Mapper.Payment;

import com.example.rent.DTO.Payment.GetPaymentDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Entity.Payment.Payment;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {GetPaymentFileEntityToDTOMapper.class})
public interface GetPaymentEntityToDTOMapper extends BaseEntityMapper<Payment, GetPaymentDTO> {
    @Mapping(source = "id", target = "paymentId")
    @Mapping(source = "flat.flatNumber", target = "flatNumber")
    @Mapping(source = "flat.apartment", target = "address", qualifiedByName = "getAddress")
    @Override
    GetPaymentDTO fromEntityToDTO(Payment payment);

    @Named("getAddress")
    default String getAddress(Apartment apartment) {
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
