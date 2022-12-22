package com.example.rent.Service.Apartment;

import com.example.rent.DTO.Apartment.Create.CreateApartmentDTO;
import com.example.rent.DTO.Apartment.Get.GetApartmentDTO;
import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Mapper.Apartment.Get.GetApartmentDTOFromEntityMapper;
import com.example.rent.Repository.Apartment.ApartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApartmentServiceImplTest {
    private ApartmentServiceImpl apartmentService;
    private ApartmentRepository apartmentRepository;
    private GetApartmentDTOFromEntityMapper getApartmentDTOFromEntityMapper;

    @BeforeEach
    public void setUp() {
        apartmentRepository = Mockito.mock(ApartmentRepository.class);
        getApartmentDTOFromEntityMapper = Mockito.mock(GetApartmentDTOFromEntityMapper.class);
        apartmentService = new ApartmentServiceImpl(apartmentRepository, getApartmentDTOFromEntityMapper);
    }

    @Test
    public void whenSaveApartmentCalledWithValidCreateApartmentDTO_itShouldReturnValidGetApartmentDTO() {

        CreateApartmentDTO createApartmentDTO = CreateApartmentDTO.builder()
                .apartmentName("Şerifoğlu Apt.")
                .city("İstanbul")
                .state("Üsküdar")
                .number(65)
                .neighborhood("Ünalan mah.")
                .streetName("Esenlik sok.")
                .build();

        Apartment inputApartment = new Apartment();
        inputApartment.setId(null);
        inputApartment.setApartmentName(createApartmentDTO.getApartmentName());
        inputApartment.setCity(createApartmentDTO.getCity());
        inputApartment.setState(createApartmentDTO.getState());
        inputApartment.setNumber(createApartmentDTO.getNumber());
        inputApartment.setNeighborhood(createApartmentDTO.getNeighborhood());
        inputApartment.setStreetName(createApartmentDTO.getStreetName());
        inputApartment.setFlatList(new ArrayList<>());

        Apartment outputApartment = new Apartment();
        outputApartment.setId(1);
        outputApartment.setApartmentName("Şerifoğlu Apt.");
        outputApartment.setCity("İstanbul");
        outputApartment.setState("Üsküdar");
        outputApartment.setNumber(65);
        outputApartment.setNeighborhood("Ünalan mah.");
        outputApartment.setStreetName("Esenlik sok.");
        outputApartment.setFlatList(new ArrayList<>());

        GetApartmentDTO getApartmentDTO = GetApartmentDTO.builder()
                .apartmentId(1)
                .apartmentName("Şerifoğlu Apt.")
                .city("İstanbul")
                .state("Üsküdar")
                .number(65)
                .neighborhood("Ünalan mah.")
                .streetName("Esenlik sok.")
                .flatList(new ArrayList<>())
                .build();

        Mockito.when(apartmentRepository.save(inputApartment)).thenReturn(outputApartment);
        Mockito.when(getApartmentDTOFromEntityMapper.fromEntityToDTO(outputApartment)).thenReturn(getApartmentDTO);

        GetApartmentDTO result = apartmentService.saveApartment(createApartmentDTO);

        Mockito.verify(apartmentRepository).save(inputApartment);
        Mockito.verify(getApartmentDTOFromEntityMapper).fromEntityToDTO(outputApartment);

        assertEquals(result, getApartmentDTO);
    }
}