package br.com.dlm.picpayclone.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class MapperBase<E, D> {

    public abstract D mapEntityToDto(E entity);

    public abstract E mapDtoToEntity(D dto);

    public List<D> mapEntitiesToDtos(List<E> entities) {
        List<D> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> dtos.add(mapEntityToDto(entity)));
        return dtos;
    }

    public List<E> mapDtosToEntities(List<D> dtos) {
        List<E> entities = new ArrayList<>();
        dtos.stream().forEach(dto -> entities.add(mapDtoToEntity(dto)));
        return entities;
    }
}
