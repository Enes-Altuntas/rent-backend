package com.example.rent.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BasePageableRequest<T> {

    @NotNull(message = "Sayfa içi gösterilecek adet boş bırakılamaz")
    @Min(value = 1)
    private Integer pageSize;

    @NotNull(message = "Sayfa sayısı boş bırakılamaz")
    @Min(value = 1)
    private Integer pageNumber;

    private String sortProperty;

    private boolean sortAsc = Boolean.TRUE;

    @Valid
    private T filter;

}