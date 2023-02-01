package com.example.rent.Service.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;

public interface ContractService {

  GetRenterDTO createContract(CreateContractDTO createContractDTO);

  GetRenterDTO deleteContract(DeleteContractDTO deleteContractDTO);

}
