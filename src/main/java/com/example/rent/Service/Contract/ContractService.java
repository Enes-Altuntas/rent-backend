package com.example.rent.Service.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.DTO.Renter.Get.GetRenterFlatDTO;

import java.util.List;

public interface ContractService {

    List<GetRenterFlatDTO> createContract(CreateContractDTO createContractDTO);

    List<GetRenterFlatDTO> deleteContract(DeleteContractDTO deleteContractDTO);

}
