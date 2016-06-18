package co.edu.unal.sam.aspect.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.dto.response.Successful;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.converter.UserConverter;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;
import co.edu.unal.sam.physicalactivity.model.dto.ActivityDto;
import co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto;
import co.edu.unal.sam.physicalactivity.model.dto.GoalDto;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;
import co.edu.unal.sam.physicalactivity.model.service.UserService;

@RestController
public class UserController {

    @Inject
    private UserConverter converter;

    @Inject
    private MessageSource messageSource;

    @Inject
    private UserRepository repository;

    @Inject
    private UserService service;

    @RequestMapping(value = "/users/classify", method = RequestMethod.PUT)
    public ResponseEntity<Successful> classifyUser(@RequestBody UserDto user,
            HttpServletRequest request) {
        this.service.verify(user.getId());
        UserDto dto = (UserDto) request.getSession().getAttribute("user");
        dto.setRisk(this.service.classifyUser(this.converter.convert(user)));
        request.getSession().setAttribute("user", dto);
        Successful success = new Successful();
        success.setMessage(
                this.messageSource.getMessage("user.preclassify.successfully", null, null));
        success.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public ResponseEntity<Successful> createUser(@Valid @RequestBody UserDto dto) {
        User user = this.service.createUser(this.converter.convert(dto));
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        responseHeaders.setLocation(newUserUri);
        Successful success = new Successful();
        success.setMessage(this.messageSource.getMessage("user.created.successfully", null, null));
        success.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(success, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/goals/{userId}", method = RequestMethod.POST)
    public ResponseEntity<Successful> createGoals(@RequestBody List<GoalDto> goals,
            @PathVariable Long userId) {
        this.service.createGoals(goals, userId);
        // Set the location header for the newly created resource
        Successful success = new Successful();
        success.setMessage(this.messageSource.getMessage("user.created.successfully", null, null));
        success.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(success, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        this.service.verify(userId);
        this.repository.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users/activities/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ActivityDto>> getActivities(@PathVariable Long userId,
            @RequestParam(name = "state", required = false) final StateEnum state,
            @RequestParam(name = "onlySelected", required = false) final Boolean onlySelected) {
        User user = this.service.verify(userId);
        Iterable<ActivityDto> activities = this.service.getActivities(user, state, onlySelected);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllusers(Pageable pageable) {
        Iterable<User> allusers = this.repository.findAll(pageable);
        return new ResponseEntity<>(allusers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/diseases/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<DiseaseDto>> getDiseases(@PathVariable Long userId,
            @RequestParam(name = "state", required = false) final StateEnum state,
            @RequestParam(name = "onlySelected", required = false) final Boolean onlySelected) {
        User user = this.service.verify(userId);
        Iterable<DiseaseDto> diseases = this.service.getDiseases(user, state, onlySelected);
        return new ResponseEntity<>(diseases, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        this.service.verify(userId);
        User user = this.repository.findOne(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/preclassify", method = RequestMethod.PUT)
    public ResponseEntity<Successful> preClassifyUser(@RequestBody UserDto user,
            HttpServletRequest request) {
        Bmi bmi = this.service.preClassifyUser(this.converter.convert(user));
        UserDto dto = (UserDto) request.getSession().getAttribute("user");
        dto.setHeight(bmi.getHeight());
        dto.setWeight(bmi.getWeight());
        request.getSession().setAttribute("user", dto);
        Successful success = new Successful();
        success.setMessage(
                this.messageSource.getMessage("user.preclassify.successfully", null, null));
        success.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(success, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable Long userId) {
        this.service.verify(userId);
        this.repository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {
        String name = "test11";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                StringBuilder sb = new StringBuilder();
                sb.append("data:image/png;base64,");
                sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(bytes, false)));
                return "<img src=\"" + sb.toString() + "\" />";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}
