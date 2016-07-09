package co.edu.unal.sam.physicalactivity.model.service;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Advantage;
import co.edu.unal.sam.physicalactivity.model.domain.Alert;
import co.edu.unal.sam.physicalactivity.model.domain.Event;
import co.edu.unal.sam.physicalactivity.model.domain.Myth;
import co.edu.unal.sam.physicalactivity.model.domain.Tip;
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

    public Advantage getAdvantage(Long id) {
        return this.advantageRepository.findOne(id);
    }

    public List<AdvantageDto> getAdvantages(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.advantageRepository.findDtoAll(state);
    }

    public Alert getAlert(Long id) {
        return this.alertRepository.findOne(id);
    }

    public List<AlertDto> getAlerts(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.alertRepository.findDtoAll(state);
    }

    public Event getEvent(Long id) {
        return this.repository.findOne(id);
    }

    public List<EventDto> getEvents(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.repository.findDtoAll(state);
    }

    public Myth getMyth(Long id) {
        return this.mythRepository.findOne(id);
    }

    public List<MythDto> getMyths(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.mythRepository.findDtoAll(state);
    }

    public Tip getTip(Long id) {
        return this.tipRepository.findOne(id);
    }

    public List<TipDto> getTips(StateEnum state) {
        if (Objects.isNull(state)) {
            state = StateEnum.ACTIVE;
        }
        return this.tipRepository.findDtoAll(state);
    }
}
