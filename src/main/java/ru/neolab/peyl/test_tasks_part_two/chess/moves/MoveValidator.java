package ru.neolab.peyl.test_tasks_part_two.chess.moves;

import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;

/**
 * Class for validation parameters in the process of determining the possibility of a check
 */
public class MoveValidator {

    private Board board;
    private int sizeBoard;

    /**
     * Constructor for validator
     *
     * @param board - board on which validations will be checked
     * @throws MoveValidatorException if board is null
     */
    public MoveValidator(final Board board) throws MoveValidatorException {
        if (board == null) {
            throw new MoveValidatorException("Passed board in move validator is null");
        }
        this.board = board;
        sizeBoard = board.getSizeBoard();
    }

    /**
     * Method determines the correctness of the coordinate relative to the end of the board
     *
     * @param coordinate - coordinate to be checked
     * @return true if coordinate does not extend beyond the end of board else false
     */
    private boolean coordinateIsLessEndBoard(final int coordinate) {
        return coordinate < sizeBoard;
    }

    /**
     * Method determines the correctness of the coordinate relative to the start of the board
     *
     * @param coordinate - coordinate to be checked
     * @return true if coordinate does not extend beyond the start of board else false
     */
    private boolean coordinateIsMoreStartBoard(final int coordinate) {
        return coordinate >= 0;
    }

    /**
     * Method checks that coordinate is within board
     *
     * @param coordinate - coordinate to be checked
     * @return true coordinate is within board else false
     */
    public boolean isValid(final int coordinate) {
        return coordinateIsLessEndBoard(coordinate) && coordinateIsMoreStartBoard(coordinate);
    }

    /**
     * Method for determining a figure
     *
     * @param x      - coordinate x figure
     * @param y      - coordinate y figure
     * @param figure - type of required figure
     * @return true if finding figure and transmitted figure equals else false
     */
    private boolean isThisFigure(final int x, final int y, final Chess figure) {
        IFigure attackFigure = board.getFigure(x, y);
        return attackFigure.getFigure() == figure;
    }

    /**
     * Method  checks whether the king is on these coordinates
     *
     * @param x - coordinate x figure
     * @param y - coordinate y figure
     * @return true if on this coordinate king elsa false
     */
    public boolean isKing(final int x, final int y) {
        return isThisFigure(x, y, Chess.KING);
    }

    /**
     * Method check is there an obstacle in the form of another piece for the next move
     *
     * @param x - coordinate x figure
     * @param y - coordinate y figure
     * @return true if there is an obstacle else false
     */
    public boolean notOpportunityMove(final int x, final int y) {
        return !isThisFigure(x, y, Chess.EMPTY) && !isKing(x, y);
    }

    /**
     * Method checks whether the given set of coordinates from the cycle is a shift along the board for the next move.
     *
     * @param shiftForX     - shift for coordinate x
     * @param shiftForY     - shift for coordinate y
     * @param countForShift - condition from the loop that must be met for the shift
     * @return true if this set of coordinates is a shift else false
     */
    public boolean isShift(final int shiftForX, final int shiftForY, int countForShift) {
        return Math.abs(shiftForX * shiftForY) == countForShift;
    }

    /**
     * Method checks whether the given set of coordinates from the cycle is a shift along the board for the next move
     * for horizontal or vertical.
     *
     * @param shiftForX - shift for coordinate x
     * @param shiftForY - shift for coordinate y
     * @return true if this set of coordinates is a shift else false
     */
    public boolean isShiftForVerticalAndGorisontal(final int shiftForX, final int shiftForY) {
        return Math.abs(shiftForX + shiftForY) == 1;
    }
}
