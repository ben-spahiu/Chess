package org.openjfx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.control.Label;
// import javafx.scene.shape.Shape;
// import java.util.ArrayList;
// import javafx.event.EventHandler;
// import javafx.scene.input.MouseButton;
// import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
public class Board {
    //private Piece[][] board;
    protected int s;            //square size
    protected long bitboard;    //long representing all pieces on board as 1s and 0s when formatted 8x8
    protected long whiteboard;  //^^^ for white pieces only
    protected long blackboard;  //^^^ for black pieces only
    //private ArrayList<Shape> decor;

    public Board(){
        //board = new Piece[8][8];
        s = 110;
        bitboard = 0xFFFF00000000FFFFL;
        whiteboard = 0x000000000000FFFFL;
        blackboard = 0xFFFF000000000000L;
    }

    public void setBoard(GridPane pane){
        //makeInteractable(pane);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Rectangle r = new Rectangle(s, s);
                if((i + j) % 2 == 0)    //light squares
                    r.setFill(Color.rgb(238,238,210));
                else                    //dark squares
                    r.setFill(Color.rgb(118,150,86));
                pane.add(r, j, i);
            }
        }

        addLabels(pane);

        //addPieces(pane);
        
    }

    private void addLabels(GridPane pane){
        Label rank;
        Label file;
        for(int i = 0; i < 8; i++){
            rank = new Label(8 - i + "");
            file = new Label((char)('a'+ i) + "");

            if(i % 2 == 0){
                rank.setTextFill(Color.rgb(118,150,86));
                file.setTextFill(Color.rgb(238,238,210));
            }
            else{
                rank.setTextFill(Color.rgb(238,238,210));
                file.setTextFill(Color.rgb(118,150,86));
            }
            rank.setTranslateX(0.06 * s);
            file.setTranslateX(0.87 * s);
            rank.setTranslateY(-0.36 * s);
            file.setTranslateY(0.39 * s);
            rank.setStyle("-fx-font-size: 15");
            file.setStyle("-fx-font-size: 15");
            pane.add(rank,0,i);
            pane.add(file,i,7);
        }
    }

    /*private void addPieces(GridPane pane){
        String[] pieces = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook", "Pawn"};
        for(int i = 0; i < 8; i++){
            //Black Pieces
            Piece bPiece = new Piece(pieces[i], 'B');
            pane.add(bPiece.getImage(), i, 0);
            board[0][i] = bPiece;

            //Black Pawns
            Piece bPawn = new Piece(pieces[8], 'B');
            pane.add(bPawn.getImage(), i, 1);
            board[1][i] = bPawn;

            //White Pieces
            Piece wPiece = new Piece(pieces[i], 'W');
            pane.add(wPiece.getImage(), i, 7);
            board[7][i] = wPiece;

            //White Pawns
            Piece wPawn = new Piece(pieces[8], 'W');
            pane.add(wPawn.getImage(), i, 6);
            board[6][i] = wPawn;
        }
    }
    */

    /*public void makeInteractable(GridPane pane){
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                //calculate tile
                int col = (int)event.getSceneX()/s;
                int row = (int)event.getSceneY()/s;
                
                //insert new Rectangle color
                Rectangle r = new Rectangle(s, s);

                //adding rectangle and bringing piece to front if necessary
                if((col+row) % 2 == 0)
                        r.setFill(Color.rgb(247,245,148));
                    else
                        r.setFill(Color.rgb(190,201,88));

                MouseButton button = event.getButton();
                if(button == MouseButton.PRIMARY && board[row][col] == null){
                    return;
                }
                if(button == MouseButton.SECONDARY){
                    System.out.println("Secondary");
                }

                pane.add(r, col, row);
                if(board[row][col] != null)
                    board[row][col].getImage().toFront();
            }
        });
    }
    */
}
