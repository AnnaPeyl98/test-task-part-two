package ru.neolab.peyl.test_tasks_part_two.array_sorting;

import java.util.Arrays;

/**
 * Class for sorting only odd numbers in arrays
 */
public class OddNumberSorter {

    /**
     * Method sorting only odd numbers in arrays, even numbers remain in place
     *
     * @param unsortedArray - input unsorted array
     * @return array with sorted odd numbers
     * @throws OddNumberSorterException if input array is null
     */
    public int[] sortArray(final int[] unsortedArray) throws OddNumberSorterException {

        if (unsortedArray == null) {
            throw new OddNumberSorterException("Reported array is null");
        }
        int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);

        int[] oddNumbersArray = Arrays.stream(sortedArray)
                .filter(number -> number % 2 != 0)
                .sorted()
                .toArray();

        int indexOddArray = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] % 2 != 0) {
                sortedArray[i] = oddNumbersArray[indexOddArray];
                indexOddArray++;
            }
        }

        return sortedArray;
    }

}
