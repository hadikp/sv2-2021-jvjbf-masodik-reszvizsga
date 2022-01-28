package city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        long sum = 0;
        for(int i = 0; i < buildings.size();i++){
            sum += buildings.get(i).getArea();
        }
        if(sum+building.getArea()<=getFullArea()){
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than 500");
        }
    }

    /*public Building findHighestBuilding() {
        int max = 0;
        int myI = 0;
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).levels > max) {
                max = buildings.get(i).levels;
                myI = i;
            }
        }
        return buildings.get(myI);
    }*/

    public Building findHighestBuilding() {
        return buildings.stream().max(Comparator.comparing(Building::getLevels)).orElseThrow( () -> new IllegalArgumentException("Üres Stream!"));
    }

    /*public List<Building> findBuildingsByStreet(String street){
        List<Building> result = new ArrayList<>();
        for(int i = 0; i < buildings.size(); i++){
            if(buildings.get(i).getAddress().getStreet().equals(street)){
                result.add(buildings.get(i));
            }
        }
        return result;
    }*/

    public List<Building> findBuildingsByStreet(String street) {
        return buildings.stream().filter(o -> o.getAddress().getStreet().equals(street)).collect(Collectors.toList());
    }

    /*boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        for(int i = 0; i < buildings.size(); i++){
            if(buildings.get(i).calculateNumberOfPeopleCanFit() > numberOfPeople){
                return true;
            }
        }
        return false;
    }*/

    boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        return buildings.stream().anyMatch(o -> o.calculateNumberOfPeopleCanFit() > numberOfPeople);
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return new ArrayList<>(buildings);
    }
}
