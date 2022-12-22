package com.example.rent.Service.Currency;

import com.example.rent.DTO.Currency.GetCurrencyDTO;
import com.example.rent.Entity.Currency.Currency;
import com.example.rent.Mapper.Currency.GetCurrencyDTOFromEntityMapper;
import com.example.rent.Repository.Currency.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final GetCurrencyDTOFromEntityMapper getcurrencyDTOFromEntityMapper;
    @Override
    public List<GetCurrencyDTO> getAllCurrency() {
        List<Currency> currencyList = currencyRepository.findAll();
        List<GetCurrencyDTO> currencyDTOList = getcurrencyDTOFromEntityMapper.fromEntityListToDTOList(currencyList);
        return  currencyDTOList;
    }
}
