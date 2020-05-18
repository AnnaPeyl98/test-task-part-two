package ru.neolab.peyl.test_task_part_two.chess.figures;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.EmptyCell;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

public class EmptyCellTest {
    private MoveValidator moveValidator;


    @Test
    public void testGetX() {
        int expectedX = 3;
        int y = 2;
        Chess figure = Chess.EMPTY;
        IFigure emptyCell = new EmptyCell(expectedX, y, figure);

        int actualX = emptyCell.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        int x = 3;
        int expectedY = 2;
        Chess figure = Chess.EMPTY;
        IFigure emptyCell = new EmptyCell(x, expectedY, figure);

        int actualY = emptyCell.getY();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void testGetFigure() {
        int x = 3;
        int y = 2;
        Chess expectedFigure = Chess.EMPTY;
        IFigure emptyCell = new EmptyCell(x, y, expectedFigure);

        Chess actualFigure = emptyCell.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testIsCheck() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("                ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 2;
        Chess figure = Chess.EMPTY;
        IFigure emptyCell = new EmptyCell(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = emptyCell.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    @Test(expected = MoveValidatorException.class)
    public void testExceptionIsCheck() throws MoveValidatorException {
        moveValidator = null;
        int x = 3;
        int y = 2;
        Chess figure = Chess.EMPTY;
        IFigure emptyCell = new EmptyCell(x, y, figure);

        emptyCell.isCheck(moveValidator);

    }
}
