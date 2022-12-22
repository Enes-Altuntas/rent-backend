package com.example.rent.Controller.Renter;

import com.example.rent.DTO.Renter.Create.CreateRenterDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.DTO.Renter.Update.UpdateRenterDTO;
import com.example.rent.Mapper.Renter.Create.CreateRenterRequestToDTOMapper;
import com.example.rent.Mapper.Renter.Get.GetRenterDTOToResponseMapper;
import com.example.rent.Mapper.Renter.Update.UpdateRenterRequestToDTOMapper;
import com.example.rent.Request.Renter.CreateRenterRequest;
import com.example.rent.Request.Renter.UpdateRenterRequest;
import com.example.rent.Response.Renter.Get.GetRenterResponse;
import com.example.rent.Service.Renter.RenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/renter")
@RequiredArgsConstructor
public class RenterController {

    private final RenterService renterService;
    private final CreateRenterRequestToDTOMapper createRenterRequestToDTOMapper;
    private final UpdateRenterRequestToDTOMapper updateRenterRequestToDTOMapper;
    private final GetRenterDTOToResponseMapper getRenterDTOToResponseMapper;

    @PostMapping
    public ResponseEntity<GetRenterResponse> saveRenter(@RequestBody @Valid CreateRenterRequest createRenterRequest) {
        CreateRenterDTO createRenterDTO = createRenterRequestToDTOMapper.fromRequestToDTO(createRenterRequest);

        GetRenterDTO getRenterDTO = renterService.saveRenter(createRenterDTO);

        GetRenterResponse getRenterResponse = getRenterDTOToResponseMapper.fromDTOToResponse(getRenterDTO);

        return new ResponseEntity<>(getRenterResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<GetRenterResponse> updateRenter(@RequestBody @Valid UpdateRenterRequest updateRenterRequest) {
        UpdateRenterDTO updateRenterDTO = updateRenterRequestToDTOMapper.fromRequestToDTO(updateRenterRequest);

        GetRenterDTO getRenterDTO = renterService.updateRenter(updateRenterDTO);

        GetRenterResponse getRenterResponse = getRenterDTOToResponseMapper.fromDTOToResponse(getRenterDTO);

        return new ResponseEntity<>(getRenterResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRenterResponse> getRenter(@PathVariable Integer id) {
        GetRenterDTO getRenterDTO = renterService.getRenter(id);

        GetRenterResponse getRenterResponse = getRenterDTOToResponseMapper.fromDTOToResponse(getRenterDTO);

        return new ResponseEntity<>(getRenterResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GetRenterResponse>> getAllRenters() {
        List<GetRenterDTO> getRenterDTOS = renterService.getAllRenters();

        List<GetRenterResponse> getRenterResponses = getRenterDTOToResponseMapper.fromDTOListToResponseList(getRenterDTOS);

        return new ResponseEntity<>(getRenterResponses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteRenter(@PathVariable Integer id) {
        renterService.deleteRenter(id);

        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}
