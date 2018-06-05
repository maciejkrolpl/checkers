package com.github.maciejkrolpl.checkers.controller;


import com.github.maciejkrolpl.checkers.model.Board;
import com.github.maciejkrolpl.checkers.model.Direction;
import com.github.maciejkrolpl.checkers.model.Move;
import com.github.maciejkrolpl.checkers.model.Piece;

/**
 * Game controller będzie zarządzał planszą i wykonywał walidacje (np, czy gra się skończyła).
 */
public class GameController {
    private Board board;
    private Move move;

    public GameController(Board board, Move move) {
        this.board = board;
        this.move = move;
    }

    public Board getBoard() {
        return board;
    }

    public int getSIZE() {
        return board.getSIZE();
    }

    public int getRedPiecesCount() {
        return board.getRedPiecesCount();
    }

    public int getBlackPiecesCount() {
        return board.getBlackPiecesCount();
    }

    public Piece[][] getGameboard() {
        return board.getBoardCopy();
    }

    public boolean verifyMove(int pieceToMove, Direction direction, Piece piece, boolean isMoveToPerform) {
        Piece oppositePiece = (piece == Piece.RED) ? Piece.BLACK : Piece.RED;

        int iToMove = pieceToMove / 10;
        int jToMove = pieceToMove % 10;

        int pieceMoved = move.doMove(iToMove, jToMove, direction);
        int iMoved = pieceMoved / 10;
        int jMoved = pieceMoved % 10;

        try {
            if (getGameboard()[iMoved][jMoved] == Piece.NONE) {
                if (isMoveToPerform) {
                    board.getGameboard()[iToMove][jToMove] = Piece.NONE;
                    board.getGameboard()[iMoved][jMoved] = piece;
                }
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        int pieceMovedTwice = move.doMove(iMoved, jMoved, direction);
        int iMovedTwice = pieceMovedTwice / 10;
        int jMovedTwice = pieceMovedTwice % 10;

        if ((getGameboard()[iMoved][jMoved] == oppositePiece) && getGameboard()[iMovedTwice][jMovedTwice] == Piece.NONE) {
            if (isMoveToPerform) {
                board.getGameboard()[iToMove][jToMove] = Piece.NONE;
                board.getGameboard()[iMoved][jMoved] = Piece.NONE;
                board.getGameboard()[iMovedTwice][jMovedTwice] = piece;
                if (oppositePiece == Piece.RED) {
                    board.decrementRedPiecesCount();
                } else {
                    board.decrementBlackPiecesCount();
                }
            }
            return true;
        }


        return false;
    }

    public boolean verifyPieceToMove(int pieceToMove, Piece piece) {

        int i = pieceToMove / 10;
        int j = pieceToMove % 10;


        try {
            if (getGameboard()[i][j] != piece) {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        return verifyAllMoves(pieceToMove, piece);

    }

    private boolean verifyAllMoves(int pieceToMove, Piece piece) {

        for (Direction dir : Direction.values()) {
            if (verifyMove(pieceToMove, dir, piece, false)) {
                return true;
            }
        }

        return false;

    }
}
