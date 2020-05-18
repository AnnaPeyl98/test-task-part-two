package ru.neolab.peyl.test_task_part_two.chess.figures;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Rook;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

/**
 * Class testing check only for Rook
 * (if you add some other figure on the board that can make a check, but the Rook cannot make a check,
 * then the isCheck method should return false. Testing such cases in the main class CheckerControllerTest.)
 */
public class RookTest {
    private MoveValidator moveValidator;
    @Test
    public void testGetX() {
        int expectedX = 3;
        int y = 2;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(expectedX, y, figure);

        int actualX = rook.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        int x = 3;
        int expectedY = 2;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, expectedY, figure);

        int actualY = rook.getY();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void testGetFigure() {
        int x = 3;
        int y = 2;
        Chess expectedFigure = Chess.ROOK;
        IFigure rook = new Rook(x, y, expectedFigure);

        Chess actualFigure = rook.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test(expected = MoveValidatorException.class)
    public void testExceptionIsCheck() throws MoveValidatorException {
        moveValidator = null;
        int x = 3;
        int y = 2;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        rook.isCheck(moveValidator);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | | | |
     *      1|R|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromLeftDownCornerToLeftUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K           R   ");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|R|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromLeftDownCornerToRightDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("            R  K");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |R|
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromRightUpCornerToRightDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   R           K");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | |R|
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromRightUpCornerToLeftUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K  R            ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |K| |
     *      2| | |R| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      K   R     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |R| |
     *      2| | |K| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      R   K     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 1;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |K|R| |
     *      2| | | | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeft() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     KR         ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 1;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| |R|K| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRight() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("         RK     ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }


    /**
     *      4| | |K| |
     *      3| | | | |
     *      2| | |B| |
     *      1|_|_|R|_|
     *        a b c d
     */

    @Test
    public void testIsCheckUpWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("  K       B   R ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 3;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|R|
     *        a b c d
     */

    @Test
    public void testIsCheckOnlyBishopOnBoard() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("               R");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 3;
        Chess figure = Chess.ROOK;
        IFigure rook = new Rook(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = rook.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }
}
