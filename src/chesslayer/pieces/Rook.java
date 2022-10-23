package chesslayer.pieces;

import boardlayer.Board;
import chesslayer.ChessPiece;
import chesslayer.enums.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    // Basic PossibleMove implementation
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
