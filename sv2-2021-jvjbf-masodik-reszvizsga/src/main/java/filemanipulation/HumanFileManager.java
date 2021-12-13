package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        List<String> humansL = new ArrayList<>();
        try {
            humansL = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
        makeHuman(humansL);
    }

    public void makeHuman(List<String> humansL) {
        for (String st: humansL) {
            String[] humansLSplit = st.split(";");
            humans.add(new Human(humansLSplit[0], humansLSplit[1]));
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> man = new ArrayList<>();
        for (Human h: humans) {
            if (h.getIdentityNumber().startsWith("1") || h.getIdentityNumber().startsWith("3")) {
                String mansL = String.format("%s;%s", h.getName(), h.getIdentityNumber());
                man.add(mansL);
            }
        }
        try {
            Files.write(path, man);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public List<Human> getHumans() {
        return humans;
    }
}
