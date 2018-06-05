package com.github.maciejkrolpl.checkers.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MoveTest {
    private Move move;


    @Before
    public void initialize() {
        Board board = new Board();
        move = new Move(board);
    }

    @Test
    public void givenPieceToMoveAndMoveDirectionDownRight_WhenVeriryingMove_ShouldIncrementBothNumbers() {
        //given
        int i = 0;
        int j = 0;
        int iExpected = 1;
        int jExpected = 1;
        Direction direction = Direction.DOWN_RIGHT;

        //when
        int result = move.doMove(i, j, direction);
        int iResult = result / 10;
        int jResult = result % 10;
        boolean verify = ((iResult == iExpected) && (jResult == jExpected));

        //should
        Assert.assertTrue(verify);
    }

    @Test
    public void givenPieceToMoveAndMoveDirectionDownLeft_WhenVeriryingMove_ShouldIncrement_i_AndDecrement_j_() {
        //given
        int i = 3;
        int j = 3;
        int iExpected = 4;
        int jExpected  = 2;
        Direction direction = Direction.DOWN_LEFT;

        //when
        int result = move.doMove(i, j, direction);
        int iResult = result / 10;
        int jResult = result % 10;
        boolean verify = ((iResult == iExpected) && (jResult == jExpected));

        //should
        Assert.assertTrue(verify);
    }


    @Test
    public void givenPieceToMoveAndMoveDirectionUpLeft_WhenVeriryingMove_ShouldDecrementBothNumbers() {
        //given
        int i = 3;
        int j = 3;
        int iExpected = 2;
        int jExpected = 2;
        Direction direction = Direction.UP_LEFT;

        //when
        int result = move.doMove(i, j, direction);
        int iResult = result / 10;
        int jResult = result % 10;
        boolean verify = ((iResult == iExpected) && (jResult == jExpected));

        //should
        Assert.assertTrue(verify);
    }


    @Test
    public void givenPieceToMoveAndMoveDirectionUpRight_WhenVeriryingMove_ShouldDecrement_i_AndIncrement_j_() {
        //given
        int i = 3;
        int j = 3;
        int iExpected = 2;
        int jExpected = 4;
        Direction direction = Direction.UP_RIGHT;

        //when
        int result = move.doMove(i, j, direction);
        int iResult = result / 10;
        int jResult = result % 10;
        boolean verify = ((iResult == iExpected) && (jResult == jExpected));

        //should
        Assert.assertTrue(verify);
    }

}
