package com.example.rent.Controller.Flat;

import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.DTO.Flat.Get.GetFlatApartmentDTO;
import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;
import com.example.rent.Mapper.Flat.Create.CreateFlatRequestToDTOEntityMapper;
import com.example.rent.Mapper.Flat.Get.GetFlatApartmentResponseFromDTOMapper;
import com.example.rent.Mapper.Flat.Update.UpdateFlatRequestToDTO;
import com.example.rent.Request.Flat.Create.CreateFlatRequest;
import com.example.rent.Request.Flat.Update.UpdateFlatRequest;
import com.example.rent.Response.Flat.Get.GetFlatApartmentResponse;
import com.example.rent.Service.Flat.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/flat")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class FlatController {
    private final FlatService flatService;
    private final CreateFlatRequestToDTOEntityMapper createFlatRequestToDTOEntityMapper;
    private final UpdateFlatRequestToDTO updateFlatRequestToDTO;
    private final GetFlatApartmentResponseFromDTOMapper getFlatApartmentResponseFromDTOMapper;

    @PostMapping
    public ResponseEntity<GetFlatApartmentResponse> saveFlat(@RequestBody @Valid CreateFlatRequest createFlatRequest) {
        CreateFlatDTO createFlatDTO = createFlatRequestToDTOEntityMapper.fromRequestToDTO(createFlatRequest);

        GetFlatApartmentDTO getFlatApartmentDTO = flatService.saveFlat(createFlatDTO);

        GetFlatApartmentResponse getFlatApartmentResponse = getFlatApartmentResponseFromDTOMapper.fromDTOToResponse(getFlatApartmentDTO);

        return new ResponseEntity<>(getFlatApartmentResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GetFlatApartmentResponse> deleteFlat(@PathVariable Integer id) {
        GetFlatApartmentDTO getFlatApartmentDTO = flatService.deleteFlat(id);

        GetFlatApartmentResponse getFlatApartmentResponse = getFlatApartmentResponseFromDTOMapper.fromDTOToResponse(getFlatApartmentDTO);

        return new ResponseEntity<>(getFlatApartmentResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<GetFlatApartmentResponse> updateFlat(@RequestBody @Valid UpdateFlatRequest updateFlatRequest) {
        UpdateFlatDTO updateFlatDTO = updateFlatRequestToDTO.fromRequestToDTO(updateFlatRequest);

        GetFlatApartmentDTO getFlatApartmentDTO = flatService.updateFlat(updateFlatDTO);

        GetFlatApartmentResponse getFlatApartmentResponse = getFlatApartmentResponseFromDTOMapper.fromDTOToResponse(getFlatApartmentDTO);

        return new ResponseEntity<>(getFlatApartmentResponse, HttpStatus.OK);
    }
}
