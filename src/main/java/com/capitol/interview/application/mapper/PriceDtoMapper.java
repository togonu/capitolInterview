package com.capitol.interview.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.capitol.interview.domain.model.Price;
import com.capitol.interview.domain.model.dto.PriceDto;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PriceDto toDto(Price domain);
}
