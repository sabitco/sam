package co.edu.unal.sam.physicalactivity.model.converter;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.physicalactivity.model.dto.Dto;

public interface Converter<E extends Entity, D extends Dto> {

    E convert(D dto);

    D convert(E entity);

}
