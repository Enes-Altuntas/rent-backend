package com.example.rent.Service.Renter;

import com.example.rent.DTO.Renter.Create.CreateRenterDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.DTO.Renter.Update.UpdateRenterDTO;

import java.util.List;

public interface RenterService {

    GetRenterDTO saveRenter(CreateRenterDTO createRenterDTO);

    GetRenterDTO updateRenter(UpdateRenterDTO updateRenterDTO);

    List<GetRenterDTO> getAllRenters();

    GetRenterDTO getRenter(Integer id);

    void deleteRenter(Integer id);

}
