package ru.neolab.peyl.test_task_part_two.chess.figures;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Knight;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

/**
 * Class testing check only for Knight
 * (if you add some other figure on the board that can make a check, but the Knight cannot make a check,
 * then the isCheck method should return false. Testing such cases in the main class CheckerControllerTest.)
 */
public class KnightTest {
    private MoveValidator moveValidator;
    @Test
    public void testGetX() {
        int expectedX = 3;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(expectedX, y, figure);

        int actualX = knight.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        int x = 3;
        int expectedY = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, expectedY, figure);

        int actualY = knight.getY();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void testGetFigure() {
        int x = 3;
        int y = 2;
        Chess expectedFigure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, expectedFigure);

        Chess actualFigure = knight.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test(expected = MoveValidatorException.class)
    public void testExceptionIsCheck() throws MoveValidatorException {
        moveValidator = null;
        int x = 3;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        knight.isCheck(moveValidator);

    }

    /**
     *      4| | | | |
     *      3| |N| | |
     *      2| | | | |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellDownAndOneCellLeft() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     N      K   ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |N| | |
     *      2| | | | |
     *      1|_|_|K|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellDownAndOneCellRight() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     N        K ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| |N| | |
     *      2| | | | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellRightAndOneCellUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K N          ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |N| | |
     *      2| | | |K|
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellRightAndOneCellDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     N     K    ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| | | | |
     *      2| | |N| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellUpAndOneCellRight() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K      N     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| |K| | |
     *      3| | | | |
     *      2| | |N| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellUpAndOneCellLeft() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board(" K        N     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3|K| | | |
     *      2| | |N| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellLeftAndOneCellUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("    K     N     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | |N| |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckTwoCellLeftAndOneCellDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("          N K   ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |K| |
     *      2| | |N| |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckKingBeforeKnight() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      K   N     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | |K| |
     *      3| | | | |
     *      2| | |N| |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckKingBeforeKnightThroughOneCell() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("  K       N     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.KNIGHT;
        IFigure knight = new Knight(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = knight.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

}
