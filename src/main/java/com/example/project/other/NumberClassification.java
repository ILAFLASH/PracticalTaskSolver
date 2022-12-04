package com.example.project.other;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

@AllArgsConstructor
public class NumberClassification implements Collector<Integer, List<Integer>, List<Integer>> {
    private Predicate<Integer> addOrNot;

    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (a, b) -> {
            if (addOrNot.test(b))
                a.add(b);
        };
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (a, b) -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(a);
            list.addAll(b);
            return list;
        };
    }

    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        Comparator<Integer> comparator = (o1, o2) -> {
            Objects.requireNonNull(o1);
            Objects.requireNonNull(o2);
            if (o1.equals(o2))
                return 0;
            if (o2 < o1)
                return -2;
            return 6;
        };
        return a -> a.stream()
                .filter(i -> i >= 3)
                .sorted(comparator)
                .toList();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
