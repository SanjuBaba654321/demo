package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurence {
  public static void main(String[] args) {
    System.out.println("Hello World");

    String text = "java stream java spring stream";

    /*rrays.stream(text.split(" "))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .forEach((word, count) -> System.out.println(word + ": " + count));
        // Find the occurence of each word in the text
        String[] words = text.split(" ");
    */
    List<String> str1 = Arrays.asList(text);
    str1.stream()
        .flatMap(word -> word.chars().mapToObj(c -> (char) c))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .forEach((word, count) -> System.out.println(word + ": :" + count));
  }
}
