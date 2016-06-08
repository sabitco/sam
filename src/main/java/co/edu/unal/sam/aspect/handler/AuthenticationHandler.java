package co.edu.unal.sam.aspect.handler;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;

@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {

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
        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect(redirect);
    }

}
