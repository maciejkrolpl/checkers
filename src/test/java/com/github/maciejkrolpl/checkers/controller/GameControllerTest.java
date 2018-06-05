package com.github.maciejkrolpl.checkers.controller;

import com.github.maciejkrolpl.checkers.model.Board;
import com.github.maciejkrolpl.checkers.model.Move;
import com.github.maciejkrolpl.checkers.model.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameControllerTest {

    private GameController gameController;

    @Before
    public void initialize() {
        Board board = new Board();
        Move move = new Move(board);
        gameController = new GameController(board, move);
    }

    @Test
    public void givenCorrectPiece_WhenTryingToMovePiece_ShouldReturnTrue() {
        //given
        int pieceToMove = 1;
        Piece piece = Piece.BLACK;

        //when
        boolean verify = gameController.verifyPieceToMove(pieceToMove, piece);

        //then
        assertTrue(verify);
    }

    @Test
    public void givenIncorrectPiece_WhenTryingToMovePiece_ShouldReturnFalse() {
        //given
        int pieceToMove = 50;
        Piece piece = Piece.BLACK;

        //when
        boolean verify = gameController.verifyPieceToMove(pieceToMove, piece);

        //then
        assertFalse(verify);
    }


}
