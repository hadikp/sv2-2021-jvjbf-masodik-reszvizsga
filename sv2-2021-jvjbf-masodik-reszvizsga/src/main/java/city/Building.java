package city;

public abstract class Building {

    private int area;
    protected int levels;
    private Address address;

    public Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(int area, Address address) {
        this.area = area;
        this.levels = 1;
        this.address = address;
    }

    public int getFullArea() {
        int sumArea = area * levels;
        return sumArea;
    }

    public abstract int calculateNumberOfPeopleCanFit(); //Hány ember fér be az épületbe

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }
}
