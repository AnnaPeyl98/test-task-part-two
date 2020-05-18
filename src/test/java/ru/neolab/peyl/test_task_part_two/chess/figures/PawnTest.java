package ru.neolab.peyl.test_task_part_two.chess.figures;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Pawn;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

/**
 * Class testing check only for Pawn
 * (if you add some other figure on the board that can make a check, but the Pawn cannot make a check,
 * then the isCheck method should return false. Testing such cases in the main class CheckerControllerTest.)
 */
public class PawnTest {

    private MoveValidator moveValidator;
    @Test
    public void testGetX() {
        int expectedX = 3;
        int y = 2;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(expectedX, y, figure);

        int actualX = pawn.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void testGetY() {
        int x = 3;
        int expectedY = 2;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, expectedY, figure);

        int actualY = pawn.getY();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void testGetFigure() {
        int x = 3;
        int y = 2;
        Chess expectedFigure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, expectedFigure);

        Chess actualFigure = pawn.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test(expected = MoveValidatorException.class)
    public void testExceptionIsCheck() throws MoveValidatorException {
        moveValidator = null;
        int x = 3;
        int y = 2;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        pawn.isCheck(moveValidator);
    }

    /**
     *      4| | | | |
     *      3|K| | | |
     *      2| |P| | |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromStartCellForPawnInDiagonalLeftUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("    K    P      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = pawn.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| | |K| |
     *      2| |P| | |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckFromStartCellForPawnInDiagonalRightUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("    K    P      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = pawn.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | |K| |
     *      3| |P| | |
     *      2| | | | |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckInDiagonalRightUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("  K  P          ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = pawn.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4|K| | | |
     *      3| |P| | |
     *      2| | | | |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckInDiagonalLeftUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("K    P          ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 1;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        boolean expectedCheck = true;
        boolean actualCheck = pawn.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| | | | |
     *      3| |K| | |
     *      2| |P| | |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckKingInCellForMovePawnOneCellUP() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board("     K   P      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = pawn.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| |K| | |
     *      3| | | | |
     *      2| |P| | |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckKingInCellForMovePawnTwoCellUp() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board(" K       P      ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 2;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = pawn.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }

    /**
     *      4| |P| | |
     *      3| | | | |
     *      2| | | | |
     *      1| |_|_|_|
     *        a b c d
     */

    @Test
    public void testIsCheckMovesGoBeyondBoard() throws MoveValidatorException, CheckerBoardException {
        Board board = new Board(" P              ");
        moveValidator = new MoveValidator(board);
        int x = 1;
        int y = 0;
        Chess figure = Chess.PAWN;
        IFigure pawn = new Pawn(x, y, figure);

        boolean expectedCheck = false;
        boolean actualCheck = pawn.isCheck(moveValidator);

        assertEquals(expectedCheck, actualCheck);
    }
}
