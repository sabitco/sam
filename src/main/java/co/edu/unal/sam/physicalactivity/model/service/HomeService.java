package co.edu.unal.sam.physicalactivity.model.service;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.dto.AdvantageDto;
import co.edu.unal.sam.physicalactivity.model.dto.AlertDto;
import co.edu.unal.sam.physicalactivity.model.dto.EventDto;
import co.edu.unal.sam.physicalactivity.model.dto.MythDto;
import co.edu.unal.sam.physicalactivity.model.dto.TipDto;
import co.edu.unal.sam.physicalactivity.model.repository.AdvantageRepository;
import co.edu.unal.sam.physicalactivity.model.repository.AlertRepository;
import co.edu.unal.sam.physicalactivity.model.repository.EventRepository;
import co.edu.unal.sam.physicalactivity.model.repository.MythRepository;
import co.edu.unal.sam.physicalactivity.model.repository.TipRepository;

@Component
public class HomeService {

    @Inject
    private AdvantageRepository advantageRepository;

    @Inject
    private AlertRepository alertRepository;

    @Inject
    private MythRepository mythRepository;

    @Inject
    private EventRepository repository;

    @Inject
    private TipRepository tipRepository;

    public List<AdvantageDto> getAdvantages(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.advantageRepository.findDtoAll(state);
    }

    public List<AlertDto> getAlerts(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.alertRepository.findDtoAll(state);
    }

    public List<EventDto> getEvents(StateEnum state) {
        return this.repository.findDtoAll(state);
    }

    public List<MythDto> getMyths(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.mythRepository.findDtoAll(state);
    }

    public List<TipDto> getTips(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.tipRepository.findDtoAll(state);
    }

}
