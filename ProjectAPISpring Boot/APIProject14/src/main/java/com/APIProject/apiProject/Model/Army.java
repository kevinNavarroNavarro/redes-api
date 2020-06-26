package com.APIProject.apiProject.Model;

public class Army {
    public Army() {
        this.assault = 0;
        this.engineer = 0;
        this.tank = 0;
    }

    Integer assault;
     Integer engineer;
     Integer tank;

    public Integer getAssault() { return assault; }

    public void setAssault(Integer assault) { this.assault = assault; }

    public Integer getEngineer() { return engineer; }

    public void setEngineer(Integer engineer) { this.engineer = engineer; }

    public Integer getTank() { return tank; }

    public void setTank(Integer tank) { this.tank = tank; }
}
