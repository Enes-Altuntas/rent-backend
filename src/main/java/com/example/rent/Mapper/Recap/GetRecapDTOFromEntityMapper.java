package com.example.rent.Mapper.Recap;

import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.FlatContract.FlatContract;
import com.example.rent.Entity.Payment.Payment;
import com.example.rent.Mapper.BaseEntityMapper;
import com.example.rent.Mapper.Employee.GetEmployeeDTOFromEntityMapper;
import com.example.rent.Mapper.FlatStatus.GetFlatStatusDTOFromEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {GetEmployeeDTOFromEntityMapper.class, GetFlatStatusDTOFromEntityMapper.class})
public interface GetRecapDTOFromEntityMapper extends BaseEntityMapper<Flat, GetRecapDTO> {
    @Mapping(source = "id", target = "flatId")
    @Mapping(source = "renter.id", target = "renterId")
    @Mapping(source = "flatNumber", target = "flatNumber")
    @Mapping(source = "apartment.apartmentName", target = "apartmentName")
    @Mapping(source = "apartment.city", target = "city")
    @Mapping(source = "apartment.state", target = "state")
    @Mapping(source = "flatContract", target = "paymentStatus", qualifiedByName = "getStatus")
    @Override
    GetRecapDTO fromEntityToDTO(Flat flat);

    @Named("getStatus")
    default String getStatus(FlatContract flatContract) {
        if (Objects.isNull(flatContract)) {
            return "Boş Daire";
        }

        if (flatContract.getFlat().getFlatStatus().getId().equals(99991)) {

            if (!CollectionUtils.isEmpty(flatContract.getPayment())) {
                return "Satıldı";
            }

        }

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

        if (payment.isPresent()) {
            return "Kira Ödendi";
        } else {
            if (currentDay < paymentEndDay) {
                return "Kira Bekleniyor";
            } else {
                return "Kira Gecikti";
            }
        }
    }
}
