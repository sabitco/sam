package co.edu.unal.sam.physicalactivity.model.converter;

import java.util.Date;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;
import co.edu.unal.sam.physicalactivity.model.domain.UserDisease;
import co.edu.unal.sam.physicalactivity.model.dto.ActivityDto;
import co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class UserConverter implements Converter<User, UserDto> {

    @Inject
    private PhysicalActivityConverter physicalActivityConverter;

    @Inject
    private UserDiseaseConverter userDiseaseConverter;

    @Override
    public User convert(UserDto dto) {
        User entity = new User();

        entity.setDateBirth(dto.getDateBirth());
        entity.setDateExpireClasification(dto.getDateExpireClasification());
        entity.setDateIngress(dto.getDateIngress());
        entity.setDateInteraction(dto.getDateInteraction());
        entity.setDateRegister(dto.getDateRegister());
        entity.setDateUpdate(dto.getDateUpdate());
        entity.setDescriptionHistory(dto.getDescriptionHistory());
        entity.setEmail(dto.getEmail());
        entity.setFaculty(dto.getFaculty());
        entity.setHistory(dto.getHistory());
        entity.setId(dto.getId());
        entity.setIdentityDocument(dto.getIdentityDocument());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setState(dto.getState());
        entity.setSurname(dto.getSurname());
        entity.setTypeuser(dto.getTypeuser());
        entity.setUseCondition(dto.getUseCondition());
        entity.setUsername(dto.getUsername());

        for (ActivityDto activity : dto.getActivities()) {
            PhysicalActivity physicalActivity = this.physicalActivityConverter.convert(activity);
            if (Objects.nonNull(physicalActivity)) {
                physicalActivity.setUser(entity);
                entity.getPhysicalActivities().add(physicalActivity);
            }
        }

        for (DiseaseDto disease : dto.getDiseases()) {
            UserDisease userDisease = this.userDiseaseConverter.convert(disease);
            if (Objects.nonNull(userDisease)) {
                userDisease.setUser(entity);
                entity.getDiseases().add(userDisease);
            }
        }

        if (Objects.nonNull(dto.getHeight()) && Objects.nonNull(dto.getWeight())) {
            Bmi bmi = new Bmi();
            bmi.setDateRegister(new Date());
            bmi.setHeight(dto.getHeight());
            bmi.setUser(entity);
            bmi.setWeight(dto.getWeight());
            entity.getBmis().add(bmi);
        }
        return entity;
    }

    @Override
    public UserDto convert(User entity) {
        // TODO implementar
        return null;
    }

}
