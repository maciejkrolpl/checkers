package com.github.maciejkrolpl.checkers.model;


public class Move {

    public Move(Board board) {
    }

    public int doMove(int i, int j, Direction direction) {

        switch (direction) {
            case UP_LEFT:
                i--;
                j--;
                break;
            case UP_RIGHT:
                i--;
                j++;
                break;
            case DOWN_LEFT:
                i++;
                j--;
                break;
            case DOWN_RIGHT:
                i++;
                j++;
                break;
        }

        return i*10+j;
    }


}
