package com.example.rent.Service.FlatStatus;

import com.example.rent.DTO.FlatStatus.GetFlatStatusDTO;

import java.util.List;

public interface FlatStatusService {

    List<GetFlatStatusDTO> getFlatStatusAsDropdown();

}
