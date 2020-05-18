package ru.neolab.peyl.test_tasks_part_two.chess.figures;

import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;

/**
 * Class implementing the figure knight
 */
public class Knight implements IFigure {
    private int x;
    private int y;
    private Chess figure;
    private static final int MIN_DELTA_FOR_X_AND_Y = -2;
    private static final int MAX_DELTA_FOR_X_AND_Y = 2;

    /**
     * Constructor for figure
     *
     * @param x      - coordinate x
     * @param y      - coordinate y
     * @param figure - value figure from enum Chess
     */
    public Knight(final int x, final int y, final Chess figure) {
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
     * Getter for value knight
     *
     * @return value figure - Chess.KNIGHT
     */
    @Override
    public Chess getFigure() {
        return figure;
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
        for (int i = MIN_DELTA_FOR_X_AND_Y; i <= MAX_DELTA_FOR_X_AND_Y; i++) {
            for (int j = MIN_DELTA_FOR_X_AND_Y; j <= MAX_DELTA_FOR_X_AND_Y; j++) {
                if (moveValidator.isShift(i, j, 2)
                        && moveValidator.isValid(x + i)
                        && moveValidator.isValid(y + j)
                        && moveValidator.isKing(x + i, y + j)) {
                    return true;
                }

            }
        }
        return false;
    }
}