package edu.miu.waabackend.utils;

import edu.miu.waabackend.dto.DTOEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DtoUtils<T> {

    @Autowired
    private ModelMapper modelMapper;
    public DTOEntity convertToDto(T obj, DTOEntity mapper) {
        return modelMapper.map(obj, mapper.getClass());
    }

    public List<DTOEntity> convertToListDto(List<T> lstObj, DTOEntity mapper) {
        return lstObj.stream().map(x -> modelMapper.map(x, mapper.getClass())).collect(Collectors.toList());
    }

    public Object convertToEntity(DTOEntity mapper, T obj) {
        return modelMapper.map(mapper, obj.getClass());
    }

    public List<Object> convertToListEntity(DTOEntity mapper, List<T> lstObj) {
        return lstObj.stream().map(x -> modelMapper.map(mapper, x.getClass())).collect(Collectors.toList());
    }
}
