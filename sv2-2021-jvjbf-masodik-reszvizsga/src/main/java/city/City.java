package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long FullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        FullArea = fullArea;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public Building findHighestBuilding() {
        int max = 0;
        int myI = 0;
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).levels > max) {
                max = buildings.get(i).levels;
                myI = i;
            }
        }
        return buildings.get(myI);
    }

    public List<Building> findBuildingsByStreet(String street){
        List<Building> result = new ArrayList<>();
        for(int i = 0; i < buildings.size(); i++){
            if(buildings.get(i).getAddress().getStreet().equals(street)){
                result.add(buildings.get(i));
            }
        }
        return result;
    }

    boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        for(int i = 0; i < buildings.size(); i++){
            if(buildings.get(i).calculateNumberOfPeopleCanFit() > numberOfPeople){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return FullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
