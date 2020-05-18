package ru.neolab.peyl.test_task_part_two.chess.work_with_board;

import org.junit.Before;
import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoard;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

public class CheckerBoardTest {
    private CheckerBoard checkerBoard;

    @Before
    public void init() {
        checkerBoard = new CheckerBoard();
    }

    @Test
    public void testGoodBoard() throws CheckerBoardException {
        String board = "Q  RP    B  N K ";
        boolean expectedStatusBoard = true;
        boolean actualStatusBoard = checkerBoard.isRightBoard(board);
        assertEquals(expectedStatusBoard, actualStatusBoard);
    }

    @Test(expected = CheckerBoardException.class)
    public void testNullBoard() throws CheckerBoardException {
        String board = null;
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testEmptyStringBoard() throws CheckerBoardException {
        String board = "";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testLengthBoardLessSixteen() throws CheckerBoardException {
        String board = "    ";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testLengthBoardMoreSixteen() throws CheckerBoardException {
        String board = "    Q R     P K     N   P  ";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testBoardContainsOtherSymbols() throws CheckerBoardException {
        String board = "  H  P  8  E    ";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testCountBishopMoreThatTwo() throws CheckerBoardException {
        String board = "             BBB";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testCountKingMoreThatOne() throws CheckerBoardException {
        String board = "              KK";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testCountQueenMoreThatOne() throws CheckerBoardException {
        String board = "              QQ";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testCountPawnMoreThatFour() throws CheckerBoardException {
        String board = "           PPPPP";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testCountKnightMoreThatTwo() throws CheckerBoardException {
        String board = "             NNN";
        checkerBoard.isRightBoard(board);
    }

    @Test(expected = CheckerBoardException.class)
    public void testCountRookMoreThatTwo() throws CheckerBoardException {
        String board = "             RRR";
        checkerBoard.isRightBoard(board);
    }
}
