package com.capitol.interview.infrastructure.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.capitol.interview.domain.model.Brand;
import com.capitol.interview.infrastructure.adapter.entity.BrandEntity;


@Mapper(componentModel = "spring")
public interface BrandDboMapper {
	@Mapping(source = "brandId", target = "brandId")
	@Mapping(source = "name", target = "name")
    Brand toDomain(BrandEntity entity);
}
