package com.capitol.interview.infrastructure.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.capitol.interview.domain.model.Price;
import com.capitol.interview.infrastructure.adapter.entity.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceDboMapper {
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priceListId", target = "priceListId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "curr", target = "curr")
    Price toDomain(PriceEntity entity);
}
