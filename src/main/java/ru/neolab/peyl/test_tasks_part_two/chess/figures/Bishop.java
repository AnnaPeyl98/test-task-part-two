package ru.neolab.peyl.test_tasks_part_two.chess.figures;

import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;

/**
 * Class implementing the figure bishop
 */
public class Bishop implements IFigure {
    private int x;
    private int y;
    private Chess figure;
    private static final int DIAGONAL_SHIFT_MIN_DELTA = -1;
    private static final int DIAGONAL_SHIFT_MAX_DELTA = 1;


    /**
     * Constructor for figure
     *
     * @param x      - coordinate x
     * @param y      - coordinate y
     * @param figure - value figure from enum Chess
     */
    public Bishop(final int x, final int y, final Chess figure) {
        this.x = x;
        this.y = y;
        this.figure = figure;
    }

    /**
     * Getter for coordinate x
     *
     * @return value coordinate x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Getter for coordinate y
     *
     * @return value coordinate y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Getter for value Bishop
     *
     * @return value figure - Chess.BISHOP
     */
    @Override
    public Chess getFigure() {
        return figure;
    }

    /**
     * Loop for diagonals bypass
     *
     * @param diagonalShiftDeltaX - x axis shift
     * @param diagonalShiftDeltaY - y axis shift
     * @param moveValidator       - validator for board
     * @return true - if on this way figure can make check else false
     */
    private boolean isKingInCellForBishop(final int diagonalShiftDeltaX,
                                          final int diagonalShiftDeltaY,
                                          final MoveValidator moveValidator) {
        int newY = y + diagonalShiftDeltaY;
        for (int newX = x + diagonalShiftDeltaX;
             moveValidator.isValid(newX) && moveValidator.isValid(newY);
             newX += diagonalShiftDeltaX) {
            if (moveValidator.notOpportunityMove(newX, newY)) {
                break;
            }
            if (moveValidator.isKing(newX, newY)) {
                return true;
            }
            newY += diagonalShiftDeltaY;
        }
        return false;
    }

    /**
     * Method checks if a given figure can check the king
     *
     * @param moveValidator validator for coordinates in algorithms and figures in cell
     * @return true if figure can check the king else false
     * @throws MoveValidatorException if moveValidator is null
     */
    @Override
    public boolean isCheck(final MoveValidator moveValidator) throws MoveValidatorException {
        if (moveValidator == null) {
            throw new MoveValidatorException("Passed validator is null");
        }
        for (int i = DIAGONAL_SHIFT_MIN_DELTA; i <= DIAGONAL_SHIFT_MAX_DELTA; i++) {
            for (int j = DIAGONAL_SHIFT_MIN_DELTA; j <= DIAGONAL_SHIFT_MAX_DELTA; j++) {
                if (moveValidator.isShift(i, j, 1) && isKingInCellForBishop(i, j, moveValidator)) {
                    return true;
                }
            }
        }
        return false;
    }
}
