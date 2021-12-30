package geekbrainJava2.part1.lesson3;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        AddingToTheBook addingToTheBook = new AddingToTheBook();
        addingToTheBook.add("Петров", "123456789");
        addingToTheBook.add("Петров", "1234589");
        addingToTheBook.add("Сидоров", "126789");
        addingToTheBook.add("Иванов", "235679");
        addingToTheBook.add("Лисицын", "1444489");
        addingToTheBook.add("Пушкин", "4589");
        addingToTheBook.add("Пушкин", "123333336789");


        Set<String> Surname = addingToTheBook.getSurname();
        for (String surname : Surname) {
            System.out.printf("Пользователь %s имеет номер телефона %s %n", surname, addingToTheBook.get(surname));
        }

    }
}

