package com.example.rent.Service.Flat;

import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.DTO.Flat.Get.GetFlatDTO;
import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;

import java.util.List;

public interface FlatService {
    List<GetFlatDTO> saveFlat(CreateFlatDTO createFlatDTO);

    List<GetFlatDTO> deleteFlat(Integer id);

    List<GetFlatDTO> updateFlat(UpdateFlatDTO updateFlatDTO);

    List<GetFlatDTO> getAllFlatsOfApartment(Integer apartmentId);

}
