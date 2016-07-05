package co.edu.unal.sam.physicalactivity.model.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.enumerator.BmiCategoryEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.RewardEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeRiskEnum;

public class UserDto extends Dto {

    private Set<ActivityDto> activities;
    private int age;
    private BmiCategoryEnum bmi;
    private Date dateBirth;
    private Date dateExpireClasification;
    private Date dateIngress;
    private Date dateInteraction;
    private String descriptionHistory;
    private Set<DiseaseDto> diseases;
    private String email;
    private Faculty faculty;
    private Set<GoalDto> goals;
    private Float height;
    private Boolean history;
    private String identityDocument;
    private String password;
    private Integer progress;
    private RewardEnum reward;
    private TypeRiskEnum risk;
    private String surname;
    private TypeUserEnum typeuser;
    private Boolean useCondition;
    private String username;
    private Float weight;

    public UserDto() {
        super();
        this.activities = new HashSet<>();
        this.diseases = new HashSet<>();
        this.goals = new HashSet<>();
    }

    public UserDto(BmiCategoryEnum bmi, Date dateBirth, Date dateExpireClasification,
            Date dateRegister, Date dateUpdate, String email, Float height, Long id,
            String identityDocument, String name, StateEnum state, TypeUserEnum typeuser,
            String username, Float weight) {
        super(dateRegister, dateUpdate, id, name, state);
        this.bmi = bmi;
        this.dateExpireClasification = dateExpireClasification;
        this.email = email;
        this.height = height;
        this.identityDocument = identityDocument;
        this.typeuser = typeuser;
        this.username = username;
        this.dateBirth = dateBirth;
        this.weight = weight;
        this.progress = 1;
        LocalDate start = new java.sql.Date(dateBirth.getTime()).toLocalDate();
        LocalDate end = LocalDate.now();
        this.age = (int) ChronoUnit.YEARS.between(start, end);
    }

    /**
     * @return the activities
     */
    public Set<ActivityDto> getActivities() {
        return this.activities;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * @return the bmi
     */
    public BmiCategoryEnum getBmi() {
        return this.bmi;
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
     * @return the diseases
     */
    public Set<DiseaseDto> getDiseases() {
        return this.diseases;
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
     * @return the goals
     */
    public Set<GoalDto> getGoals() {
        return this.goals;
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
     * @return the progress
     */
    public final int getProgress() {
        return this.progress;
    }

    /**
     * @return the reward
     */
    public RewardEnum getReward() {
        return this.reward;
    }

    /**
     * @return the risk
     */
    public TypeRiskEnum getRisk() {
        return this.risk;
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
     * @param activities the activities to set
     */
    public void setActivities(Set<ActivityDto> activities) {
        this.activities = activities;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param bmi the bmi to set
     */
    public void setBmi(BmiCategoryEnum bmi) {
        this.bmi = bmi;
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
     * @param diseases the diseases to set
     */
    public void setDiseases(Set<DiseaseDto> diseases) {
        this.diseases = diseases;
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
     * @param goals the goals to set
     */
    public void setGoals(Set<GoalDto> goals) {
        this.goals = goals;
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
     * @param progress the progress to set
     */
    public final void setProgress(int progress) {
        this.progress = progress;
    }

    /**
     * @param reward the reward to set
     */
    public void setReward(RewardEnum reward) {
        this.reward = reward;
    }

    /**
     * @param risk the risk to set
     */
    public void setRisk(TypeRiskEnum risk) {
        this.risk = risk;
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
