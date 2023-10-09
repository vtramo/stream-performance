package org.example;

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
        int[] numbers;
        long finalSum = 0L;

        for (Element element: elements) {
            numbers = element.getNumbers();
            OrderedResultWithSum orderedResultWithSum = applyOperations(numbers);
            finalSum += orderedResultWithSum.sum;
        }

        return finalSum / elements.length;
    }

    private record OrderedResultWithSum(int[] result, int sum) {}

    private OrderedResultWithSum applyOperations(int[] numbers) {
        int[] hashArray = new int[Element.BOUND];
        int sum = 0;

        for (int number: numbers) {
            sum += number;
            hashArray[number] = 1;
        }

        int avg = sum / numbers.length;

        int newSize = 0;
        for (int number: numbers) {
            if (number >= avg) {
                newSize++;
            } else {
                hashArray[number] = 0;
            }
        }

        int[] result = new int[newSize];
        int index = 0;
        int finalSum = 0;
        for (int number = 0; number < hashArray.length; number++) {
            if (hashArray[number] == 0) continue;
            result[index++] = number;
            finalSum += number;
        }

        return new OrderedResultWithSum(result, finalSum);
    }
}