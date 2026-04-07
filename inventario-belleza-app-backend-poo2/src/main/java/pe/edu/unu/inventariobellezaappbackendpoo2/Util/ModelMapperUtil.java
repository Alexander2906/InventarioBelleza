package pe.edu.unu.inventariobellezaappbackendpoo2.Util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

    private static ModelMapper modelMapper;

    @Autowired
    public ModelMapperUtil(ModelMapper modelMapper) {
        ModelMapperUtil.modelMapper = modelMapper;
    }

    public static <S, D> D convertTo(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}

