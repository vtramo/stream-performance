package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SorterStream sorterStream = new SorterStream();
        SorterNoStream sorterNoStream = new SorterNoStream();
        Element[] elements = Element.makeElements(10, 10);
        System.out.println(sorterStream.sort(elements));
        System.out.println(sorterNoStream.sort(elements));
    }
}