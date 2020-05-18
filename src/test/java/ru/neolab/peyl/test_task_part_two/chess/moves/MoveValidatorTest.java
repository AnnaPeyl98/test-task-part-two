package ru.neolab.peyl.test_task_part_two.chess.moves;

import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

import static org.junit.Assert.assertEquals;

public class MoveValidatorTest {
    private MoveValidator moveValidator;
    private Board board;

    /**
     *      4| |K| |P|
     *      3| |Q| |B|
     *      2| |N| |R|
     *      1|_|_|_|_|
     *        a b c d
     */
    @Test
    public void testIsKing() throws CheckerBoardException, MoveValidatorException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);

        int x = 1;
        int y = 0;
        boolean expectedAnswer = true;
        boolean actualAnswer = moveValidator.isKing(x, y);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test
    public void testIsNotKing() throws CheckerBoardException, MoveValidatorException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);

        int x = 4;
        int y = 0;
        boolean expectedAnswer = false;
        boolean actualAnswer = moveValidator.isKing(x, y);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test
    public void testIsValid() throws MoveValidatorException, CheckerBoardException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);
        int x = 2;
        boolean expectedAnswer = true;
        boolean actualAnswer = moveValidator.isValid(x);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test
    public void testIsNotValidMoreThatThree() throws CheckerBoardException, MoveValidatorException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);
        int x = 4;
        boolean expectedAnswer = false;
        boolean actualAnswer = moveValidator.isValid(x);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test
    public void testIsNotValidLessThatZero() throws MoveValidatorException, CheckerBoardException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);
        int x = -1;
        boolean expectedAnswer = false;
        boolean actualAnswer = moveValidator.isValid(x);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test
    public void testIsOpportunityMoveNextKing() throws MoveValidatorException, CheckerBoardException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);
        int nextX = 1;
        int nextY = 0;
        boolean expectedAnswer = false;
        boolean actualAnswer = moveValidator.notOpportunityMove(nextX,nextY);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test
    public void testIsOpportunityMoveNextEmptyCell() throws MoveValidatorException, CheckerBoardException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);
        int nextX = 0;
        int nextY = 0;
        boolean expectedAnswer = false;
        boolean actualAnswer = moveValidator.notOpportunityMove(nextX,nextY);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test
    public void testIsNotOpportunityMove() throws MoveValidatorException, CheckerBoardException {
        board = new Board(" K P Q B N R    ");
        moveValidator = new MoveValidator(board);
        int nextX = 3;
        int nextY = 0;
        boolean expectedAnswer = true;
        boolean actualAnswer = moveValidator.notOpportunityMove(nextX,nextY);
        assertEquals(expectedAnswer,actualAnswer);
    }

    @Test(expected = MoveValidatorException.class)
    public void testNullBoard() throws MoveValidatorException {
        Board board = null;
        moveValidator = new MoveValidator(board);
    }
}
