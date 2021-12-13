package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20; //1 embernek ennyi m2 kell

    public Home(int area, int levels, Address address) {
        super(area, address);
        if (levels > 3) {
            throw new IllegalArgumentException("3. szint nem lehet!");
        }
        this.levels = levels;
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        int numberOfPeople = getFullArea() / SQUARE_METERS_NEED_PER_PERSON;
        return numberOfPeople;
    }
}
