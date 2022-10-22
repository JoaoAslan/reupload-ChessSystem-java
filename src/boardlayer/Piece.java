package boardlayer;

public class Piece {

    private Position position;
    private Board board;

    public Piece(Position position, Board board) {
        this.position = position;
        this.board = board;
    }

    public Position getPosition() {
        return position;
    }

    public Board getBoard() {
        return board;
    }
}
