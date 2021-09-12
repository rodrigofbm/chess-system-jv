package com.company.chess.pieces;

import com.company.boardgame.Board;
import com.company.boardgame.Position;
import com.company.chess.ChessPiece;
import com.company.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }


    @Override
    public boolean[][] possibleMoves() {
        var mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        //above
        for (int i = 1; i <= position.getRow(); i++) {
            var row = position.getRow() - i;
            var piece = getBoard().pice(row, position.getColumn());

           if(piece == null) {
               mat[row][position.getColumn()] = true;
           } else if(piece != null && ((ChessPiece)piece).getColor() != getColor()) {
               mat[row][position.getColumn()] = true;
               break;
           } else {
               break;
           }
        }

        //left
        for (int i = 1; i <= position.getColumn(); i++) {
            var column = position.getColumn() - i;
            var piece = getBoard().pice(position.getRow(), column);

            if(piece == null) {
                mat[position.getRow()][column] = true;
            } else if(piece != null && ((ChessPiece)piece).getColor() != getColor()) {
                mat[position.getRow()][column] = true;
                break;
            } else {
                break;
            }
        }

        //right
        for (int i = 1; i <= (getBoard().getColumns() - position.getColumn()) - 1; i++) {
            var column = position.getColumn() + i;
            var piece = getBoard().pice(position.getRow(), column);

            if(piece == null) {
                mat[position.getRow()][column] = true;
            } else if(piece != null && ((ChessPiece)piece).getColor() != getColor()) {
                mat[position.getRow()][column] = true;
                break;
            } else {
                break;
            }
        }

        //below
        for (int i = 1; i <= (getBoard().getRows() - position.getRow()) - 1; i++) {
            var row = position.getRow() + i;
            var piece = getBoard().pice(row, position.getColumn());

            if(piece == null) {
                mat[row][position.getColumn()] = true;
            } else if(piece != null && ((ChessPiece)piece).getColor() != getColor()) {
                mat[row][position.getColumn()] = true;
                break;
            } else {
                break;
            }
        }

        return mat;
    }
}
