package com.example.rent.Service.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;

public interface ContractService {

    CreateContractDTO createContract(CreateContractDTO createContractDTO);

    DeleteContractDTO deleteContract(DeleteContractDTO deleteContractDTO);

}
