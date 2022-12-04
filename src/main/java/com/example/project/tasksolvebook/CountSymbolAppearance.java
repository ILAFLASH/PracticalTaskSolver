package com.example.project.tasksolvebook;

import org.apache.commons.lang3.tuple.Pair;

public class CountSymbolAppearance {
    public Pair<Character, Integer> simpleMethod(char symbol, String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (symbol == string.charAt(i))
                count++;
        }
        return Pair.of(symbol, count);
    }

    public Pair<Character, Long> streamMethod(char symbol, String string) {
        long count = string.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> symbol == c)
                .count();
        return Pair.of(symbol, count);
    }
}
