package org.example;

import java.util.Arrays;

/*
  Make 100, 1k, 10k, 100k, 1m elements with 100, 1k, 10k, 100k, 1m randomly generated numbers respectevly.
  What to do:
  * Sort numbers
  * Calculate average
  * Keep only unique numbers
  * Filter out lower than average
  * Change element to sum of numbers (long)
  * Get average of summs
*/
public class SorterNoStream {
    public long sort(Element[] elements) {
        Element element;
        int[] numbers;
        int average;
        long finalSum = 0L;

        for (int i = 0; i < elements.length; i++) {
            element = elements[i];
            numbers = element.getNumbers();
            Arrays.sort(numbers);
            average = avgInt(numbers);
            numbers = keepUnique(numbers);
            numbers = filterOutLowerThanAvg(numbers, average);
            finalSum += sum(numbers);
        }

        return finalSum / elements.length;
    }

    private int avgInt(int[] numbers) {
        Long sum = sum(numbers);
        sum /= numbers.length;
        return sum.intValue();
    }

    private int[] keepUnique(int[] numbers) {
        if (numbers.length == 0) {
            return new int[0];
        }
        if (numbers.length == 1) {
            return numbers;
        }
        int newSize = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] != numbers[i + 1]) {
                newSize++;
            }
        }
        if (numbers[numbers.length - 2] != numbers[numbers.length - 1]) {
            newSize++;
        }
        int[] result = new int[newSize];
        int j = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] != numbers[i + 1]) {
                result[j] = numbers[i];
                j++;
            }
        }
        if (numbers[numbers.length - 2] != numbers[numbers.length - 1]) {
            result[j] = numbers[numbers.length - 1];
        }
        return result;
    }

    private int[] filterOutLowerThanAvg(int[] numbers, int average) {
        int newSize = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= average) {
                newSize++;
            }
        }
        int[] result = new int[newSize];
        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= average) {
                result[j] = numbers[i];
                j++;
            }
        }
        return result;
    }

    private long sum(int[] numbers) {
        long sum = 0L;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}