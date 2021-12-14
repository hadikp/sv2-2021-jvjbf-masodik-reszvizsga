package city;

public class Office extends Building {

    private String company;
    private int numberOfTablesPerLevel;

    public Office (int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        if (area / numberOfTablesPerLevel < 2 || area / numberOfTablesPerLevel > 5){
            throw new IllegalArgumentException("Too many tables!");
        }
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels() - 1);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
