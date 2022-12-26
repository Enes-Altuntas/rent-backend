package com.example.rent.Mapper;

import java.util.List;

public interface BaseEntityMapper<Entity, DTO> {

    DTO fromEntityToDTO(Entity entity);

    List<DTO> fromEntityListToDTOList(List<Entity> entities);


}
