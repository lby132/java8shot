package com.moho;

import java.util.Arrays;
import java.util.List;

public class no {

    public interface AppleFormatter{
        String accept(Apple apple);
    }

    public static class AppleFancyFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" :
                    "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }
    }

    public static class AppleSimpleFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    public static void preetyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println("output = " + output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        preetyPrintApple(inventory, new AppleFancyFormatter());
        preetyPrintApple(inventory, new AppleSimpleFormatter());
    }

    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }

    }

    enum Color {
        RED,
        GREEN
    }

    

    }




