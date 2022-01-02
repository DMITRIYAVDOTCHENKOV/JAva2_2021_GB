package geekbrainJava2.part1.lesson3;


import java.util.Set;

public interface TelephoneDirectory {
    void add(String surname, String phoneNumber);
        Set<String> get(String surname);
        Set<String> getSurname();

}
