package com.alfredo.nba.NBASports.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "all_teams")
public class AllTeamWrapper implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @JsonProperty("id")
    private Long id;

    @Column(name = "conference")
    @JsonProperty("conference")
    private String conference;

    @Column(name = "division")
    @JsonProperty("division")
    private String division;

    @Column(name = "city")
    @JsonProperty("city")
    private String city;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "full_name")
    @JsonProperty("full_name")
    private String fullName;
    @Column(name = "abbreviation")
    @JsonProperty("abbreviation")
    private String abbreviation;

    public AllTeamWrapper() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConference() {
        return this.conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return this.division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String toString() {
        return "AllTeamWrapper [id=" + this.id + ", conference=" + this.conference + ", division=" + this.division + ", city=" + this.city + ", name=" + this.name + ", fullName=" + this.fullName + ", abbreviation=" + this.abbreviation + "]";
    }
}


