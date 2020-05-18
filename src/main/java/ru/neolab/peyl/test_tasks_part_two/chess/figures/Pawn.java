package ru.neolab.peyl.test_tasks_part_two.chess.figures;

import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;

/**
 * Class implementing the figure pawn
 */
public class Pawn implements IFigure {
    private int x;
    private int y;
    private Chess figure;

    /**
     * Constructor for figure
     *
     * @param x      - coordinate x
     * @param y      - coordinate y
     * @param figure - value figure from enum Chess
     */
    public Pawn(final int x, final int y, final Chess figure) {
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
     * Getter for value pawn
     *
     * @return value figure - Chess.PAWN
     */
    public Chess getFigure() {
        return figure;
    }

    /**
     * Method for move pawn
     *
     * @param x             - coordinate x
     * @param y             - coordinate y
     * @param moveValidator - validator for board
     * @return true if pawn can make check for this cell else false
     */
    private boolean isKingInCellForPawn(final int x, final int y, final MoveValidator moveValidator) {
        return moveValidator.isValid(x)
                && moveValidator.isValid(y)
                && moveValidator.isKing(x, y);
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
        return isKingInCellForPawn(x + 1, y - 1, moveValidator)
                || isKingInCellForPawn(x - 1, y - 1, moveValidator);
    }
}
