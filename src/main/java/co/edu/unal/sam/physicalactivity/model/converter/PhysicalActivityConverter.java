package co.edu.unal.sam.physicalactivity.model.converter;

import java.util.Objects;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.physicalactivity.model.domain.Activity;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;
import co.edu.unal.sam.physicalactivity.model.dto.ActivityDto;

@Component
public class PhysicalActivityConverter implements Converter<PhysicalActivity, ActivityDto> {

    @Override
    public PhysicalActivity convert(ActivityDto dto) {
        PhysicalActivity entity = null;
        if (Boolean.TRUE.equals(dto.getSelected())) {
            entity = new PhysicalActivity();
            Activity activity = new Activity();
            if (Objects.isNull(dto.getId())) {
                activity.setId(1L);
            } else {
                activity.setId(dto.getId());
            }
            entity.setActivity(activity);
            entity.setName(dto.getName());
        }
        return entity;
    }

    @Override
    public ActivityDto convert(PhysicalActivity entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
