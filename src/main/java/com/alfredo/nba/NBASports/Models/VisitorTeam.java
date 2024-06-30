package com.alfredo.nba.NBASports.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class VisitorTeam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "conference")
    private String conference;
    @Column(name = "division")
    private String division;
    @Column(name = "city")
    private String city;
    @Column(name = "name")
    private String name;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "abbreviation")
    private String abbreviation;

    public VisitorTeam() {
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
        return "VisitorTeam [id=" + this.id + ", conference=" + this.conference + ", division=" + this.division + ", city=" + this.city + ", name=" + this.name + ", fullName=" + this.fullName + ", abbreviation=" + this.abbreviation + "]";
    }
}
