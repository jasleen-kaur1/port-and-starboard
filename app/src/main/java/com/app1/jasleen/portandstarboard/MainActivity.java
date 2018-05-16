package com.app1.jasleen.portandstarboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Port and Starboard App";

    private Game startGame; //Reference to Game object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGame = new Game(); //setting startGame to a new Game object

        setupShowNameButton(R.id.btnLeft,"Port (left) is red" );
        setupShowNameButton(R.id.btnRight,"Starboard (right) is green.");
        setupMeansStateButton(R.id.btnPort, Game.Side.PORT);
        setupMeansStateButton(R.id.btnStarboard, Game.Side.STARBOARD);
        updateUI();

    }
    // Method for "Show Left Name" and "Show Right Name" Buttons
    private void setupShowNameButton(int buttonId, final String statement ) {
        //Wire up the top buttons to do stuff
        //.. get the button
        Button btnShowName = findViewById(buttonId);
        //.. set what happens when the user clicks
        btnShowName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, statement);
                Toast.makeText(getApplicationContext(), statement, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
    // Method for "Means Left" and "Means Right" Buttons
    private void setupMeansStateButton(int buttonId, final Game.Side name) { //Game.Side??
        //Wire up the left bottom button to do stuff
        //.. get the button
        Button btnMeansState = findViewById(buttonId);
        //.. set what happens when the user clicks
        btnMeansState.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String currentState = startGame.getChosenSideName();
                //startGame.setWinner(Game.Side.PORT);  I think this changes winner so will always be true?
                if (startGame.checkIfCorrect(name)){
                    Log.i(TAG, "User guess of " + currentState + " was Correct!");
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT)
                            .show();
                }else{
                    Log.i(TAG, "User guess of "+ currentState + " was Incorrect.");
                    Toast.makeText(getApplicationContext(), "Incorrect :(", Toast.LENGTH_SHORT)
                            .show();
                }
                startGame = new Game();
                updateUI();
            }
        });
    }

    private void updateUI() {
        TextView textView =  findViewById(R.id.chosenSideName);
        String currentState = startGame.getChosenSideName();

        textView.setText(currentState);
    }

}

/**
 * Inside onCreate
 //setupPortButton(); // method for Means Left Button
 //setupStarboardButton(); // method for Means Right Button

 //Wire up the left top button to do stuff
 //.. get the button
 Button btn1 = findViewById(R.id.btnLeft);
 //.. set what happens when the user clicks
 btn1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Log.i(TAG1, "Port (left) is red");
Toast.makeText(getApplicationContext(), "Port (left) is red", Toast.LENGTH_SHORT)
.show();
}
});
 //Wire up the right top button to do stuff
 //.. get the button
 Button btn2 = findViewById(R.id.btnRight);
 //.. set what happens when the user clicks
 btn2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Log.i(TAG2, "Starboard (right) is green");
Toast.makeText(getApplicationContext(), "Starboard (right) is green", Toast.LENGTH_SHORT)
.show();
}
});
 */

/** after
 private void setupPortButton() {
 //Wire up the left bottom button to do stuff
 //.. get the button
 Button btn3 = findViewById(R.id.btnPort);
 //.. set what happens when the user clicks
 btn3.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v) {
//startGame.setWinner(Game.Side.PORT);  I think this changes winner so will be true
if (startGame.checkIfCorrect(Game.Side.PORT)){
Log.i(TAG3, "User guess of Port was Correct!");
Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT)
.show();
}else{
Log.i(TAG3, "User guess of Port was Incorrect");
Toast.makeText(getApplicationContext(), "Incorrect :(", Toast.LENGTH_SHORT)
.show();
}
}
});
 }

 private void setupStarboardButton() {
 //Wire up the right bottom button to do stuff
 //.. get the button
 Button btn4 = findViewById(R.id.btnStarboard);
 //.. set what happens when the user clicks
 btn4.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
//startGame.setWinner(Game.Side.STARBOARD);  I think this changes winner so will be true
if (startGame.checkIfCorrect(Game.Side.STARBOARD)) {
Log.i(TAG4, "User guess of Starboard was Correct!");
Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT)
.show();
}else{
Log.i(TAG4, "User guess of Starboard was Incorrect :(");
Toast.makeText(getApplicationContext(), "Incorrect :(", Toast.LENGTH_SHORT)
.show();
}
}
});
 //startGame = new Game();
 //updateUI();
 }
 */