package ru.neolab.peyl.test_tasks_part_two.array_sorting;

/**
 * Class for exception for work with sorting odd numbers in array
 */
public class OddNumberSorterException extends Exception {

    /**
     * Basic constructor for exception
     *
     * @param message - message exception
     */
    public OddNumberSorterException(final String message) {
        super(message);
    }
}
