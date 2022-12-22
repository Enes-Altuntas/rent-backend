package com.example.rent.Response.Recap;

import com.example.rent.Response.Flat.Get.GetFlatRecapResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRecapResponse {

    private Integer renterId;

    private Integer renterCode;

    private String renterName;

    private List<GetFlatRecapResponse> flatList;

}
