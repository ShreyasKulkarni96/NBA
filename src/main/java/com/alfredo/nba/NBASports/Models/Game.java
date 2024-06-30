package com.alfredo.nba.NBASports.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "game")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "season")
    private int season;
    @Column(name = "status")
    private String status;
    @Column(name = "period")
    private int period;
    @Column(name = "time")
    private String time;
    @Column(name = "postseason")
    private boolean postseason;
    @Column(name = "home_team_score")
    private int homeTeamScore;
    @Column(name = "visitor_team_score")
    private int visitorTeamScore;
    @Column(name = "home_team")
    private HomeTeam homeTeam;
    @Column(
            name = "visitor_team"
    )
    private VisitorTeam visitorTeam;

    public Game() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSeason() {
        return this.season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPostseason() {
        return this.postseason;
    }

    public void setPostseason(boolean postseason) {
        this.postseason = postseason;
    }

    public int getHomeTeamScore() {
        return this.homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getVisitorTeamScore() {
        return this.visitorTeamScore;
    }

    public void setVisitorTeamScore(int visitorTeamScore) {
        this.visitorTeamScore = visitorTeamScore;
    }

    public HomeTeam getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public VisitorTeam getVisitorTeam() {
        return this.visitorTeam;
    }

    public void setVisitorTeam(VisitorTeam visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public String toString() {
        return "Game [id=" + this.id + ", date=" + this.date + ", season=" + this.season + ", status=" + this.status + ", period=" + this.period + ", time=" + this.time + ", postseason=" + this.postseason + ", homeTeamScore=" + this.homeTeamScore + ", visitorTeamScore=" + this.visitorTeamScore + ", homeTeam=" + this.homeTeam + ", visitorTeam=" + this.visitorTeam + "]";
    }
}
