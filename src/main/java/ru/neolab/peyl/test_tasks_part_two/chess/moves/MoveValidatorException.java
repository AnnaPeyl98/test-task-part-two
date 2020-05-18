package ru.neolab.peyl.test_tasks_part_two.chess.moves;

/**
 * Class for exception for work with validation
 */
public class MoveValidatorException extends Exception {

    /**
     * Basic constructor for exception
     *
     * @param message - message exception
     */
    public MoveValidatorException(final String message) {
        super(message);
    }
}
