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
    public ResponseEntity<List<GetFlatResponse>> saveFlat(@RequestBody @Valid CreateFlatRequest createFlatRequest) {
        CreateFlatDTO createFlatDTO = createFlatRequestToDTOEntityMapper.fromRequestToDTO(createFlatRequest);

        List<GetFlatDTO> getFlatDTOS = flatService.saveFlat(createFlatDTO);

        List<GetFlatResponse> getFlatResponses = getFlatResponseFromDTOMapper.fromDTOListToResponseList(getFlatDTOS);

        return new ResponseEntity<>(getFlatResponses, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<GetFlatResponse>> deleteFlat(@PathVariable Integer id) {
        List<GetFlatDTO> getFlatDTOS = flatService.deleteFlat(id);

        List<GetFlatResponse> getFlatResponses = getFlatResponseFromDTOMapper.fromDTOListToResponseList(getFlatDTOS);

        return new ResponseEntity<>(getFlatResponses, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<GetFlatResponse>> updateFlat(@RequestBody @Valid UpdateFlatRequest updateFlatRequest) {
        UpdateFlatDTO updateFlatDTO = updateFlatRequestToDTO.fromRequestToDTO(updateFlatRequest);

        List<GetFlatDTO> getFlatDTOS = flatService.updateFlat(updateFlatDTO);

        List<GetFlatResponse> getFlatResponses = getFlatResponseFromDTOMapper.fromDTOListToResponseList(getFlatDTOS);

        return new ResponseEntity<>(getFlatResponses, HttpStatus.OK);
    }
}
