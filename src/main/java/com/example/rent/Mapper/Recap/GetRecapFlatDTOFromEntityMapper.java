package com.example.rent.Mapper.Recap;

import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.DTO.Recap.GetRecapFlatDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatContract.FlatContract;
import com.example.rent.Entity.Payment.Payment;
import com.example.rent.Entity.Renter.Renter;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface GetRecapFlatDTOFromEntityMapper extends BaseEntityMapper<Flat, GetRecapFlatDTO> {

    @Mapping(source = "id",target = "flatId")
    @Mapping(source = "apartment.apartmentName" , target = "apartmentName")
   // @Mapping(source = "flatContract" , target = "status", qualifiedByName = "getStatus")
    @Override
    GetRecapFlatDTO fromEntityToDTO(Flat flat);

    //TEST2
    @Named("getStatus")
    default String getStatus(FlatContract flatContract) {
        LocalDate currentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int currentDay = currentDate.getDayOfMonth();

        //if(flatContract.getStartDate())

        Payment payment = flatContract.getPayment().stream().filter(x -> {
            LocalDate paymentDate = x.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int paymentMonth = paymentDate.getMonthValue();
            int paymentYear = paymentDate.getYear();
            return paymentMonth == currentMonth && paymentYear == currentYear;
        }).findFirst().get();

        if(Objects.nonNull(payment)) {

        } else {
            return "Unpaid"; //commit test
        }
        return  null;
    }
}
