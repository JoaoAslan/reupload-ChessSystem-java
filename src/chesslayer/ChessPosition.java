package chesslayer;

import boardlayer.Position;
import chesslayer.exceptions.ChessException;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' && column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Balid values are form a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    // Transforms a ChessPosition into Position
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    // Transforms a Position into a new ChessPosition
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(column);
        sb.append(row);
        return sb.toString();
    }
}
