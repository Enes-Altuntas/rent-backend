package com.example.rent.Service.Land;

import com.example.rent.DTO.Land.Create.CreateLandDTO;
import com.example.rent.DTO.Land.Get.GetLandDTO;

import java.util.List;

public interface LandService {
    CreateLandDTO saveLand(CreateLandDTO createLandDTO);

    List<GetLandDTO> getAllLands();


}
