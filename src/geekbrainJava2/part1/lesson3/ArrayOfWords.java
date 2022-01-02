package geekbrainJava2.part1.lesson3;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayOfWords {
    private static final String[] ARRAY_OF_WORDS = {
            "Привет",
            "Собака",
            "Кошка",
            "Дом",
            "Лес",
            "Медведь",
            "Привет",
            "Лес",
            "качели",
            "Привет",
            "Слон",
            "Привет",
            "Кошка",
            "Привет",
            "Лесоповал",
    };

    public static void main(String[] args) {
        Map<String, Integer> numberOfRepetitionsOfWords = new LinkedHashMap<>();
        for (String word : ARRAY_OF_WORDS) {
            Integer quantity = numberOfRepetitionsOfWords.get(word);
            if (quantity == null) {
                quantity = 0;
            }
            numberOfRepetitionsOfWords.put(word, quantity + 1);
        }
        for (Map.Entry<String, Integer> entry : numberOfRepetitionsOfWords.entrySet()) {
            System.out.printf("- Слово: %s - повторяется %d раз %n", entry.getKey(), entry.getValue());
        }
    }
}
