package ru.neolab.peyl.test_tasks_part_two.chess.work_with_board;

/**
 * Class for exception for work with checking board on rules
 */
public class CheckerBoardException extends Exception {

    /**
     * Basic constructor for exception
     *
     * @param message - message exception
     */
    public CheckerBoardException(final String message) {
        super(message);
    }
}
