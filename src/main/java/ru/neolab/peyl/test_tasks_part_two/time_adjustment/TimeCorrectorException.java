package ru.neolab.peyl.test_tasks_part_two.time_adjustment;

/**
 * Class for exception for work with correcting times
 */
public class TimeCorrectorException extends Exception {

    /**
     * Basic constructor for exception
     *
     * @param message - message exception
     */
    public TimeCorrectorException(final String message) {
        super(message);
    }

    /**
     * Constructor for exception with previous exception
     *
     * @param message   - message exception
     * @param exception - previous exception
     */
    public TimeCorrectorException(final String message, final Exception exception) {
        super(message, exception);
    }

}
