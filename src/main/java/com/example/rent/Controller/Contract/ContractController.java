package com.example.rent.Controller.Contract;

import com.example.rent.DTO.Contract.Create.CreateContractDTO;
import com.example.rent.DTO.Contract.Delete.DeleteContractDTO;
import com.example.rent.DTO.Renter.Get.GetRenterFlatDTO;
import com.example.rent.Mapper.Contract.Create.CreateContractRequestToDTOMapper;
import com.example.rent.Mapper.Contract.Delete.DeleteContractRequestToDTOMapper;
import com.example.rent.Mapper.Renter.Get.GetRenterFlatDTOToResponseMapper;
import com.example.rent.Request.Contract.Create.CreateContractRequest;
import com.example.rent.Request.Contract.Delete.DeleteContractRequest;
import com.example.rent.Response.Renter.Get.GetRenterFlatResponse;
import com.example.rent.Service.Contract.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contract")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;
    private final CreateContractRequestToDTOMapper createContractRequestToDTOMapper;
    private final GetRenterFlatDTOToResponseMapper getRenterFlatDTOToResponseMapper;
    private final DeleteContractRequestToDTOMapper deleteContractRequestToDTOMapper;

    @PostMapping("/create")
    public ResponseEntity<List<GetRenterFlatResponse>> createContract(@Valid @RequestBody CreateContractRequest createContractRequest) {
        CreateContractDTO createContractDTO = createContractRequestToDTOMapper.fromRequestToDTO(createContractRequest);

        List<GetRenterFlatDTO> getRenterFlatDTOS = contractService.createContract(createContractDTO);

        List<GetRenterFlatResponse> getRenterFlatResponses = getRenterFlatDTOToResponseMapper.fromDTOListToResponseList(getRenterFlatDTOS);

        return new ResponseEntity<>(getRenterFlatResponses, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<List<GetRenterFlatResponse>> deleteContract(@Valid @RequestBody DeleteContractRequest deleteContractRequest) {
        DeleteContractDTO deleteContractDTO = deleteContractRequestToDTOMapper.fromRequestToDTO(deleteContractRequest);

        List<GetRenterFlatDTO> getRenterFlatDTOS = contractService.deleteContract(deleteContractDTO);

        List<GetRenterFlatResponse> getRenterFlatResponses = getRenterFlatDTOToResponseMapper.fromDTOListToResponseList(getRenterFlatDTOS);

        return new ResponseEntity<>(getRenterFlatResponses, HttpStatus.OK);
    }
}
