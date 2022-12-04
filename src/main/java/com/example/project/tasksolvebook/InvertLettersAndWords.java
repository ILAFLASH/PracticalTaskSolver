package com.example.project.tasksolvebook;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InvertLettersAndWords {
    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public String simpleLetterInvertMethod(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    public String arrayUseLettersInvertMethod(String string) {
        char[] letters = string.toCharArray();
        for (int i = 0, j = letters.length - 1; i < j; i++, j--) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return Arrays.toString(letters);
    }

    public String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();
        for (int j = words.length - 1; j >= 0; j--) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = words[j].length() - 1; i >= 0; i--) {
                reverseWord.append(words[j].charAt(i));
            }
            reversedString.append(reverseWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }

    public String reverseWordsWithStream(String str) {
        return StringUtils.reverseDelimited(PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" ")), ' ');
    }

    public String reverseStringWithStream(String string) {
        return PATTERN.splitAsStream(string)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(" "));
    }
}
