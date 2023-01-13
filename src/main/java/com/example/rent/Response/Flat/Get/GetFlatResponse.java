package com.example.rent.Response.Flat.Get;

import com.example.rent.Response.Apartment.GetApartmentRenterResponse;
import com.example.rent.Response.Currency.GetCurrencyResponse;
import com.example.rent.Response.Employee.GetEmployeeResponse;
import com.example.rent.Response.FlatStatus.GetFlatStatusResponse;
import com.example.rent.Response.FlatType.GetFlatTypeResponse;
import com.example.rent.Response.FlatUsage.GetFlatUsageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatResponse {

    private Integer apartmentId;

    private Integer flatId;

    private Integer flatNumber;

    private GetFlatTypeResponse flatType;

    private Integer flatPrice;

    private GetCurrencyResponse currency;

    private Integer flatArea;

    private GetApartmentRenterResponse renter;

    private GetEmployeeResponse employee;

    private List<GetFlatOwnerResponse> flatOwners;

    private GetFlatStatusResponse flatStatus;

    private GetFlatUsageResponse flatUsage;

}
