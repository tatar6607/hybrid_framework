package javaexams;

import org.testng.annotations.Test;

import java.util.*;


public class Q1 {


    @Test
    public void testName() {
    }

    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("green");
        colors.add("blue");
        colors.add("red");
        colors.add("yellow");
        colors.remove(2);
        colors.add(3,"cyan");

        System.out.println(colors);
    }
}
