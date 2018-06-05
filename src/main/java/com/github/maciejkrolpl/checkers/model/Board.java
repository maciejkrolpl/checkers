package com.github.maciejkrolpl.checkers.model;


import java.util.Arrays;

import static com.github.maciejkrolpl.checkers.model.Piece.*;

public class Board {

    private final int SIZE = 10;

    public int getSIZE() {
        return SIZE;
    }

    private final int ROWS = 4;

    private Piece[][] gameboard = new Piece[SIZE][SIZE];
    private  int blackPiecesCount = 0;
    private  int redPiecesCount = 0;

    public  int getRedPiecesCount() {
        return redPiecesCount;
    }

    public  int getBlackPiecesCount() {
        return blackPiecesCount;
    }

    public void decrementBlackPiecesCount() {
        this.blackPiecesCount--;
    }

    public void decrementRedPiecesCount() {
        this.redPiecesCount--;
    }

    public Board() {

        for (int i = 0; i <= SIZE-1; i++) {
            Arrays.fill(gameboard[i], NONE);

        }

        for (int i = 1; i < SIZE; i+=2) {
            for (int j = 0; j < ROWS ; j++) {
                if (j%2==0) {
                    gameboard[j][i] = BLACK;

                } else {
                    gameboard[j][i-1] = BLACK;
                }
            blackPiecesCount++;
            }

        }

        for (int i = 1; i < SIZE; i+=2) {
            for (int j = SIZE-1; j > SIZE-1-ROWS ; j--) {
                if (j%2==0) {
                    gameboard[j][i] = RED;

                } else {
                    gameboard[j][i-1] = RED;
                }
                redPiecesCount++;
            }

        }

//        for (int i = 1; i <= 7; i+=2) {
//            gameboard[0][i] = BLACK;
//            gameboard[1][i-1] = BLACK;
//            gameboard[2][i] = BLACK;
//
//            gameboard[5][i-1] = RED;
//            gameboard[6][i] = RED;
//            gameboard[7][i-1] = RED;
//        }
    }

    public Piece[][] getGameboard() {
        return gameboard;
    }

    public void clearCell(int i, int j) {
        gameboard[i][j] = NONE;
    }

    public void putPiece(int i, int j, Piece piece) {
        gameboard[i][j] = piece;
    }

    public Piece[][] getBoardCopy() {
        Piece[][] boardCopy = new Piece[SIZE][SIZE];
        for (int i = 0; i < boardCopy.length; i++) {
            boardCopy[i] = gameboard[i].clone();
        }
        return boardCopy;
    }
}
