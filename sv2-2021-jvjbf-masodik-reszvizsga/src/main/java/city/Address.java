package city;

public class Address {

    private String street;
    private int buildingNumber;

    public Address(String street, int houseNumber) {
        this.street = street;
        this.buildingNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }
}
