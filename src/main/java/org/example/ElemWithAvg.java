package org.example;

import java.util.Arrays;
import java.util.OptionalDouble;

public record ElemWithAvg(Element element, int avg) {

    public int[] elemNumbers() {
        return element.getNumbers();
    }

    public static ElemWithAvg fromElement(Element element) {
        OptionalDouble optAvg = Arrays.stream(element.getNumbers()).average();
        return new ElemWithAvg(element, optAvg.isPresent() ? (int) optAvg.getAsDouble() : 0);
    }
}
