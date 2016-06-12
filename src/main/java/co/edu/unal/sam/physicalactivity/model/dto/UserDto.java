package co.edu.unal.sam.physicalactivity.model.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;

public class UserDto extends Dto {

    private Set<ActivityDto> activities;
    private int age;
    private Date dateBirth;
    private Date dateExpireClasification;
    private Date dateIngress;
    private Date dateInteraction;
    private String descriptionHistory;
    private Set<DiseaseDto> diseases;
    private String email;
    private Faculty faculty;
    private Float height;
    private Boolean history;
    private String identityDocument;
    private String password;
    private String surname;
    private TypeUserEnum typeuser;
    private Boolean useCondition;
    private String username;
    private Float weight;

    public UserDto() {
        super();
        this.activities = new HashSet<>();
        this.diseases = new HashSet<>();
    }

    @SuppressWarnings("deprecation")
    public UserDto(Date dateBirth, Date dateExpireClasification, Date dateRegister, Date dateUpdate,
            String email, Float height, Long id, String identityDocument, String name,
            StateEnum state, TypeUserEnum typeuser, String username, Float weight) {
        super(dateRegister, dateUpdate, id, name, state);
        this.dateExpireClasification = dateExpireClasification;
        this.email = email;
        this.height = height;
        this.identityDocument = identityDocument;
        this.typeuser = typeuser;
        this.username = username;
        this.dateBirth = dateBirth;
        this.weight = weight;

        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.of(dateBirth.getYear() + 1900, dateBirth.getMonth() + 1,
                dateBirth.getDate());
        this.age = (int) ChronoUnit.YEARS.between(start, end);
    }

    /**
     * @return the activities
     */
    public Set<ActivityDto> getActivities() {
        return this.activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(Set<ActivityDto> activities) {
        this.activities = activities;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the dateBirth
     */
    public Date getDateBirth() {
        return this.dateBirth;
    }

    /**
     * @param dateBirth the dateBirth to set
     */
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    /**
     * @return the dateExpireClasification
     */
    public Date getDateExpireClasification() {
        return this.dateExpireClasification;
    }

    /**
     * @param dateExpireClasification the dateExpireClasification to set
     */
    public void setDateExpireClasification(Date dateExpireClasification) {
        this.dateExpireClasification = dateExpireClasification;
    }

    /**
     * @return the dateIngress
     */
    public Date getDateIngress() {
        return this.dateIngress;
    }

    /**
     * @param dateIngress the dateIngress to set
     */
    public void setDateIngress(Date dateIngress) {
        this.dateIngress = dateIngress;
    }

    /**
     * @return the dateInteraction
     */
    public Date getDateInteraction() {
        return this.dateInteraction;
    }

    /**
     * @param dateInteraction the dateInteraction to set
     */
    public void setDateInteraction(Date dateInteraction) {
        this.dateInteraction = dateInteraction;
    }

    /**
     * @return the descriptionHistory
     */
    public String getDescriptionHistory() {
        return this.descriptionHistory;
    }

    /**
     * @param descriptionHistory the descriptionHistory to set
     */
    public void setDescriptionHistory(String descriptionHistory) {
        this.descriptionHistory = descriptionHistory;
    }

    /**
     * @return the diseases
     */
    public Set<DiseaseDto> getDiseases() {
        return this.diseases;
    }

    /**
     * @param diseases the diseases to set
     */
    public void setDiseases(Set<DiseaseDto> diseases) {
        this.diseases = diseases;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the faculty
     */
    public Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the height
     */
    public Float getHeight() {
        return this.height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * @return the history
     */
    public Boolean getHistory() {
        return this.history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(Boolean history) {
        this.history = history;
    }

    /**
     * @return the identityDocument
     */
    public String getIdentityDocument() {
        return this.identityDocument;
    }

    /**
     * @param identityDocument the identityDocument to set
     */
    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the typeuser
     */
    public TypeUserEnum getTypeuser() {
        return this.typeuser;
    }

    /**
     * @param typeuser the typeuser to set
     */
    public void setTypeuser(TypeUserEnum typeuser) {
        this.typeuser = typeuser;
    }

    /**
     * @return the useCondition
     */
    public Boolean getUseCondition() {
        return this.useCondition;
    }

    /**
     * @param useCondition the useCondition to set
     */
    public void setUseCondition(Boolean useCondition) {
        this.useCondition = useCondition;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the weight
     */
    public Float getWeight() {
        return this.weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

}
