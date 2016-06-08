package co.edu.unal.sam.physicalactivity.model.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;

public class UserDto extends Dto {

    private int age;
    private Date dateBirth;
    private Date dateExpireClasification;
    private Date dateIngress;
    private Date dateInteraction;
    private String descriptionHistory;
    private String email;
    private Faculty faculty;
    private Float height;
    private Boolean history;
    private String identityDocument;
    private String password;
    private Set<PhysicalActivity> physicalActivities;
    private String surname;
    private TypeUserEnum typeuser;
    private Boolean useCondition;
    private String username;
    private Float weight;

    public UserDto() {
        super();
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
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * @return the dateBirth
     */
    public Date getDateBirth() {
        return this.dateBirth;
    }

    /**
     * @return the dateExpireClasification
     */
    public Date getDateExpireClasification() {
        return this.dateExpireClasification;
    }

    /**
     * @return the dateIngress
     */
    public Date getDateIngress() {
        return this.dateIngress;
    }

    /**
     * @return the dateInteraction
     */
    public Date getDateInteraction() {
        return this.dateInteraction;
    }

    /**
     * @return the descriptionHistory
     */
    public String getDescriptionHistory() {
        return this.descriptionHistory;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return the faculty
     */
    public Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * @return the height
     */
    public Float getHeight() {
        return this.height;
    }

    /**
     * @return the history
     */
    public Boolean getHistory() {
        return this.history;
    }

    /**
     * @return the identityDocument
     */
    public String getIdentityDocument() {
        return this.identityDocument;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return the physicalActivities
     */
    public Set<PhysicalActivity> getPhysicalActivities() {
        return this.physicalActivities;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * @return the typeuser
     */
    public TypeUserEnum getTypeuser() {
        return this.typeuser;
    }

    /**
     * @return the useCondition
     */
    public Boolean getUseCondition() {
        return this.useCondition;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return the weight
     */
    public Float getWeight() {
        return this.weight;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param dateBirth the dateBirth to set
     */
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    /**
     * @param dateExpireClasification the dateExpireClasification to set
     */
    public void setDateExpireClasification(Date dateExpireClasification) {
        this.dateExpireClasification = dateExpireClasification;
    }

    /**
     * @param dateIngress the dateIngress to set
     */
    public void setDateIngress(Date dateIngress) {
        this.dateIngress = dateIngress;
    }

    /**
     * @param dateInteraction the dateInteraction to set
     */
    public void setDateInteraction(Date dateInteraction) {
        this.dateInteraction = dateInteraction;
    }

    /**
     * @param descriptionHistory the descriptionHistory to set
     */
    public void setDescriptionHistory(String descriptionHistory) {
        this.descriptionHistory = descriptionHistory;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(Boolean history) {
        this.history = history;
    }

    /**
     * @param identityDocument the identityDocument to set
     */
    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param physicalActivities the physicalActivities to set
     */
    public void setPhysicalActivities(Set<PhysicalActivity> physicalActivities) {
        this.physicalActivities = physicalActivities;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @param typeuser the typeuser to set
     */
    public void setTypeuser(TypeUserEnum typeuser) {
        this.typeuser = typeuser;
    }

    /**
     * @param useCondition the useCondition to set
     */
    public void setUseCondition(Boolean useCondition) {
        this.useCondition = useCondition;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

}
