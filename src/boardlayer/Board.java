package boardlayer;

import boardlayer.exceptions.BoardException;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece getPiece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece getPiece(Position position) {
        return getPiece(position.getRow(), position.getColumn());
    }

    // Placing Piece based on Position in the Pieces matrix
    public void placePiece(Piece piece, Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position "+ position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean positionExists(int row, int column) {
        // rows = 8 and column = 8 and positionExists(8,8) = False
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return getPiece(position) != null;
    }
}
