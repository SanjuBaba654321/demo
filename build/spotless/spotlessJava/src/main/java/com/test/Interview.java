package com.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// import static java.util.stream.Nodes.collect;
// import static org.apache.coyote.http11.Constants.a;

public class Interview {

  public static void main(String[] args) {
    System.out.println("Hello World");
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);
    list.stream().distinct().forEach(System.out::println);
    System.out.println(list.stream().distinct().count());

    HashSet<Integer> set = new HashSet();

    list.stream().filter(a -> !set.add(a)).collect(Collectors.toList());
    // find the first non repeated element
    String str = "programming";
    // str.chars().filter((a->str.indexof(a)==str))
    HashSet<Character> set1 = new HashSet<>();

    System.out.println(str.chars().filter(a -> !set1.add((char) a)).findFirst());
    str.chars().filter(a -> !set1.add((char) a)).findFirst().ifPresent(System.out::println);
    System.out.println(
        str.chars().mapToObj(c -> (char) c).filter(a -> !set1.add((char) a)).findFirst());
    System.out.println(str.chars().filter(a -> !set1.add((char) a)).findFirst().orElse(0));
    System.out.println(
        str.chars().filter(a -> !set1.add((char) a)).findFirst().orElseGet(() -> -1));
    System.out.println(
        str.chars()
            .filter(a -> !set1.add((char) a))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("no element found")));
    System.out.println(str.chars().filter(a -> !set1.add((char) a)).count());
    // System.out.println(str.chars().filter(a -> !set1.add((char)
    // a)).findFirst().orElseThrow(()->new RuntimeException("no element found")).getAsInt());

    Map<Character, Long> fre =
        str.chars()
            .mapToObj(c -> (char) c)
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()));
    str
        .chars()
        .mapToObj(c -> (char) c)
        .collect(
            Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .findFirst()
        .ifPresent(e -> System.out.println(e.getKey() + " " + e.getValue()));

    fre.forEach((k, v) -> System.out.println(k + " --" + v));
  }
}
