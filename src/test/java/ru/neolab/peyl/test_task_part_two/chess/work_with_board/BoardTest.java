package ru.neolab.peyl.test_task_part_two.chess.work_with_board;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board board;

    /**
     *      4|Q| | |R|
     *      3|P| | | |
     *      2| |B| | |
     *      1|N|_|K|_|
     *        a b c d
     */
    @Test
    public void testGetFigure() throws CheckerBoardException {
        board = new Board("Q  RP    B  N K ");
        int x = 1;
        int y = 2;
        Chess expectedFigure = Chess.BISHOP;
        Chess actualFigure = board.getFigure(x, y).getFigure();
        assertEquals(expectedFigure, actualFigure);

    }

    @Test(expected = CheckerBoardException.class)
    public void testCreateBoardWithExcessSymbols() throws CheckerBoardException {
        board = new Board("Q  RP   LB  N K ");
    }

    @Test
    public void testGetSizeBoard() throws CheckerBoardException {
        board = new Board("Q  RP    B  N K ");
        int expectedSize = 4;
        int actualSize = board.getSizeBoard();
        assertEquals(expectedSize, actualSize);
    }
}
