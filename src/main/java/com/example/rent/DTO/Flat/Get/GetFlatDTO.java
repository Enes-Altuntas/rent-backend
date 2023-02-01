package com.example.rent.DTO.Flat.Get;

import com.example.rent.DTO.Apartment.Get.GetApartmentRenterDTO;
import com.example.rent.DTO.Currency.GetCurrencyDTO;
import com.example.rent.DTO.Employee.GetEmployeeDTO;
import com.example.rent.DTO.FlatStatus.GetFlatStatusDTO;
import com.example.rent.DTO.FlatType.GetFlatTypeDTO;
import com.example.rent.DTO.FlatUsage.GetFlatUsageDTO;
import lombok.Data;

import java.util.List;

@Data
public class GetFlatDTO {

    private Integer apartmentId;

    private Integer flatId;

    private Integer flatNumber;

    private GetFlatTypeDTO flatType;

    private Integer flatPrice;

    private GetCurrencyDTO currency;

    private Integer flatArea;

    private GetApartmentRenterDTO renter;

    private GetFlatStatusDTO flatStatus;

    private GetFlatUsageDTO flatUsage;

    private GetEmployeeDTO employee;

    private List<GetFlatOwnerDTO> flatOwners;

}
