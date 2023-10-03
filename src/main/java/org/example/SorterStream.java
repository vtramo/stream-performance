package org.example;

import java.util.Arrays;
import java.util.OptionalDouble;

public class SorterStream {
    public long sort(Element[] elements) {
        OptionalDouble optionalDouble = Arrays.stream(elements)
            .map(ElemWithAvg::fromElement)
            .mapToInt(elemWithAvg -> Arrays.stream(elemWithAvg.elemNumbers())
                .sorted()
                .distinct()
                .filter(number -> number >= elemWithAvg.avg())
                .sum())
            .average();
        return optionalDouble.isEmpty() ? 0L : (long) optionalDouble.getAsDouble();
    }
}
