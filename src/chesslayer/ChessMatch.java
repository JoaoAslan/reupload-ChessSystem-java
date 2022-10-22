package chesslayer;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.enums.Color;
import chesslayer.pieces.King;
import chesslayer.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();
    }

    // Creating a ChessPiece list from the Piece list in Board class
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.getPiece(i, j);
            }
        }
        return mat;
    }

    // Starting the game by placing the Pieces in each Position
    public void initialSetup() {
        board.placePiece(new King(board, Color.WHITE), new Position(0, 4));
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,7));
        board.placePiece(new King(board, Color.BLACK), new Position(7, 4));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7,0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7,7));
    }


}
