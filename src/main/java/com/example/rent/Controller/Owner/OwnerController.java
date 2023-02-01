package com.example.rent.Controller.Owner;

import com.example.rent.DTO.Flat.Get.GetFlatOwnerDTO;
import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import com.example.rent.Mapper.Flat.Get.GetFlatOwnerResponseFromDTOMapper;
import com.example.rent.Mapper.Owner.CreateOwnerDTOToResponseMapper;
import com.example.rent.Mapper.Owner.CreateOwnerRequestToDTOMapper;
import com.example.rent.Request.Owner.CreateOwnerRequest;
import com.example.rent.Response.Flat.Get.GetFlatOwnerResponse;
import com.example.rent.Response.Owner.Create.CreateOwnerResponse;
import com.example.rent.Service.Owner.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class OwnerController {

    private final CreateOwnerRequestToDTOMapper createOwnerRequestToDTOMapper;
    private final CreateOwnerDTOToResponseMapper createOwnerDTOToResponseMapper;
    private final GetFlatOwnerResponseFromDTOMapper getFlatOwnerResponseFromDTOMapper;
    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<CreateOwnerResponse> saveOwner(@RequestBody @Valid CreateOwnerRequest createOwnerRequest) {
        CreateOwnerDTO createOwnerDTO = createOwnerRequestToDTOMapper.fromRequestToDTO(createOwnerRequest);

        CreateOwnerDTO ownerDTO = ownerService.saveOwner(createOwnerDTO);

        CreateOwnerResponse createOwnerResponse = createOwnerDTOToResponseMapper.fromDTOToResponse(ownerDTO);

        return new ResponseEntity<>(createOwnerResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetFlatOwnerResponse>> getOwnerAsDropdown() {
        List<GetFlatOwnerDTO> getFlatOwnerDTOS = ownerService.getOwnerAsDropdown();

        List<GetFlatOwnerResponse> getFlatOwnerResponses =
                getFlatOwnerResponseFromDTOMapper.fromDTOListToResponseList(getFlatOwnerDTOS);

        return new ResponseEntity<>(getFlatOwnerResponses, HttpStatus.OK);
    }

}
