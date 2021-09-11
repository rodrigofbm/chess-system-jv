package com.company;

import com.company.boardgame.Board;
import com.company.chess.ChessMatch;

public class Main {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
