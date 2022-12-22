package com.example.rent.Service.Flat;

import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.DTO.Flat.Get.GetFlatDTO;
import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;

import java.util.List;

public interface FlatService {
    GetFlatDTO saveFlat(CreateFlatDTO createFlatDTO);

    void deleteFlat(Integer id);

    GetFlatDTO updateFlat(UpdateFlatDTO updateFlatDTO);

    List<GetFlatDTO> getAllFlat();

    GetFlatDTO getFlat(Integer id);

}
