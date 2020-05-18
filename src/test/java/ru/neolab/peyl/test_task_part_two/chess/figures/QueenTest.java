package ru.neolab.peyl.test_task_part_two.chess.figures;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Queen;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

/**
 * Class testing check only for Queen
 * (if you add some other figure on the board that can make a check, but the Queen cannot make a check,
 * then the isCheck method should return false. Testing such cases in the main class CheckerControllerTest.)
 */
public class QueenTest {
    private MoveValidator moveValidator;
    @Test
    public void testGetX() {
        int expectedX = 3;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(expectedX, y, figure);

        int actualX = queen.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        int x = 3;
        int expectedY = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, expectedY, figure);

        int actualY = queen.getY();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void testGetFigure() {
        int x = 3;
        int y = 2;
        Chess expectedFigure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, expectedFigure);

        Chess actualFigure = queen.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test(expected = MoveValidatorException.class)
    public void testExceptionIsCheck() throws MoveValidatorException {
        moveValidator = null;
        int x = 3;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        queen.isCheck(moveValidator);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| |Q| | |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("         Q  K   ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| | | | |
     *      2| |Q| | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRightUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K     Q      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | |Q| |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckRightDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("          Q    K");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | |Q| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K         Q     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |K| | |
     *      2| | |Q| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     K    Q     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |Q| |
     *      2| |K| | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeftDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      Q  K      ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 1;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |Q| | |
     *      2| | |K| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRightDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     Q    K     ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |K| |
     *      2| |Q| | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRightUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      K  Q      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |Q|
     *      3| | | | |
     *      2| | | | |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   Q        K   ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|Q| | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("Q              K");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 0;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| | | | |
     *      2| | | | |
     *      1|Q|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K        Q   ");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|Q|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K              Q");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 3;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }


    /**
     *      4| | | |Q|
     *      3| | |N| |
     *      2| | | | |
     *      1|K|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftDownWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   Q  N     K   ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|Q| | | |
     *      3| | | | |
     *      2| | |P| |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightDownWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("Q         P    K");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 0;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |K|
     *      3| | |R| |
     *      2| | | | |
     *      1|Q|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerRightUpWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   K  R     Q   ");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | |N| |
     *      1|_|_|_|B|
     *        a b c d
     */

    @Test
    public void testIsCheckFromCornerLeftUpWithObstacle() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K         N    Q");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 3;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | | | |
     *      1|Q|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromLeftDownCornerToLeftUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K           Q   ");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|Q|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromLeftDownCornerToRightDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("            Q  K");
        moveValidator = new MoveValidator(board);
        int x = 0;
        int y = 3;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | |Q|
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|K|
     *        a b c d
     */

    @Test
    public void testIsCheckFromRightUpCornerToRightDownCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("   Q           K");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | |Q|
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromRightUpCornerToLeftUpCorner() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K  Q            ");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 0;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |K| |
     *      2| | |Q| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      K   Q     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |Q| |
     *      2| | |K| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckDown() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("      Q   K     ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 1;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |K|Q| |
     *      2| | | | |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckLeft() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     KQ         ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        int y = 1;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| |Q|K| |
     *      1|_|_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckRight() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("         QK     ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }


    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|Q|
     *        a b c d
     */

    @Test
    public void testIsCheckOnlyBishopOnBoard() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("               Q");
        moveValidator = new MoveValidator(board);
        int x = 3;
        int y = 3;
        Chess figure = Chess.QUEEN;
        IFigure queen = new Queen(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = queen.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

}
