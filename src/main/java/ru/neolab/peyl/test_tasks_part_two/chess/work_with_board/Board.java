package ru.neolab.peyl.test_tasks_part_two.chess.work_with_board;


import ru.neolab.peyl.test_tasks_part_two.chess.Chess;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Bishop;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.EmptyCell;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.IFigure;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.King;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Knight;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Pawn;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Queen;
import ru.neolab.peyl.test_tasks_part_two.chess.figures.Rook;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating and saving figures on board
 */
public class Board {

    private List<IFigure> boardInArray;
    private static final int SIZE_BOARD = 4;

    /**
     * Constructor creating board by dint of enum Chess
     *
     * @param stringBoard - board in string
     * @throws CheckerBoardException if in board unexpected figures
     */
    public Board(final String stringBoard) throws CheckerBoardException {
        boardInArray = new ArrayList<>();
        char figure;
        int x;
        int y;

        for (int i = 0; i < stringBoard.length(); i++) {
            figure = stringBoard.charAt(i);
            x = i % SIZE_BOARD;
            y = i / SIZE_BOARD;
            switch (figure) {
                case 'K':
                    boardInArray.add(new King(x, y, Chess.KING));
                    break;
                case 'N':
                    boardInArray.add(new Knight(x, y, Chess.KNIGHT));
                    break;
                case 'B':
                    boardInArray.add(new Bishop(x, y, Chess.BISHOP));
                    break;
                case 'Q':
                    boardInArray.add(new Queen(x, y, Chess.QUEEN));
                    break;
                case 'P':
                    boardInArray.add(new Pawn(x, y, Chess.PAWN));
                    break;
                case 'R':
                    boardInArray.add(new Rook(x, y, Chess.ROOK));
                    break;
                case ' ':
                    boardInArray.add(new EmptyCell(x, y, Chess.EMPTY));
                    break;
                default:
                    throw new CheckerBoardException("Unexpected figure: " + figure);

            }
        }
    }

    /**
     * Method return figures for this coordinate
     *
     * @param x - coordinate x
     * @param y - coordinate y
     * @return figures from board
     */
    public IFigure getFigure(final int x, final int y) {
        int indexFigureInList = y * SIZE_BOARD + x;
        return boardInArray.get(indexFigureInList);
    }

    /**
     * Method return size board
     *
     * @return size board
     */
    public int getSizeBoard() {
        return SIZE_BOARD;
    }
}
