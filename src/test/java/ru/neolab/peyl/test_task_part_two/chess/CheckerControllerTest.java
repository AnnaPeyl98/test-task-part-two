package ru.neolab.peyl.test_task_part_two.chess;

import org.junit.Before;
import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.CheckController;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoard;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

public class CheckerControllerTest {
    private CheckController checkController;

    @Before
    public void init() {
        CheckerBoard checkerBoard = new CheckerBoard();
        checkController = new CheckController(checkerBoard);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testEmptyBoard() throws MoveValidatorException, CheckerBoardException {
        String board = "                ";
        boolean expectedStatusCheck = false;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| | |K| |
     *      3| | |P| |
     *      2| | |R| |
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testNotCheckRookBecausePawn() throws MoveValidatorException, CheckerBoardException {
        String board = "  K   P   R     ";
        boolean expectedStatusCheck = false;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| |K| | |
     *      3| | |N| |
     *      2| |P| |B|
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testNotCheckBishopBecauseKnight() throws MoveValidatorException, CheckerBoardException {
        String board = " K    N  P B    ";
        boolean expectedStatusCheck = false;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| |K| | |
     *      3| | | | |
     *      2| |P| | |
     *      1|_|Q|_|_|
     *        a b c d
     */
    @Test
    public void testNotCheckQueenBecausePawn() throws MoveValidatorException, CheckerBoardException {
        String board = " K       P   Q  ";
        boolean expectedStatusCheck = false;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| |K| | |
     *      3| | |R| |
     *      2| | |N| |
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testCheckKnightWithBarrier() throws MoveValidatorException, CheckerBoardException {
        String board = " K    R   N     ";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| |K| | |
     *      3| | |P| |
     *      2| |N| | |
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testCheckPawn() throws MoveValidatorException, CheckerBoardException {
        String board = " K    P  N      ";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| | | |K|
     *      3| | | | |
     *      2| |Q| | |
     *      1|B|_|_|_|
     *        a b c d
     */
    @Test
    public void testCheckBarrierAndCheckQueen() throws MoveValidatorException, CheckerBoardException {
        String board = "   K     Q  B   ";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| | |R|K|
     *      3| | | | |
     *      2| |N| | |
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testCheckRook() throws MoveValidatorException, CheckerBoardException {
        String board = "  RK     N      ";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4|K| | | |
     *      3| | | | |
     *      2| | |B| |
     *      1|_|_|_|Q|
     *        a b c d
     */
    @Test
    public void testCheckBarrierAndCheckBishop() throws MoveValidatorException, CheckerBoardException {
        String board = "K         B    Q";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| | |K| |
     *      3| | | | |
     *      2| | |R| |
     *      1|_|_|Q|_|
     *        a b c d
     */
    @Test
    public void testCheckBarrierAndCheckRook() throws MoveValidatorException, CheckerBoardException {
        String board = "  K       R   Q ";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|Q|R|K|
     *        a b c d
     */
    @Test
    public void testCheckBarrierAndCheckRookHorizontal() throws MoveValidatorException, CheckerBoardException {
        String board = "             QRK";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| | | | |
     *      3| | | | |
     *      2| | | | |
     *      1|_|R|Q|K|
     *        a b c d
     */
    @Test
    public void testCheckBarrierAndCheckQueenHorizontal() throws MoveValidatorException, CheckerBoardException {
        String board = "             RQK";
        boolean expectedStatusCheck = true;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    /**
     *      4| | |K| |
     *      3| | | | |
     *      2| | | | |
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testCheckOnlyKing() throws MoveValidatorException, CheckerBoardException {
        String board = "  K             ";
        boolean expectedStatusCheck = false;
        boolean actualStatusCheck = checkController.isCheck(board);
        assertEquals(expectedStatusCheck, actualStatusCheck);
    }

    @Test(expected = CheckerBoardException.class)
    public void testOtherSymbolsInBoard() throws MoveValidatorException, CheckerBoardException {
        String board = "  L 8           ";
        checkController.isCheck(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testLessBoardThatNeed() throws MoveValidatorException, CheckerBoardException {
        String board = "   K";
        checkController.isCheck(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testMoreBoardThatNeed() throws MoveValidatorException, CheckerBoardException {
        String board = "   K   R      P      ";
        checkController.isCheck(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testNullBoard() throws MoveValidatorException, CheckerBoardException {
        String board = null;
        checkController.isCheck(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testEmptyString() throws MoveValidatorException, CheckerBoardException {
        String board = "";
        checkController.isCheck(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testMorePawnThatNeed() throws MoveValidatorException, CheckerBoardException {
        String board = "   P    P  P P P";
        checkController.isCheck(board);
    }
}
