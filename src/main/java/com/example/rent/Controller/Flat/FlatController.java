package com.example.rent.Controller.Flat;

import com.example.rent.DTO.Flat.Create.CreateFlatDTO;
import com.example.rent.DTO.Flat.Get.GetFlatDTO;
import com.example.rent.DTO.Flat.Update.UpdateFlatDTO;
import com.example.rent.Mapper.Flat.Create.CreateFlatRequestToDTOEntityMapper;
import com.example.rent.Mapper.Flat.Get.GetFlatResponseFromDTOMapper;
import com.example.rent.Mapper.Flat.Update.UpdateFlatRequestToDTO;
import com.example.rent.Request.Flat.Create.CreateFlatRequest;
import com.example.rent.Request.Flat.Update.UpdateFlatRequest;
import com.example.rent.Response.Flat.Get.GetFlatResponse;
import com.example.rent.Service.Flat.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flat")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class FlatController {
    private final FlatService flatService;
    private final CreateFlatRequestToDTOEntityMapper createFlatRequestToDTOEntityMapper;
    private final UpdateFlatRequestToDTO updateFlatRequestToDTO;
    private final GetFlatResponseFromDTOMapper getFlatResponseFromDTOMapper;

    @PostMapping
    public ResponseEntity<GetFlatResponse> saveFlat(@RequestBody @Valid CreateFlatRequest createFlatRequest) {
        CreateFlatDTO createFlatDTO = createFlatRequestToDTOEntityMapper.fromRequestToDTO(createFlatRequest);

        GetFlatDTO getFlatDTO = flatService.saveFlat(createFlatDTO);

        GetFlatResponse getFlatResponse = getFlatResponseFromDTOMapper.fromDTOToResponse(getFlatDTO);

        return new ResponseEntity<>(getFlatResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteFlat(@PathVariable Integer id) {
        flatService.deleteFlat(id);

        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<GetFlatResponse> updateFlat(@RequestBody @Valid UpdateFlatRequest updateFlatRequest) {
        UpdateFlatDTO updateFlatDTO = updateFlatRequestToDTO.fromRequestToDTO(updateFlatRequest);

        GetFlatDTO getFlatDTO = flatService.updateFlat(updateFlatDTO);

        GetFlatResponse getFlatResponse = getFlatResponseFromDTOMapper.fromDTOToResponse(getFlatDTO);

        return new ResponseEntity<>(getFlatResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GetFlatResponse>> getAllFlats() {
        List<GetFlatDTO> getFlatDTOList = flatService.getAllFlat();

        List<GetFlatResponse> getFlatResponseList = getFlatResponseFromDTOMapper.fromDTOListToResponseList(getFlatDTOList);

        return new ResponseEntity<>(getFlatResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetFlatResponse> getFlat(@PathVariable Integer id) {
        GetFlatDTO getFlatDTO = flatService.getFlat(id);

        GetFlatResponse getFlatResponse = getFlatResponseFromDTOMapper.fromDTOToResponse(getFlatDTO);

        return new ResponseEntity<>(getFlatResponse, HttpStatus.OK);
    }
}
