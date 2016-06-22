package co.edu.unal.sam.physicalactivity.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.domain.Goal;
import co.edu.unal.sam.physicalactivity.model.dto.ActivityDto;
import co.edu.unal.sam.physicalactivity.model.dto.GoalDto;
import co.edu.unal.sam.physicalactivity.model.repository.GoalRepository;

@Component
public class GoalService {

    @Inject
    private GoalRepository goalRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserService userService;

    public List<GoalDto> getGoals(User user) {
        List<ActivityDto> activites = this.userService.getActivities(user, StateEnum.ACTIVE, true);
        Iterable<Goal> goals = this.goalRepository.findAll();
        List<GoalDto> goalsDto = new ArrayList<>(0);
        GoalDto dto = null;
        for (Goal g : goals) {
            dto = new GoalDto(new ActivityDto(g.getActivity().getId(), g.getActivity().getName()),
                    g.getId(), g.getDays(), g.getMinutes(), false);
            for (ActivityDto a : activites) {
                if (a.getId().equals(dto.getActivity().getId())) {
                    dto.setCurrentDays(a.getDays() == null ? 0 : a.getDays());
                    dto.setCurrentMinutes(a.getMinutes() == null ? 0 : a.getMinutes());
                    dto.setSelected(true);
                    break;
                }
            }
            goalsDto.add(dto);
        }
        return goalsDto;
    }

    public List<GoalDto> getGoals(Long userId, Boolean selected) {
        User user = this.userService.verify(userId);
        List<GoalDto> goals;
        if (Boolean.TRUE.equals(selected)) {
            goals = this.userRepository.findGoalDtoByUser(user);
        } else {
            goals = this.getGoals(user);
        }
        return goals;
    }

}
