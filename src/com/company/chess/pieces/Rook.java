package com.company.chess.pieces;

import com.company.boardgame.Board;
import com.company.chess.ChessPiece;
import com.company.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        var mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        return mat;
    }
}
