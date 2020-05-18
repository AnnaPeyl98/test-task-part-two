package ru.neolab.peyl.test_task_part_two.chess.figures;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Bishop;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

/**
 * Class testing check only for Bishop
 * (If you add some other figure on the board that can make a check, but the Bishop cannot make a check,
 * then the isCheck method should return false. Testing such cases in the main class CheckerControllerTest.)
 */
public class BishopTest {
    private MoveValidator moveValidator;
    @Test
    public void testGetX() {
        int expectedX = 3;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(expectedX, y, figure);

        int actualX = bishop.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        int x = 3;
        int expectedY = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, expectedY, figure);

        int actualY = bishop.getY();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void testGetFigure() {
        int x = 3;
        int y = 2;
        Chess expectedFigure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, expectedFigure);

        Chess actualFigure = bishop.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test(expected = MoveValidatorException.class)
    public void testExceptionIsCheck() throws MoveValidatorException {
        moveValidator = null;
        int x = 3;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        bishop.isCheck(moveValidator);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| |B| | |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("         B  K   ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| | | | |
     *      2| |B| | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRightUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K     B      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | |B| |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckRightDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("          B    K");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | |B| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K         B     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |K| | |
     *      2| | |B| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     K    B     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |B| |
     *      2| |K| | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      B  K      ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 1;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |B| | |
     *      2| | |K| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRightDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     B    K     ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |K| |
     *      2| |B| | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRightUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      K  B      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |B|
     *      3| | | | |
     *      2| | | | |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   B        K   ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|B| | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("B              K");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 0;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| | | | |
     *      2| | | | |
     *      1|B|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K        B   ");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|B|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K              B");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 3;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }


    /**
     *      4| | | |B|
     *      3| | |N| |
     *      2| | | | |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftDownWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   B  N     K   ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|B| | | |
     *      3| | | | |
     *      2| | |P| |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightDownWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("B         P    K");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 0;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| | |R| |
     *      2| | | | |
     *      1|B|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightUpWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K  R     B   ");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | |P| |
     *      1|_|_|_|B|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftUpWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K         P    B");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 3;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|B|
     *        a b c d
     */

    @Test
    public void testIsCheckOnlyBishopOnBoard() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("               B");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 3;
        Chess figure = Chess.BISHOP;
        IFigure bishop = new Bishop(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = bishop.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }
}
