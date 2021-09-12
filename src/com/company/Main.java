package com.company;

import com.company.boardgame.Board;
import com.company.chess.ChessException;
import com.company.chess.ChessMatch;
import com.company.chess.ChessPiece;
import com.company.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                UI.clearConsole();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                var possibleMoves = chessMatch.possibleMoves(source);
                UI.clearConsole();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }catch (ChessException  e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
