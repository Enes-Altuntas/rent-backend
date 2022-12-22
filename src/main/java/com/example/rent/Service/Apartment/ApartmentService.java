package com.example.rent.Service.Apartment;

import com.example.rent.DTO.Apartment.Create.CreateApartmentDTO;
import com.example.rent.DTO.Apartment.Get.GetApartmentDTO;
import com.example.rent.DTO.Apartment.Update.UpdateApartmentDTO;

import java.util.List;

public interface ApartmentService {
    GetApartmentDTO saveApartment(CreateApartmentDTO createApartmentDTO);

    void deleteApartment(Integer id);

    List<GetApartmentDTO> getAllApartments();

    UpdateApartmentDTO updateApartment(UpdateApartmentDTO updateApartmentDTO);

}
