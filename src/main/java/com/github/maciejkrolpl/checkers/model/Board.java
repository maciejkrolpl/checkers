package com.github.maciejkrolpl.checkers.model;


import java.util.Arrays;

import static com.github.maciejkrolpl.checkers.model.Piece.*;

/**
 * Klasa będzie przechowywać stan planszy
 */
public class Board {

    private Piece[][] gameboard = new Piece[8][8];
    private  int blackPiecesCount = 12;
    private  int redPiecesCount = 12;

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

        for (int i = 0; i <= 7; i++) {
            Arrays.fill(gameboard[i], NONE);

        }

        for (int i = 1; i <= 7; i+=2) {
            gameboard[0][i] = BLACK;
            gameboard[1][i-1] = BLACK;
            gameboard[2][i] = BLACK;

            gameboard[5][i-1] = RED;
            gameboard[6][i] = RED;
            gameboard[7][i-1] = RED;
        }
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
        Piece[][] boardCopy = new Piece[8][8];
        for (int i = 0; i < boardCopy.length; i++) {
            boardCopy[i] = gameboard[i].clone();
        }
        return boardCopy;
    }
}
