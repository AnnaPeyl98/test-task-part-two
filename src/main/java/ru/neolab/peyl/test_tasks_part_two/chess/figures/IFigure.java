package ru.neolab.peyl.test_tasks_part_two.chess.figures;

import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;

/**
 * Interface for figures in chess
 */
public interface IFigure {

    /**
     * Getter for coordinate x
     *
     * @return value coordinate x
     */
    int getX();

    /**
     * Getter for coordinate y
     *
     * @return value coordinate y
     */
    int getY();

    /**
     * Getter for value this figure
     *
     * @return value figure - one of enum Chess
     */
    Chess getFigure();

    /**
     * Method checks if a given figure can check the king
     *
     * @param moveValidator validator for coordinates in algorithms and figures in cell
     * @return true if figure can check the king else false
     * @throws MoveValidatorException if moveValidator is null
     */
    boolean isCheck(MoveValidator moveValidator) throws MoveValidatorException;
}
