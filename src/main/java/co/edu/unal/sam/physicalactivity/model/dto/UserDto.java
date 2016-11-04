package co.edu.unal.sam.physicalactivity.model.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;
import co.edu.unal.sam.physicalactivity.model.domain.City;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.enumerator.BmiCategoryEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.MaritalStatusEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.RewardEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeRiskEnum;

public class UserDto extends Dto {

    private Set<ActivityDto> activities;
    private int age;
    private BmiCategoryEnum bmi;
    private City cityBirth;
    private City cityResidential;
    private String contact;
    private Date dateBirth;
    private Date dateExpireClasification;
    private Date dateIngress;
    private Date dateInteraction;
    private String descriptionHistory;
    private Set<DiseaseDto> diseases;
    private String email;
    private String eps;
    private Faculty faculty;
    private Set<GoalDto> goals;
    private Float height;
    private Boolean history;
    private String identityDocument;
    private MaritalStatusEnum maritalStatus;
    private String msisdn;
    private String password;
    private Integer progress;
    private RewardEnum reward;
    private TypeRiskEnum risk;
    private String skype;
    private Statistic statistic;
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

    public UserDto(final Bmi bmi, final Date dateBirth, final Date dateExpireClasification,
            final Date dateRegister, final Date dateUpdate, final String email, final Float height,
            final Long id, final String identityDocument, final String name, final StateEnum state,
            final TypeUserEnum typeuser, final String username, final Float weight) {
        super(dateRegister, dateUpdate, id, name, state);
        this.bmi = bmi.getCategory();
        this.risk = bmi.getRisk();
        this.dateExpireClasification = dateExpireClasification;
        this.email = email;
        this.height = height;
        this.identityDocument = identityDocument;
        this.typeuser = typeuser;
        this.username = username;
        this.dateBirth = dateBirth;
        this.weight = weight;
        this.progress = 1;
        final LocalDate start = new java.sql.Date(dateBirth.getTime()).toLocalDate();
        final LocalDate end = LocalDate.now();
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
     * @return the cityBirth
     */
    public City getCityBirth() {
        return this.cityBirth;
    }

    /**
     * @return the cityResidential
     */
    public City getCityResidential() {
        return this.cityResidential;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return this.contact;
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
     * @return the eps
     */
    public String getEps() {
        return this.eps;
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
     * @return the maritalStatus
     */
    public MaritalStatusEnum getMaritalStatus() {
        return this.maritalStatus;
    }

    /**
     * @return the msisdn
     */
    public String getMsisdn() {
        return this.msisdn;
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
     * @return the skype
     */
    public String getSkype() {
        return this.skype;
    }

    /**
     * @return the statistic
     */
    public Statistic getStatistic() {
        return this.statistic;
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
    public void setActivities(final Set<ActivityDto> activities) {
        this.activities = activities;
    }

    /**
     * @param age the age to set
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * @param bmi the bmi to set
     */
    public void setBmi(final BmiCategoryEnum bmi) {
        this.bmi = bmi;
    }

    /**
     * @param cityBirth the cityBirth to set
     */
    public void setCityBirth(final City cityBirth) {
        this.cityBirth = cityBirth;
    }

    /**
     * @param cityResidential the cityResidential to set
     */
    public void setCityResidential(final City cityResidential) {
        this.cityResidential = cityResidential;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(final String contact) {
        this.contact = contact;
    }

    /**
     * @param dateBirth the dateBirth to set
     */
    public void setDateBirth(final Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    /**
     * @param dateExpireClasification the dateExpireClasification to set
     */
    public void setDateExpireClasification(final Date dateExpireClasification) {
        this.dateExpireClasification = dateExpireClasification;
    }

    /**
     * @param dateIngress the dateIngress to set
     */
    public void setDateIngress(final Date dateIngress) {
        this.dateIngress = dateIngress;
    }


    /**
     * @param dateInteraction the dateInteraction to set
     */
    public void setDateInteraction(final Date dateInteraction) {
        this.dateInteraction = dateInteraction;
    }

    /**
     * @param descriptionHistory the descriptionHistory to set
     */
    public void setDescriptionHistory(final String descriptionHistory) {
        this.descriptionHistory = descriptionHistory;
    }

    /**
     * @param diseases the diseases to set
     */
    public void setDiseases(final Set<DiseaseDto> diseases) {
        this.diseases = diseases;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @param eps the eps to set
     */
    public void setEps(final String eps) {
        this.eps = eps;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(final Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(final Set<GoalDto> goals) {
        this.goals = goals;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(final Float height) {
        this.height = height;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(final Boolean history) {
        this.history = history;
    }

    /**
     * @param identityDocument the identityDocument to set
     */
    public void setIdentityDocument(final String identityDocument) {
        this.identityDocument = identityDocument;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(final MaritalStatusEnum maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @param msisdn the msisdn to set
     */
    public void setMsisdn(final String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param progress the progress to set
     */
    public void setProgress(final Integer progress) {
        this.progress = progress;
    }

    /**
     * @param reward the reward to set
     */
    public void setReward(final RewardEnum reward) {
        this.reward = reward;
    }

    /**
     * @param risk the risk to set
     */
    public void setRisk(final TypeRiskEnum risk) {
        this.risk = risk;
    }

    /**
     * @param skype the skype to set
     */
    public void setSkype(final String skype) {
        this.skype = skype;
    }

    /**
     * @param statistic the statistic to set
     */
    public void setStatistic(final Statistic statistic) {
        this.statistic = statistic;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    /**
     * @param typeuser the typeuser to set
     */
    public void setTypeuser(final TypeUserEnum typeuser) {
        this.typeuser = typeuser;
    }

    /**
     * @param useCondition the useCondition to set
     */
    public void setUseCondition(final Boolean useCondition) {
        this.useCondition = useCondition;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(final Float weight) {
        this.weight = weight;
    }

}
