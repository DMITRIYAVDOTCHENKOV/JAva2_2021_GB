package geekbrainJava2.part1.lesson3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AddingToTheBook implements TelephoneDirectory {

    private final Map<String, Set<String>> phoneList = new TreeMap<>();


    @Override
    public void add(String surname, String phoneNumber) {
        Set<String> phone = phoneList.get(surname);
        if (phone == null) {
            Set<String> phoneSet = new HashSet<>();
            phoneSet.add(phoneNumber);
            phoneList.put(surname, phoneSet);
        } else {
            phone.add(phoneNumber);
            phoneList.put(surname,phone);
        }
    }
    @Override
    public Set<String> get(String surname) {
        return this.phoneList.get(surname);
    }

    @Override
    public Set<String> getSurname() {
        return this.phoneList.keySet();
    }

}

