package com.example.project.other;

import java.util.*;

public class CollectorTest {
    public Map<String, List<Integer>> evenAndOdd(List<Integer> numbers) {
        return numbers.stream()
                .collect(this::createMap, this::addToMap, this::mergeMap);
    }

    private Map<String, List<Integer>> createMap() {
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        map.put("even", new ArrayList<>());
        map.put("odd", new ArrayList<>());
        return map;
    }

    private void addToMap(Map<String, List<Integer>> map, Integer number) {
        if (number % 2 == 0) {
            map.get("even").add(number);
        } else {
            map.get("odd").add(number);
        }
    }

    private void mergeMap(Map<String, List<Integer>> map1, Map<String, List<Integer>> map2) {
        map2.forEach((k, v) ->map1.get(k).addAll(v));
    }
}
