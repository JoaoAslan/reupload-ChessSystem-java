package boardlayer;

public class Piece {

    private Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    public Position getPosition() {
        return position;
    }

    public Board getBoard() {
        return board;
    }
}
