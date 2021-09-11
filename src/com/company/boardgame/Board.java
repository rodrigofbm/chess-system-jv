package com.company.boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pices;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        pices = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece pice(int row, int column) {
        return pices[row][column];
    }

    public Piece pice(Position position) {
        return pices[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        pices[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
