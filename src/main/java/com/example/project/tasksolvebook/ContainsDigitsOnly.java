package com.example.project.tasksolvebook;

import org.apache.commons.lang3.StringUtils;

public class ContainsDigitsOnly {
    public boolean characterIsDigitsMethod(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean streamMethod(String str) {
        return str.chars()
                .allMatch(Character::isDigit);
    }

    public boolean stringMatches(String str) {
        return str.matches("\\d+");
    }

    public boolean apacheLang(String str) {
        return StringUtils.isNumeric(str);
    }
}
