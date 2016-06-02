package co.edu.unal.sam.physicalactivity.model.converter;

import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class UserConverter implements Converter<User, UserDto> {

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
        entity.setPhysicalActivities(dto.getPhysicalActivities());
        entity.setState(dto.getState());
        entity.setSurname(dto.getSurname());
        entity.setTypeuser(dto.getTypeuser());
        entity.setUseCondition(dto.getUseCondition());
        entity.setUsername(dto.getUsername());

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
