package com.example.project.tasksolvebook;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrome {
    public void isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        System.out.println(word.equals(sb.toString()));

        String res = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            res += word.charAt(i);
        }
        System.out.println(word.equals(res));

        char[] chars = word.toCharArray();
        ArrayUtils.reverse(chars);
        String resFromChars = "";
        for (int i = 0; i < chars.length; i++) {
            resFromChars += chars[i];
        }
        System.out.println(word.equals(resFromChars));

        String collect = Arrays.stream(word.split(""))
                .collect(Collectors.collectingAndThen(Collectors.joining(),
                        s -> new StringBuilder(s).reverse().toString()));
        System.out.println(word.equals(collect));

        boolean isPalindrome = IntStream.range(0, word.length() / 2)
                .noneMatch(i -> word.charAt(i) != word.charAt(word.length() - 1 - i));
        System.out.println(isPalindrome);
    }
}
