package com.company.chess;

import com.company.boardgame.Board;
import com.company.boardgame.Piece;
import com.company.boardgame.Position;
import com.company.chess.pieces.King;
import com.company.chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece)board.pice(i,j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

    public ChessPiece performChessMove(ChessPosition source, ChessPosition target) {
        Position sourcePos = source.toPosition();
        Position targetPos = target.toPosition();

        validateSourcePosition(sourcePos);
        validateTargetPosition(sourcePos, targetPos);
        Piece capturedPiece = makeMove(sourcePos, targetPos);

        return (ChessPiece)capturedPiece;
    }

    private void validateTargetPosition(Position sourcePos, Position targetPos) {
        if(!board.piece(sourcePos).possibleMove(targetPos)) {
            throw new ChessException("Not valid destination move");
        }
    }

    private Piece makeMove(Position sourcePos, Position targetPos) {
        Piece p = board.removePiece(sourcePos);
        Piece capturePiece = board.removePiece(targetPos);

        board.placePiece(p, targetPos);

        return capturePiece;
    }

    private void validateSourcePosition(Position sourcePos) {
        if(!board.thereIsAPiece(sourcePos)) {
            throw new ChessException("Empty source posotion");
        }
        if(!board.piece(sourcePos).isThereAnyPossibleMove()) {
            throw new ChessException("No possible moves for that piece");
        }
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        var position = sourcePosition.toPosition();
        validateSourcePosition(position);

        return board.piece(position).possibleMoves();
    }
}
