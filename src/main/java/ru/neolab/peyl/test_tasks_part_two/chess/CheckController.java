package ru.neolab.peyl.test_tasks_part_two.chess;

import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidator;
import ru.neolab.peyl.test_tasks_part_two.chess.moves.MoveValidatorException;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.Board;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoard;
import ru.neolab.peyl.test_tasks_part_two.chess.work_with_board.CheckerBoardException;

/**
 * Class for determining the check on the board
 */
public class CheckController {

    private CheckerBoard checkerBoard;


    /**
     * Constructor
     *
     * @param checkerBoard - for checking board on match rules
     */
    public CheckController(final CheckerBoard checkerBoard) {
        this.checkerBoard = checkerBoard;
    }

    /**
     * Method determines whether any piece can checkmate the king on this board
     *
     * @param stringBoard - board
     * @return - true if a check is possible for king else false
     * @throws CheckerBoardException  - if board not match for rules
     * @throws MoveValidatorException - if move validator will be null
     */
    public boolean isCheck(final String stringBoard) throws CheckerBoardException, MoveValidatorException {
        if (checkerBoard.isRightBoard(stringBoard)) {

            Board board = new Board(stringBoard);
            MoveValidator moveValidator = new MoveValidator(board);

            for (int x = 0; x < board.getSizeBoard(); x++) {
                for (int y = 0; y < board.getSizeBoard(); y++) {
                    IFigure figure = board.getFigure(x, y);
                    if (figure.isCheck(moveValidator)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
