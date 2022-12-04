package com.example.project.other;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsGroupingBy {
    public void groupToMap() {
        Map<String, List<String>> map = Map.of("documents", List.of("doc", "txt", "pdf"), "image", List.of("jpg", "png"));
        Function<File, String> getFileExtension = file -> {
            String fileName = file.getName();
            int lastIndex = fileName.lastIndexOf(".");
            if (lastIndex != -1) {
                return fileName.substring(lastIndex + 1);
            }
            return "";
        };
        Function<File, String> outerClassifier = file -> {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String ext = getFileExtension.apply(file);
                if (entry.getValue().contains(ext))
                    return entry.getKey();
            }
            return "not classified";
        };
        Map<String, Map<String, List<File>>> collect = Arrays.stream(Objects.requireNonNull(new File("src/main/java/com/example/project/other/files").listFiles()))
                .collect(Collectors.groupingBy(outerClassifier, Collectors.groupingBy(getFileExtension)));
        for (Map.Entry<String, Map<String, List<File>>> outerEntry : collect.entrySet()) {
            for (Map.Entry<String, List<File>> innerEntry : outerEntry.getValue().entrySet()) {
                System.out.println(outerEntry.getKey() + " " + innerEntry.getKey() + " " + innerEntry.getValue());
            }
        }
    }
}
