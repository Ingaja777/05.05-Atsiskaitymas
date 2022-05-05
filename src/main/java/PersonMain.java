import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface PersonMain {
    public static void main(String[] args) throws IOException {
        Map<Integer, Person> persons = new HashMap<>();
        File file = new File("persons.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Scanner sc = new Scanner(System.in);
        boolean repeat=true;

        if (!file.exists()) {
            file.createNewFile();
        }
        while (repeat) {
            System.out.println("Įveskite vardą");
            String name = sc.nextLine();

            System.out.println("Įveskite pavardę");
            String surname = sc.nextLine();
            System.out.println("Įveskte asmens kodą");
            int personalID = Integer.valueOf(sc.nextLine());
            if (persons.get(personalID) == null) {
                persons.put(personalID, new Person(name, surname, personalID));
            } else {
                System.out.println("Toks asmuo jau egzistuoja");
            }
            System.out.println("Ar norite baigti - TAIP - 1, NE - 0");
            if (sc.nextLine().equals("1")){
                repeat=false;
            };
        }

        objectMapper.writeValue(file, persons);
    }
}
