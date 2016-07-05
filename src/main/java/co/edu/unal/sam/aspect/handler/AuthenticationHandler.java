package co.edu.unal.sam.aspect.handler;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.dto.Statistic;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;
import co.edu.unal.sam.physicalactivity.model.enumerator.RewardEnum;
import co.edu.unal.sam.physicalactivity.model.repository.UserGoalActivityRepository;
import co.sabit.commons.utils.Dates;

@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {

    @Inject
    private UserGoalActivityRepository userGoalActivityRepository;

    @Inject
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
            final HttpServletResponse response, final Authentication authentication)
            throws IOException, ServletException {
        String redirect = "/administrator";
        final UserDto user = this.userRepository
                .findUserDtoByUsername(authentication.getName(), new PageRequest(0, 1)).get(0);
        if (TypeUserEnum.PLAYER.equals(user.getTypeuser())) {
            if (new Date().after(user.getDateExpireClasification())) {
                redirect = "physicalactivity/classification";
            } else {
                redirect = "physicalactivity/home";
            }
            this.setReward(user);
        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect(redirect);
    }

    private void setReward(final UserDto user) {
        User u = new User();
        u.setId(user.getId());
        List<Statistic> statistics =
                this.userGoalActivityRepository.findStatisticsByUserAndDateRegisterAndWeek(u,
                        Dates.getFirstDayOfWeek(Dates.getFirstDayOfMonth()),
                        Dates.getWeekOfMonth());
        if (statistics.size() > 0) {
            Long percent = 0L;
            for (Statistic s : statistics) {
                percent += s.getChart().get(0).getValue();
            }
            percent /= statistics.size();
            if (percent > 80) {
                user.setReward(RewardEnum.SAPPHIRE);
            } else if (percent > 50) {
                user.setReward(RewardEnum.PLATINUM);
            } else {
                user.setReward(RewardEnum.GOLD);
            }
        } else {
            user.setReward(RewardEnum.GOLD);
        }
    }

}
