package com.company.chess;

import com.company.boardgame.Position;

public class ChessPosition {
    private int row;
    private char column;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Invalid position");
        }

        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    protected Position toPosition() {
        int row = 8 - this.row;
        int column = this.column - 'a';

        return new Position(row, column);
    }

    protected static ChessPosition fromPosition(Position position) {
        //0,0 = a8
        int row = 8 - position.getRow();
        char column = (char)('a' - position.getColumn());

        return new ChessPosition(column, row);
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
