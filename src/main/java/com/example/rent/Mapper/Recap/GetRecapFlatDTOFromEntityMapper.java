package com.example.rent.Mapper.Recap;

import com.example.rent.DTO.Recap.GetRecapFlatDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatContract.FlatContract;
import com.example.rent.Entity.Payment.Payment;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface GetRecapFlatDTOFromEntityMapper extends BaseEntityMapper<Flat, GetRecapFlatDTO> {

    @Mapping(source = "id",target = "flatId")
    @Mapping(source = "apartment.apartmentName" , target = "apartmentName")
    @Mapping(source = "flatType.flatTypeValue" , target = "flatType")
    @Mapping(source = "currency.currencyValue" , target = "currency")
    @Mapping(source = "flatContract" , target = "status", qualifiedByName = "getStatus")
    @Override
    GetRecapFlatDTO fromEntityToDTO(Flat flat);

    @Named("getStatus")
    default String getStatus(FlatContract flatContract) {
        LocalDate currentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int currentDay = currentDate.getDayOfMonth();

        LocalDate startDate = flatContract.getStartDate().toInstant().atZone((ZoneId.systemDefault())).toLocalDate();
        int paymentStartDay = startDate.getDayOfMonth();
        int paymentEndDay = paymentStartDay + flatContract.getPaymentDue();

        Optional<Payment> payment = flatContract.getPayment().stream().filter(x -> {
            LocalDate paymentDate = x.getPaymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int paymentMonth = paymentDate.getMonthValue();
            int paymentYear = paymentDate.getYear();
            return paymentMonth == currentMonth && paymentYear == currentYear;
        }).findFirst();

        if(payment.isPresent()) {
            return "Kira Ödendi";
        }
        else {
            if(currentDay < paymentEndDay) {
                return "Kira Bekleniyor";
            }
            else {
                return "Kira Gecikti";
            }
        }
    }
}
