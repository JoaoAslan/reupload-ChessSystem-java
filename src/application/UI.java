package application;

import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;
import chesslayer.enums.Color;

import java.util.*;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Reading a String and transform it into a ChessPosition
    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine().toLowerCase();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        }
        catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
        }
    }

    // Printing some extra information (Turn, CurrentPlayer and CHECK) with the Board
    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        printCapturedPieces(captured);
        System.out.print("\nTurn: "+ chessMatch.getTurn());
        if (!chessMatch.getCheckMate()) {
            System.out.print("\nWaiting player: "+ chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.println("\nCHECK!");
            }
        }
        else {
            System.out.println("\nCHEKMATE!");
            System.out.println("Winner: "+ chessMatch.getCurrentPlayer());
        }
    }

    // PrintBoard without background
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i=0; i<pieces.length; i++) {
            System.out.printf("%d ", 8 - i);
            for (int j=0; j<pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    // PrintBoard with background
    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i=0; i<pieces.length; i++) {
            System.out.printf("%d ", 8 - i);
            for (int j=0; j<pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    private static void printCapturedPieces(List<ChessPiece> captured) {
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).toList();
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).toList();

        System.out.println("\nCaptured pieces:");
        System.out.print("White: " + ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()) + ANSI_RESET);
        System.out.print("Black: " + ANSI_YELLOW);
        System.out.println(Arrays.toString(black.toArray()) + ANSI_RESET);
    }

    // Special Move: PROMOTION (Delegation method)
    public static String printPromotion(Scanner sc) {
        System.out.print("Enter piece for promotion (B/N/R/Q): ");
        String type = sc.nextLine().toUpperCase();
        while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
            System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
            type = sc.nextLine().toUpperCase();
        }
        return type;
    }
}
