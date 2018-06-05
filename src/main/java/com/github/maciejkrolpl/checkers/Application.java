package com.github.maciejkrolpl.checkers;

import com.github.maciejkrolpl.checkers.controller.GameController;
import com.github.maciejkrolpl.checkers.model.Board;
import com.github.maciejkrolpl.checkers.model.Move;
import com.github.maciejkrolpl.checkers.view.ConsoleView;

public class Application {
    public static void main(String[] args) {

        Board board = new Board();
        Move move = new Move(board);
        GameController gameController = new GameController(board, move);
        ConsoleView consoleView = new ConsoleView(gameController);

        consoleView.run();
    }
}
