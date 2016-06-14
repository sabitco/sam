package co.edu.unal.sam.physicalactivity.model.converter;

import java.util.Objects;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.physicalactivity.model.domain.Disease;
import co.edu.unal.sam.physicalactivity.model.domain.UserDisease;
import co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto;

@Component
public class UserDiseaseConverter implements Converter<UserDisease, DiseaseDto> {

    @Override
    public UserDisease convert(DiseaseDto dto) {
        UserDisease entity = null;
        if (Boolean.TRUE.equals(dto.getSelected())) {
            entity = new UserDisease();
            Disease disease = new Disease();
            if (Objects.isNull(dto.getId())) {
                disease.setId(1L);
            } else {
                disease.setId(dto.getId());
            }
            entity.setDisease(disease);
            entity.setName(dto.getName());
        }
        return entity;
    }

    @Override
    public DiseaseDto convert(UserDisease entity) {
        // TODO Auto-generated method stub
        return null;
    }


}
