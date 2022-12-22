package com.example.rent.Controller.Recap;


import com.example.rent.DTO.Recap.GetRecapDTO;
import com.example.rent.Mapper.Recap.GetRecapRentResponseFromDTOMapper;
import com.example.rent.Response.Recap.GetRecapResponse;
import com.example.rent.Service.Recap.RecapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recap")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class RecapController {
    private final GetRecapRentResponseFromDTOMapper getRecapRentResponseFromDTOMapper;
    private final RecapService recapService;

    @GetMapping()
    public ResponseEntity<List<GetRecapResponse>> getRecap() {
        List<GetRecapDTO> getRecapDTOList = recapService.getRecap();

        List<GetRecapResponse> getRecapResponseList = getRecapRentResponseFromDTOMapper.fromDTOListToResponseList(getRecapDTOList);

        return new ResponseEntity<>(getRecapResponseList, HttpStatus.OK);
    }
}
