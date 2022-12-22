package com.example.rent.Controller.Currency;

import com.example.rent.DTO.Currency.GetCurrencyDTO;
import com.example.rent.Mapper.Currency.GetCurrencyDTOToResponseMapper;
import com.example.rent.Response.Currency.GetCurrencyResponse;
import com.example.rent.Service.Currency.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    private final GetCurrencyDTOToResponseMapper getCurrencyDTOToResponseMapper;

    @GetMapping
    public ResponseEntity<List<GetCurrencyResponse>> getAllCurrency() {
        List<GetCurrencyDTO> getCurrencyDTOList = currencyService.getAllCurrency();

        List<GetCurrencyResponse> getCurrencyResponseList = getCurrencyDTOToResponseMapper.fromDTOListToResponseList(getCurrencyDTOList);

        return new ResponseEntity<>(getCurrencyResponseList, HttpStatus.OK);
    }
}
