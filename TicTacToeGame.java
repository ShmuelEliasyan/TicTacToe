package com.example.shmueleliasyan.tictactoe;

import android.widget.Button;

public class TicTacToeGame {
    private final int PLAYER_X_WON=1;
    private final int DRAW=2;
    private final int PLAYER_O_WON=3;
    private Button b00;
    private Button b01;
    private Button b02;
    private Button b10;
    private Button b11;
    private Button b12;
    private Button b20;
    private Button b21;
    private Button b22;
    private Button[][] chart;
    private int counter;
    boolean gameOver;
    //A constructor that initializes the game and coordinates between the buttons and the array
    public TicTacToeGame(Button b00,Button b01,Button b02,Button b10,Button b11,Button b12,Button b20,Button b21,Button b22){
        this.chart=new Button[3][3];
        this.b00=b00;
        this.b01=b01;
        this.b02=b02;
        this.b10=b10;
        this.b11=b11;
        this.b12=b12;
        this.b20=b20;
        this.b21=b21;
        this.b22=b22;
        chart[0][0]=this.b00;
        chart[0][1]=this.b01;
        chart[0][2]=this.b02;
        chart[1][0]=this.b10;
        chart[1][1]=this.b11;
        chart[1][2]=this.b12;
        chart[2][0]=this.b20;
        chart[2][1]=this.b21;
        chart[2][2]=this.b22;
        this.counter=0;
        this.gameOver=false;
        for(int i=0;i<3;i++){
            for (int k=0;k<3;k++){
                chart[i][k].setText("");
            }
        }
    }
    //A method that initiates the game
    public void startAgain() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                chart[i][k].setText("");
            }
            this.counter = 0;
            this.gameOver=false;
        }
    }
    //A method that adds a button and works accordingly
    public int addChars(Button b) {
        if (b.getText().toString().equals("")&&gameOver==false) {
            b.setText("X");
            counter++;
            if (winner(this.chart) == true) {
                this.gameOver=true;
                return PLAYER_X_WON;
            }
            if(this.counter == 9){
                this.gameOver=true;
                return DRAW;
            }
            addRandom(this.chart);
            if (winner(this.chart) == true) {
                this.gameOver=true;
                return PLAYER_O_WON;
            }
        }
        return 0;
    }
    //A private method that checks whether there is a winner
    private boolean winner(Button[][] chart) {
            int counterRowsX=0,counterColumnsX=0;
            int counterRowsO=0,counterColumnsO=0;
            if((this.chart[0][0].getText().toString().equals("O"))&&(this.chart[1][1].getText().toString().equals("O"))&&(this.chart[2][2].getText().toString().equals("O"))==true
                    ||(this.chart[0][0].getText().toString().equals("X"))&&(this.chart[1][1].getText().toString().equals("X"))&&(this.chart[2][2].getText().toString().equals("X"))==true){
                return true;
            }
            if((this.chart[0][2].getText().toString().equals("O"))&&(this.chart[1][1].getText().toString().equals("O"))&&(this.chart[2][0].getText().toString().equals("O"))==true
                    ||(this.chart[0][2].getText().toString().equals("X"))&&(this.chart[1][1].getText().toString().equals("X"))&&(this.chart[2][0].getText().toString().equals("X"))==true){
                return true;
            }
            for (int i=0;i<3;i++) {
                counterRowsX = 0;
                counterColumnsX = 0;
                counterRowsO = 0;
                counterColumnsO = 0;
                for (int k = 0; k < 3; k++) {
                    if (this.chart[i][k].getText().toString().equals("X")) {
                        counterRowsX += 1;
                    }
                    if (this.chart[k][i].getText().toString().equals("X")) {
                        counterColumnsX += 1;
                    }
                    if (this.chart[i][k].getText().toString().equals("O")) {
                        counterRowsO += 1;
                    }
                    if (this.chart[k][i].getText().toString().equals("O")) {
                        counterColumnsO += 1;
                    }
                }
                if(counterColumnsO==3||counterColumnsX==3||counterRowsO==3||counterRowsX==3){
                    return true;
                }
            }
            return false;
        }
    //A private method that is added 'O' randomly
    private void addRandom(Button[][] chart) {
        boolean found=false;
        int a=0,b=0;
        while (found==false){
            a=(int)(Math.random()*3);
            b=(int)(Math.random()*3);
            if(this.chart[a][b].getText().equals("")){
                this.chart[a][b].setText("O");
                found=true;
                this.counter++;
            }
        }
    }
}
