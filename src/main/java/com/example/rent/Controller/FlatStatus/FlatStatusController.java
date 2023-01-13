package com.example.rent.Controller.FlatStatus;

import com.example.rent.DTO.FlatStatus.GetFlatStatusDTO;
import com.example.rent.Mapper.FlatStatus.GetFlatStatusResponseFromDTOMapper;
import com.example.rent.Response.FlatStatus.GetFlatStatusResponse;
import com.example.rent.Service.FlatStatus.FlatStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flatstatus")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class FlatStatusController {
    private final FlatStatusService flatStatusService;
    private final GetFlatStatusResponseFromDTOMapper getFlatStatusResponseFromDTOMapper;

    @GetMapping
    public ResponseEntity<List<GetFlatStatusResponse>> getFlatStatusAsDropdown() {
        List<GetFlatStatusDTO> flatStatusDTOS = flatStatusService.getFlatStatusAsDropdown();

        List<GetFlatStatusResponse> getFlatStatusResponses =
                getFlatStatusResponseFromDTOMapper.fromDTOListToResponseList(flatStatusDTOS);

        return new ResponseEntity<>(getFlatStatusResponses, HttpStatus.OK);
    }
}
