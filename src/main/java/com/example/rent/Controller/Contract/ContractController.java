package com.example.rent.Controller.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.Mapper.Contract.Create.CreateContractRequestToDTOMapper;
import com.example.rent.Mapper.Contract.Delete.DeleteContractRequestToDTOMapper;
import com.example.rent.Mapper.Renter.Get.GetRenterDTOToResponseMapper;
import com.example.rent.Request.Contract.Create.CreateContractRequest;
import com.example.rent.Request.Contract.Delete.DeleteContractRequest;
import com.example.rent.Response.Renter.Get.GetRenterResponse;
import com.example.rent.Service.Contract.ContractService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contract")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class ContractController {

  private final ContractService contractService;
  private final CreateContractRequestToDTOMapper createContractRequestToDTOMapper;
  private final DeleteContractRequestToDTOMapper deleteContractRequestToDTOMapper;
  private final GetRenterDTOToResponseMapper getRenterDTOToResponseMapper;

  @PostMapping("/create")
  public ResponseEntity<GetRenterResponse> createContract(
      @Valid @RequestBody CreateContractRequest createContractRequest) {
    CreateContractDTO createContractDTO = createContractRequestToDTOMapper.fromRequestToDTO(
        createContractRequest);

    GetRenterDTO getRenterDTO = contractService.createContract(createContractDTO);

    GetRenterResponse getRenterResponse = getRenterDTOToResponseMapper.fromDTOToResponse(
        getRenterDTO);

    return new ResponseEntity<>(getRenterResponse, HttpStatus.OK);
  }

  @PostMapping("/delete")
  public ResponseEntity<GetRenterResponse> deleteContract(
      @Valid @RequestBody DeleteContractRequest deleteContractRequest) {
    DeleteContractDTO deleteContractDTO = deleteContractRequestToDTOMapper.fromRequestToDTO(
        deleteContractRequest);

    GetRenterDTO getRenterDTO = contractService.deleteContract(deleteContractDTO);

    GetRenterResponse getRenterResponse = getRenterDTOToResponseMapper.fromDTOToResponse(
        getRenterDTO);

    return new ResponseEntity<>(getRenterResponse, HttpStatus.OK);
  }
}
