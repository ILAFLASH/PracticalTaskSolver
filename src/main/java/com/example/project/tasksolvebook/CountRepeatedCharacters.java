package com.example.project.tasksolvebook;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountRepeatedCharacters {

    public Map<Character, Integer> simpleMethod(String word) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            Integer amount = result.get(letter);
            result.put(letter, Objects.isNull(amount) ? 1 : ++amount);
        }
        return result;
    }

    public Map<Character, Integer> mapComputeMethod(String word) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char aChar = word.charAt(i);
            result.compute(aChar, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public Map<Character, Long> streamMethod(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
