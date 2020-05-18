package ru.neolab.peyl.test_task_part_two.chess.figures;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.King;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

public class KingTest {
    private MoveValidator moveValidator;


    @Test
    public void testGetX() {
        int expectedX = 3;
        int y = 2;
        Chess figure = Chess.KING;
        IFigure king = new King(expectedX, y, figure);

        int actualX = king.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        int x = 3;
        int expectedY = 2;
        Chess figure = Chess.KING;
        IFigure king = new King(x, expectedY, figure);

        int actualY = king.getY();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void testGetFigure() {
        int x = 3;
        int y = 2;
        Chess expectedFigure = Chess.KING;
        IFigure king = new King(x, y, expectedFigure);

        Chess actualFigure = king.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testIsCheck() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("       K        ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 2;
        Chess figure = Chess.KING;
        IFigure king = new King(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = king.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    @Test(expected = MoveValidatorException.class)
    public void testExceptionIsCheck() throws MoveValidatorException {
        moveValidator = null;
        int x = 3;
        int y = 2;
        Chess figure = Chess.KING;
        IFigure king = new King(x, y, figure);

        king.isCheck(moveValidator);

    }
}
