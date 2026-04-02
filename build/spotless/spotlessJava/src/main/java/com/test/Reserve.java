package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reserve {
  public static void main(String[] args) {
    System.out.println("Hello World");
    String str = "12345";
    String reversed =
        IntStream.rangeClosed(1, str.length())
            .mapToObj(i -> str.charAt(str.length() - i))
            .map(String::valueOf)
            .collect(Collectors.joining());

    List<String> list1 = Arrays.asList("a", "b", "c", "a", "d", "e", "f", "g", "a");

    List<String> reverse =
        list1.stream()
            .map(a -> new StringBuilder(a).reverse().toString())
            .collect(Collectors.toList());

    reverse.forEach(System.out::println);
  }
}
