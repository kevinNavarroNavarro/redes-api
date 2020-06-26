package com.APIProject.apiProject.dto;

import com.APIProject.apiProject.Model.Army;
import com.APIProject.apiProject.Model.Building;
import com.APIProject.apiProject.Model.Resource;
import com.APIProject.apiProject.Model.ResultWarfare;

public class WarfareDTO {

    public static class Request {
        //Declaracion de variable
        private String guerrillaName;

        private String email;

        private String faction;

        // Getters and setters
        public String getGuerrillaName() {return guerrillaName;}

        public void setGuerrillaName(String guerrillaName) {this.guerrillaName = guerrillaName;}

        public String getEmail() {return email;}

        public void setEmail(String email) {this.email = email; }

        public String getFaction() {return faction;}

        public void setFaction(String faction) {
            this.faction = faction;
        }
    }

    public static class RequestUnits {
        //Declaracion de variable

        Building buildings = new Building();

        Army army = new Army();

        // Getters and setters
        public Building getBuildings() { return buildings; }

        public void setBuildings(Building buildings) { this.buildings = buildings; }

        public Army getArmy() { return army; }

        public void setArmy(Army army) { this.army = army; }
    }

    public static class Response{
        //Declaracion de variable
        private String name;

        private String email;

        private String faction;

        private Integer rank;

        private Integer wins;

        Resource resources = new Resource();

        Army army = new Army();

        Building buildings = new Building();

        // Getters and setters
        public Building getBuildings() { return buildings; }

        public void setBuildings(Building buildings) { this.buildings = buildings; }

        public Army getArmy() { return army; }

        public void setArmy(Army army) { this.army = army; }

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}

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

        public Resource getResources() { return resources; }

        public void setResources(Resource resources) { this.resources = resources; }
    }

    public static class ResponseWarfare{
        //Declaracion de variable
        private String name;

        private String email;

        private String faction;

        private Integer rank;

        private Integer wins;

        Resource resources = new Resource();

        Army army = new Army();

        Building buildings = new Building();

        ResultWarfare results = new ResultWarfare();

        // Getters and setters
        public Building getBuildings() { return buildings; }

        public void setBuildings(Building buildings) { this.buildings = buildings; }

        public Army getArmy() { return army; }

        public void setArmy(Army army) { this.army = army; }

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}

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

        public Resource getResources() { return resources; }

        public void setResources(Resource resources) { this.resources = resources; }

        public ResultWarfare getResults() { return results; }

        public void setResults(ResultWarfare results) { this.results = results; }
    }

}
