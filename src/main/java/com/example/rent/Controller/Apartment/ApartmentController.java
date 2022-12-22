package com.example.rent.Controller.Apartment;

import com.example.rent.DTO.Apartment.Create.CreateApartmentDTO;
import com.example.rent.DTO.Apartment.Get.GetApartmentDTO;
import com.example.rent.DTO.Apartment.Update.UpdateApartmentDTO;
import com.example.rent.Mapper.Apartment.Create.CreateApartmentRequestToDTOMapper;
import com.example.rent.Mapper.Apartment.Get.GetApartmentResponseFromDTOMapper;
import com.example.rent.Mapper.Apartment.Update.UpdateApartmentRequestToDTOMapper;
import com.example.rent.Request.Apartment.CreateApartmentRequest;
import com.example.rent.Request.Apartment.UpdateApartmentRequest;
import com.example.rent.Response.Apartment.GetApartmentResponse;
import com.example.rent.Service.Apartment.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/apartment")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final CreateApartmentRequestToDTOMapper createApartmentRequestToDTOEntityMapper;
    private final GetApartmentResponseFromDTOMapper getApartmentResponseFromDTOMapper;
    private final UpdateApartmentRequestToDTOMapper updateApartmentRequestToDTOMapper;

    @PostMapping
    public ResponseEntity<GetApartmentResponse> saveApartment(@RequestBody @Valid CreateApartmentRequest createApartmentRequest) {
        CreateApartmentDTO createApartmentDTO = createApartmentRequestToDTOEntityMapper.fromRequestToDTO(createApartmentRequest);

        GetApartmentDTO apartmentDTO = apartmentService.saveApartment(createApartmentDTO);

        GetApartmentResponse getApartmentResponse = getApartmentResponseFromDTOMapper.fromDTOToResponse(apartmentDTO);

        return new ResponseEntity<>(getApartmentResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetApartmentResponse>> getAllApartments() {
        List<GetApartmentDTO> getApartmentDTOList = apartmentService.getAllApartments();

        List<GetApartmentResponse> getApartmentResponseList = getApartmentResponseFromDTOMapper.fromDTOListToResponseList(getApartmentDTOList);

        return new ResponseEntity<>(getApartmentResponseList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<GetApartmentResponse> UpdateApartmentDTO(@Valid @RequestBody UpdateApartmentRequest updateApartmentRequest) {
        UpdateApartmentDTO updateApartmentDTO = updateApartmentRequestToDTOMapper.fromRequestToDTO(updateApartmentRequest);

        GetApartmentDTO apartmentDTO = apartmentService.updateApartment(updateApartmentDTO);

        GetApartmentResponse getApartmentResponse = getApartmentResponseFromDTOMapper.fromDTOToResponse(apartmentDTO);

        return new ResponseEntity<>(getApartmentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteApartment(@PathVariable Integer id) {
        apartmentService.deleteApartment(id);

        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
