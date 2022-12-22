package com.example.rent.Controller.Owner;

import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import com.example.rent.Mapper.Owner.CreateOwnerDTOToResponseMapper;
import com.example.rent.Mapper.Owner.CreateOwnerRequestToDTOMapper;
import com.example.rent.Request.Owner.CreateOwnerRequest;
import com.example.rent.Response.Owner.Create.CreateOwnerResponse;
import com.example.rent.Service.Owner.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/owner")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class OwnerController {

    private final CreateOwnerRequestToDTOMapper createOwnerRequestToDTOMapper;
    private final CreateOwnerDTOToResponseMapper createOwnerDTOToResponseMapper;
    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<CreateOwnerResponse> saveOwner(@RequestBody @Valid CreateOwnerRequest createOwnerRequest) {
        CreateOwnerDTO createOwnerDTO = createOwnerRequestToDTOMapper.fromRequestToDTO(createOwnerRequest);

        CreateOwnerDTO ownerDTO = ownerService.saveOwner(createOwnerDTO);

        CreateOwnerResponse createOwnerResponse = createOwnerDTOToResponseMapper.fromDTOToResponse(ownerDTO);

        return new ResponseEntity<>(createOwnerResponse, HttpStatus.CREATED);
    }

}
