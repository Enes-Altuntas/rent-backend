package com.example.rent.DTO.Contract.Create;

import com.example.rent.DTO.Apartment.Get.GetApartmentRenterDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateContractDTO {

    private Integer apartmentId;

    private Integer flatId;

    private Integer renterId;

    private Date startDate;

    private Integer paymentDue;

    private GetApartmentRenterDTO renter;
}
