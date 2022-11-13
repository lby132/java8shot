package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FilteringApples {

    public static void main(String... args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println("greenApples = " + greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHavyApple);
        System.out.println("heavyApples = " + heavyApples);

        List<Apple> collect = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        System.out.println("collect = " + collect);

        List<Apple> collect1 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        System.out.println("collect1 = " + collect1);

        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println("greenApples2 = " + greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println("heavyApples2 = " + heavyApples2);

        List<Apple> weirdApples =  filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println("weirdApples = " + weirdApples);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventor) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventor) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        } return result;
    }

    public static List<Apple> filterHavyApples(List<Apple> inventor) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventor) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }return result;
    }

    public static class Apple {

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

    }
}
