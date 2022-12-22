package com.example.rent.Mapper.Payment;

import com.example.rent.DTO.Payment.GetPaymentFileDTO;
import com.example.rent.Entity.File.File;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Mapper(componentModel = "spring")
public interface GetPaymentFileEntityToDTOMapper extends BaseEntityMapper<File, GetPaymentFileDTO> {

    @Mapping(source = "id", target = "fileId")
    @Mapping(source = "id", target = "url", qualifiedByName = "getURL")
    @Mapping(source = "data", target = "size", qualifiedByName = "getSize")
    @Override
    GetPaymentFileDTO fromEntityToDTO(File file);

    @Named("getURL")
    default String getURL(Integer id) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/files/")
                .path(id.toString())
                .toUriString();
    }

    @Named("getSize")
    default long getSize(byte[] file) {
        return file.length;
    }
}
