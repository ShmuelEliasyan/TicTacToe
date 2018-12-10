package com.example.shmueleliasyan.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class TicTacToe extends AppCompatActivity
        implements View.OnClickListener{
    private Button b00;
    private Button b01;
    private Button b02;
    private Button b10;
    private Button b11;
    private Button b12;
    private Button b20;
    private Button b21;
    private Button b22;
    private Button newGame;
    private TicTacToeGame game;
    private final int PLAYER_X_WON=1;
    private final int DRAW=2;
    private final int PLAYER_O_WON=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);
        newGame = (Button) findViewById(R.id.newGame);

        game = new TicTacToeGame(b00,b01,b02,b10,b11,b12,b20,b21,b22);

        this.b00.setOnClickListener(this);
        this.b01.setOnClickListener(this);
        this.b02.setOnClickListener(this);
        this.b10.setOnClickListener(this);
        this.b11.setOnClickListener(this);
        this.b12.setOnClickListener(this);
        this.b20.setOnClickListener(this);
        this.b21.setOnClickListener(this);
        this.b22.setOnClickListener(this);
        //A method that initializes the game
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 game.startAgain();
            }
        });
    }
    //A method that recognizes which button is pressed
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b00:
                add(b00);
                break;
            case R.id.b01:
                add(b01);
                break;
            case R.id.b02:
                add(b02);
                break;
            case R.id.b10:
                add(b10);
                break;
            case R.id.b11:
                add(b11);
                break;
            case R.id.b12:
                add(b12);
                break;
            case R.id.b20:
                add(b20);
                break;
            case R.id.b21:
                add(b21);
                break;
            case R.id.b22:
                add(b22);
                break;
        }
    }
    //A method that accepts the button and works accordingly
    private void add(Button b) {
           int state;
           state=this.game.addChars(b);
           if(state==PLAYER_X_WON){
               Toast.makeText(this, "Player win!", Toast.LENGTH_LONG).show();
           }
           if(state==DRAW){
               Toast.makeText(this, "its a Draw!", Toast.LENGTH_LONG).show();
           }
           if (state==PLAYER_O_WON){
               Toast.makeText(this, "Computer win!", Toast.LENGTH_LONG).show();
           }
       }
    }
