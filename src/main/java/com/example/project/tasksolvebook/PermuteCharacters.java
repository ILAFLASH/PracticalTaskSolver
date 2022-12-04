package com.example.project.tasksolvebook;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PermuteCharacters {
    public void permute(String word) {
        permute("", word);
    }

    private void permute(String prefix, String word) {
        int n = word.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1, n));
            }
        }
    }

    public Set<String> permuteAndPrintStream(String word) {
        return permuteAndPrintStream("", word);
    }

    private Set<String> permuteAndPrintStream(String prefix, String word) {
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        int n = word.length();
        if (n == 0) {
            strings.add(prefix);
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .mapToObj(i -> permuteAndPrintStream(prefix + word.charAt(i),
                            word.substring(i + 1, n) + word.substring(0, i)))
                    .forEach(strings::addAll);
        }
        return strings;
    }
}
