package Proyecto.InventarioBelleza.Util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

    private static ModelMapper mapper;

    public ModelMapperUtil(ModelMapper mapper){ ModelMapperUtil.mapper = mapper;}

    public static <T> T convertTo(Object origin, Class<T> targetClass){
        return ModelMapperUtil.mapper.map(origin,targetClass);
    }


}
