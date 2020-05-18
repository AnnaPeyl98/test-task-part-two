package ru.neolab.peyl.test_tasks_part_two.chess.work_with_board;

import ru.neolab.peyl.test_tasks_part_two.chess.Chess;

/**
 * Class for checking incoming board
 */
public class CheckerBoard {

    private static final int POSSIBLE_COUNT_CELL = 16;

    /**
     * Method for check count figure on board
     *
     * @param figure      - figure
     * @param stringBoard - board in string
     * @return true if count figures on board match rules else false
     */
    private boolean isRightCountFigureOnBoard(final char figure, final String stringBoard) {
        long countFigureInBoard = stringBoard.chars().filter(figureOnBoard -> figureOnBoard == figure).count();

        return countFigureInBoard <= Chess.getCountForFigure(figure);

    }

    /**
     * Method check:
     * 1.String should be not null and not empty;
     * 2.Count figures on board strictly 16 (length string = 16);
     * 3.In string only figures from enum Chess;
     * 4.Count possible figure match rules.
     *
     * @param stringBoard - board
     * @return - true if board match this rules
     * @throws CheckerBoardException if one of this rules not performed
     */
    public boolean isRightBoard(final String stringBoard) throws CheckerBoardException {

        if (stringBoard == null || stringBoard.length() == 0) {
            throw new CheckerBoardException("String for board null or empty");
        }

        int countCell = stringBoard.length();
        if (countCell != POSSIBLE_COUNT_CELL) {
            throw new CheckerBoardException("Cells in board more or less that 16");
        }

        char figure;
        for (int i = 0; i < POSSIBLE_COUNT_CELL; i++) {
            figure = stringBoard.charAt(i);
            if (!Chess.containsFigure(figure)) {
                throw new CheckerBoardException("Invalid figure on the board");
            }

            if (!isRightCountFigureOnBoard(figure, stringBoard)) {
                throw new CheckerBoardException("The number of pieces on the board exceeds the maximum number");
            }
        }

        return true;
    }


}
