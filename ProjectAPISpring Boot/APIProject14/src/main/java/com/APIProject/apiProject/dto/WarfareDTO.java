package com.APIProject.apiProject.dto;

public class WarfareDTO {

    public static class Request {
        //Declaracion de variable
        private String warfareName;

        private String email;

        private String faction;

        // Getters and setters
        public String getWarfareName() {return warfareName;}

        public void setWarfareName(String warfareName) {this.warfareName = warfareName;}

        public String getEmail() {return email;}

        public void setEmail(String email) {this.email = email; }

        public String getFaction() {return faction;}

        public void setFaction(String faction) {
            this.faction = faction;
        }
    }

    public static class RequestUnits {
        //Declaracion de variable
        private Integer assault;

        private Integer engineer;

        private Integer tank;

        private Integer bunker;

        // Getters and setters
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
    }

    public static class Response{
        //Declaracion de variable
        private String warfareName;

        private String email;

        private String faction;

        private Integer rank;

        private Integer wins;

        private Integer oil;

        private Integer money;

        private Integer people;

        private Integer assault;

        private Integer engineer;

        private Integer tank;

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
    }

}
