package edu.miu.waabackend.utils;

import edu.miu.waabackend.dto.DTOEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DtoUtils<T> {
    public DTOEntity convertToDto(T obj, DTOEntity mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public List<DTOEntity> convertToListDto(List<T> lstObj, DTOEntity mapper) {
        return lstObj.stream().map(x -> new ModelMapper().map(x, mapper.getClass())).collect(Collectors.toList());
    }

    public Object convertToEntity(DTOEntity mapper, T obj) {
        return new ModelMapper().map(mapper, obj.getClass());
    }

    public List<Object> convertToListEntity(DTOEntity mapper, List<T> lstObj) {
        return lstObj.stream().map(x -> new ModelMapper().map(mapper, x.getClass())).collect(Collectors.toList());
    }
}
