package ru.neolab.peyl.test_tasks_part_two.chess;

/**
 * Enum for chess
 */
public enum Chess {
    KING('K', 1),
    QUEEN('Q', 1),
    BISHOP('B', 2),
    KNIGHT('N', 2),
    ROOK('R', 2),
    PAWN('P', 4),
    EMPTY(' ', 16);

    private final char symbolFigure;
    private final int maxCountFigure;
    private static final Chess[] ARRAYS_POSSIBLE_FIGURES = Chess.values();

    /**
     * Constructor for figures
     *
     * @param valueFigure    - symbol figure in string
     * @param maxCountFigure - max count figure on the board
     */
    Chess(final char valueFigure, final int maxCountFigure) {
        this.symbolFigure = valueFigure;
        this.maxCountFigure = maxCountFigure;
    }

    /**
     * getter for symbol figure
     *
     * @return symbol figure
     */
    public char getSymbolFigure() {
        return symbolFigure;
    }

    /**
     * getter for max count figure
     *
     * @return - max count figure
     */
    public int getMaxCountFigure() {
        return maxCountFigure;
    }

    /**
     * method determines if figure is in the enumeration
     *
     * @param symbolFigure - figure from board
     * @return true if figure is else false
     */
    public static boolean containsFigure(final char symbolFigure) {
        for (Chess possibleFigure : ARRAYS_POSSIBLE_FIGURES) {
            if (symbolFigure == possibleFigure.getSymbolFigure()) {
                return true;
            }
        }
        return false;
    }

    /**
     * method returns maximum
     * possible number of figure on the board
     *
     * @param symbolFigure - figure
     * @return maximum possible number of figure on the board
     */
    public static int getCountForFigure(final char symbolFigure) {
        for (Chess possibleFigure : ARRAYS_POSSIBLE_FIGURES) {
            if (symbolFigure == possibleFigure.getSymbolFigure()) {
                return possibleFigure.getMaxCountFigure();
            }
        }
        return 0;
    }
}
