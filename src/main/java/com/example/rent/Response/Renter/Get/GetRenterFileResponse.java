package com.example.rent.Response.Renter.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRenterFileResponse {

    private Integer fileId;

    private String name;

    private String url;

    private String type;

    private long size;

}
