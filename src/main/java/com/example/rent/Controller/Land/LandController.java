package com.example.rent.Controller.Land;

import com.example.rent.DTO.Land.Create.CreateLandDTO;
import com.example.rent.DTO.Land.Get.GetLandDTO;
import com.example.rent.Mapper.Land.Create.CreateLandDTOToResponseMapper;
import com.example.rent.Mapper.Land.Create.CreateLandRequestToDTOEntityMapper;
import com.example.rent.Mapper.Land.Get.GetLandDTOToResponseMapper;
import com.example.rent.Request.Land.CreateLandRequest;
import com.example.rent.Response.Land.Create.CreateLandResponse;
import com.example.rent.Response.Land.Get.GetLandResponse;
import com.example.rent.Service.Land.LandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/land")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class LandController {
    private final LandService landService;
    private final CreateLandRequestToDTOEntityMapper createLandRequestToDTOEntityMapper;
    private final GetLandDTOToResponseMapper getLandDTOToResponseMapper;
    private final CreateLandDTOToResponseMapper createLandDTOToResponseMapper;

    @PostMapping
    public ResponseEntity<CreateLandResponse> saveLand(@RequestBody @Valid CreateLandRequest createLandRequest) {
        CreateLandDTO createLandDTO = createLandRequestToDTOEntityMapper.fromRequestToDTO(createLandRequest);

        CreateLandDTO landDTO = landService.saveLand(createLandDTO);

        CreateLandResponse createLandResponse = createLandDTOToResponseMapper.fromDTOToResponse(landDTO);

        return new ResponseEntity<>(createLandResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetLandResponse>> getAllLands() {
        List<GetLandDTO> getLandDTOList = landService.getAllLands();

        List<GetLandResponse> getLandResponseList = getLandDTOToResponseMapper.fromDTOListToResponseList(getLandDTOList);

        return new ResponseEntity<>(getLandResponseList, HttpStatus.OK);
    }
}
