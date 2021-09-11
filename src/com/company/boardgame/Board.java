package com.company.boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pices;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1) {
            throw new BoardException("Error on creating board: rows and columns should be at least 1");
        }

        this.rows = rows;
        this.columns = columns;

        pices = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece pice(int row, int column) {
        if(!positionExists(row, column)) {
            throw new BoardException("invalid Position");
        }
        return pices[row][column];
    }

    public Piece piece(Position position) {
        return pice(position.getRow(),position.getColumn());
    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)) {
            throw new BoardException("Slot not empty");
        }
        pices[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position.getRow(), position.getColumn())) {
            throw new BoardException("invalid Position");
        }

        return piece(position) != null;
    }

    public boolean thereIsAPiece(int row, int column) {
        return thereIsAPiece(new Position(row, column));
    }
}
