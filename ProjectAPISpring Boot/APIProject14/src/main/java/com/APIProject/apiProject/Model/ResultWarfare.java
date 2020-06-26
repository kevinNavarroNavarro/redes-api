package com.APIProject.apiProject.Model;

public class ResultWarfare {

    String name;
    Resource resources = new Resource();
    Army army = new Army();
    Building buildings = new Building();

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Resource getResources() { return resources; }

    public void setResources(Resource resources) { this.resources = resources; }

    public Army getArmy() { return army; }

    public void setArmy(Army army) { this.army = army; }

    public Building getBuildings() { return buildings; }

    public void setBuildings(Building buildings) { this.buildings = buildings; }
}
