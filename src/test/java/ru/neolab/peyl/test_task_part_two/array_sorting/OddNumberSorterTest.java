package ru.neolab.peyl.test_task_part_two.array_sorting;

import org.junit.Before;
import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.array_sorting.OddNumberSorter;
import ru.neolab.peyl.test_tasks_part_two.array_sorting.OddNumberSorterException;

import static org.junit.Assert.assertArrayEquals;

public class OddNumberSorterTest {
    private OddNumberSorter oddNumberSorter;

    @Before
    public void init() {
        oddNumberSorter = new OddNumberSorter();
    }

    @Test
    public void testArrayWithOddNumbers() throws OddNumberSorterException {
        int[] inputArray = {5, 3, 2, 8, 1, 4};
        int[] expectedArray = {1, 3, 2, 8, 5, 4};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testArrayWithZero() throws OddNumberSorterException {
        int[] inputArray = {5, 3, 2, 0, 1, 4};
        int[] expectedArray = {1, 3, 2, 0, 5, 4};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testOnlyEvenNumbersInArray() throws OddNumberSorterException {
        int[] inputArray = {8, 6, 2, 8, 10, 4};
        int[] expectedArray = {8, 6, 2, 8, 10, 4};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testOnlyOddNumbersInArray() throws OddNumberSorterException {
        int[] inputArray = {1, 13, 5, 7, 19, 3};
        int[] expectedArray = {1, 3, 5, 7, 13, 19};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testArrayWithOddNegativeNumbers() throws OddNumberSorterException {
        int[] inputArray = {5, -3, 2, 8, -1, 4};
        int[] expectedArray = {-3, -1, 2, 8, 5, 4};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testOnlyNegativeOddNumbersInArray() throws OddNumberSorterException {
        int[] inputArray = {-1, -13, -5, -7, -19, -3};
        int[] expectedArray = {-19, -13, -7, -5, -3, -1};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testNegativeOddAndEvenNumbersInArray() throws OddNumberSorterException {
        int[] inputArray = {-1, 10, 2, -6, 19, -3};
        int[] expectedArray = {-3, 10, 2, -6, -1, 19};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testEmptyArray() throws OddNumberSorterException{
        int[] inputArray = {};
        int[] expectedArray = {};
        int[] actualArray = oddNumberSorter.sortArray(inputArray);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test(expected = OddNumberSorterException.class)
    public void testNullArray() throws OddNumberSorterException{
        int[] inputArray = null;
        oddNumberSorter.sortArray(inputArray);
    }
}
