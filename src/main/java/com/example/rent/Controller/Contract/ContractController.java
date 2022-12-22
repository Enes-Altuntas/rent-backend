package com.example.rent.Controller.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.Mapper.Contract.Create.CreateContractDTOToResponseMapper;
import com.example.rent.Mapper.Contract.Create.CreateContractRequestToDTOMapper;
import com.example.rent.Mapper.Contract.Delete.DeleteContractDTOToResponseMapper;
import com.example.rent.Mapper.Contract.Delete.DeleteContractRequestToDTOMapper;
import com.example.rent.Request.Contract.Create.CreateContractRequest;
import com.example.rent.Request.Contract.Delete.DeleteContractRequest;
import com.example.rent.Response.Contract.Create.CreateContractResponse;
import com.example.rent.Response.Contract.Delete.DeleteContractResponse;
import com.example.rent.Service.Contract.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/contract")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;
    private final CreateContractRequestToDTOMapper createContractRequestToDTOMapper;
    private final CreateContractDTOToResponseMapper createContractDTOToResponseMapper;
    private final DeleteContractDTOToResponseMapper deleteContractDTOToResponseMapper;
    private final DeleteContractRequestToDTOMapper deleteContractRequestToDTOMapper;

    @PostMapping("/create")
    public ResponseEntity<CreateContractResponse> createContract(@Valid @RequestBody CreateContractRequest createContractRequest) {
        CreateContractDTO createContractDTO = createContractRequestToDTOMapper.fromRequestToDTO(createContractRequest);

        CreateContractDTO contractDTO = contractService.createContract(createContractDTO);

        CreateContractResponse createContractResponse = createContractDTOToResponseMapper.fromDTOToResponse(contractDTO);

        return new ResponseEntity<>(createContractResponse, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<DeleteContractResponse> deleteContract(@Valid @RequestBody DeleteContractRequest deleteContractRequest) {
        DeleteContractDTO deleteContractDTO = deleteContractRequestToDTOMapper.fromRequestToDTO(deleteContractRequest);

        DeleteContractDTO contractDTO = contractService.deleteContract(deleteContractDTO);

        DeleteContractResponse deleteContractResponse = deleteContractDTOToResponseMapper.fromDTOToResponse(contractDTO);

        return new ResponseEntity<>(deleteContractResponse, HttpStatus.OK);
    }
}
