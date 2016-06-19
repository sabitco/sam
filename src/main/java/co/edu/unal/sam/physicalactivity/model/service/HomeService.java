package co.edu.unal.sam.physicalactivity.model.service;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.dto.TipDto;
import co.edu.unal.sam.physicalactivity.model.repository.TipRepository;

@Component
public class HomeService {

    @Inject
    private TipRepository tipRepository;

    public List<TipDto> getAdvantages(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.tipRepository.findDtoAll(state);
    }

    public List<TipDto> getAlerts(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.tipRepository.findDtoAll(state);
    }

    public List<TipDto> getMyths(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.tipRepository.findDtoAll(state);
    }

    public List<TipDto> getTips(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.tipRepository.findDtoAll(state);
    }

}
