package com.example.project.tasksolvebook;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class CountVowelsAndConsonants {
    private static final String CONSONANTS_LITERALS = "aeiouyAEIOUY";
    private static final String VOWELS_LITERALS = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public static final String CONSONANTS = "consonants";
    public static final String VOWELS = "vowels";

    public Map<String, Integer> simpleQuickMethod(String str) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put(CONSONANTS, 0);
        result.put(VOWELS, 0);
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < CONSONANTS_LITERALS.length(); j++) {
                if (str.charAt(i) == CONSONANTS_LITERALS.charAt(j))
                    result.put(CONSONANTS, result.get(CONSONANTS) + 1);
            }
            for (int j = 0; j < VOWELS_LITERALS.length(); j++) {
                if (str.charAt(i) == VOWELS_LITERALS.charAt(j))
                    result.put(VOWELS, result.get(VOWELS) + 1);
            }
        }
        return result;
    }

    public Map<String, Integer> simpleMethod(String str) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put(CONSONANTS, 0);
        result.put(VOWELS, 0);
        for (int i = 0; i < str.length(); i++) {
            if (CONSONANTS_LITERALS.contains(String.valueOf(str.charAt(i)))) {
                result.put(CONSONANTS, result.get(CONSONANTS) + 1);
            } else {
                if (VOWELS_LITERALS.contains(String.valueOf(str.charAt(i))))
                    result.put(VOWELS, result.get(VOWELS) + 1);
            }
        }
        return result;
    }

    public Pair<Integer, Integer> anotherMethod(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }
        return Pair.of(vowels, consonants);
    }

    public Pair<Long, Long> streamMethod(String str) {
        str = str.toLowerCase();
        long vowelsCount = str.chars()
                .filter(c -> allVowels.contains((char) c))
                .count();
        long consonantsCount = str.chars()
                .filter(c -> !allVowels.contains((char) c))
                .filter(c -> c > 'a' && c <= 'z')
                .count();
        return Pair.of(vowelsCount, consonantsCount);
    }

    public Pair<Long, Long> partitioningByMethod(String str) {
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(partitioningBy(allVowels::contains, counting()));
        return Pair.of(result.get(true), result.get(false));
    }
}
