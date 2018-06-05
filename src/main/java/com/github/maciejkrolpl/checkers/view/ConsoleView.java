package com.github.maciejkrolpl.checkers.view;

import com.github.maciejkrolpl.checkers.controller.GameController;
import com.github.maciejkrolpl.checkers.model.Direction;
import com.github.maciejkrolpl.checkers.model.Piece;

import java.util.Scanner;

import static com.github.maciejkrolpl.checkers.model.Direction.*;

public class ConsoleView {


    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private GameController gameController;

    public ConsoleView(GameController gameController) {
        this.gameController = gameController;
    }


    private void printBoard() {

        System.out.print("  ");
        for (int i = 0; i < 8; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                switch (gameController.getGameboard()[i][j]) {
                    case RED:
                        System.out.print(ANSI_RED);
                        System.out.print("▒ ");
                        System.out.print(ANSI_RESET);
                        break;
                    case RED_KING:
                        System.out.print(ANSI_RED);
                        System.out.print("█ ");
                        System.out.print(ANSI_RESET);
                        break;
                    case BLACK:
                        System.out.print(ANSI_BLACK);
                        System.out.print("▒ ");
                        System.out.print(ANSI_RESET);
                        break;
                    case BLACK_KING:
                        System.out.print(ANSI_BLACK);
                        System.out.print("█ ");
                        System.out.print(ANSI_RESET);
                        break;
                    case NONE:
                        System.out.print("□ ");
                        break;
                }
            }
            if (i == 7) {
                System.out.print(ANSI_RED);
                System.out.print("        Czerwonych pionków: " + gameController.getRedPiecesCount());
                System.out.print(ANSI_RESET);
            } else if (i == 0) {
                System.out.print(ANSI_BLACK);
                System.out.print("        Czarnych pionków:   " + gameController.getBlackPiecesCount());
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println();


    }


    private void getMove(Piece piece) {
        Scanner sc = new Scanner(System.in);
        boolean isPieceToMoveCorrect = false;
        boolean isDirectionSignCorrect = false;
        boolean isMoveCorrect = false;

        String directionToMove;
        Direction direction = null;

        int pieceToMove;
        String s;

        if (piece == Piece.RED) {
            System.out.print(ANSI_RED);
        } else {
            System.out.print(ANSI_BLACK);
        }

        do {


            boolean isNumberCorrect = false;
            do {
                System.out.print("Wybierz pionek którym chcesz ruszyć: ");
                s = sc.nextLine();
                isNumberCorrect = s.matches("\\d+");
                if (!isNumberCorrect) {
                    System.out.println("To nie jest liczba!");
                }
            } while (!isNumberCorrect);
            pieceToMove = Integer.parseInt(s)-11;
            isPieceToMoveCorrect = gameController.verifyPieceToMove(pieceToMove, piece);
        } while (!isPieceToMoveCorrect);

        do {
            do {
                System.out.print("Wybierz ruch (QEZC): ");
                directionToMove = sc.nextLine();
                directionToMove = directionToMove.toLowerCase();
                isDirectionSignCorrect = (directionToMove.equals("q") || directionToMove.equals("e")
                        || directionToMove.equals("z") || directionToMove.equals("c"));
            } while (!isDirectionSignCorrect);

            switch (directionToMove) {
                case "q":
                    direction = UP_LEFT;
                    break;
                case "e":
                    direction = UP_RIGHT;
                    break;
                case "z":
                    direction = DOWN_LEFT;
                    break;
                case "c":
                    direction = DOWN_RIGHT;
                    break;
            }
            isMoveCorrect = gameController.verifyMove(pieceToMove, direction, piece, true);
            System.out.println(ANSI_RESET);
        } while (!isMoveCorrect);

    }

    public void run() {

        while (true) {
            printBoard();
            getMove(Piece.RED);
            printBoard();
            getMove(Piece.BLACK);
        }

    }
}
