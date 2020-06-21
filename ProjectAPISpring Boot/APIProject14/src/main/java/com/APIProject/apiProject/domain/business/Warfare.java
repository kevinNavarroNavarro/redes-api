package com.APIProject.apiProject.domain.business;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Warfare")
public class Warfare {

    //Declaracion de variable
    @Id
    @Column(name = "warfare_name")
    @Size(max = 25)
    private String warfareName;

    @Column(name = "Email")
    @Size(max = 25)
    @Email
    private String email;

    @NotNull
    @Column(name = "Faction")
    @Size(max = 10)
    private String faction;

    @NotNull
    @Column(name = "Rank")
    private Integer rank;

    @NotNull
    @Column(name = "Wins")
    private Integer wins;

    @NotNull
    @Column(name = "Oil")
    private Integer oil;

    @NotNull
    @Column(name = "Money")
    private Integer money;

    @NotNull
    @Column(name = "People")
    private Integer people;

    @NotNull
    @Column(name = "Assault")
    private Integer assault;

    @NotNull
    @Column(name = "Engineer")
    private Integer engineer;

    @NotNull
    @Column(name = "Tank")
    private Integer tank;

    @NotNull
    @Column(name = "Bunker")
    private Integer bunker;

    // Getters and setters
    public String getWarfareName() {return warfareName;}

    public void setWarfareName(String warfareName) {this.warfareName = warfareName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email; }

    public String getFaction() {return faction;}

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getOil() {
        return oil;
    }

    public void setOil(Integer oil) {
        this.oil = oil;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getAssault() {
        return assault;
    }

    public void setAssault(Integer assault) {
        this.assault = assault;
    }

    public Integer getEngineer() {
        return engineer;
    }

    public void setEngineer(Integer engineer) {
        this.engineer = engineer;
    }

    public Integer getTank() {
        return tank;
    }

    public void setTank(Integer tank) {
        this.tank = tank;
    }

    public Integer getBunker() {
        return bunker;
    }

    public void setBunker(Integer bunker) {
        this.bunker = bunker;
    }

    // ToString
    @Override
    public String toString() {
        return "Warfare{" +
                "warfareName=" + warfareName +
                ", email='" + email + '\'' +
                ", faction='" + faction + '\'' +
                ", rank=" + rank +
                ", wins=" + wins +
                ", oil=" + oil +
                ", money=" + money +
                ", people=" + people +
                ", assault=" + assault +
                ", engineer=" + engineer +
                ", tank=" + tank +
                ", bunker=" + bunker +
                '}';
    }
}

