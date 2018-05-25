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
    private void setupMeansStateButton(int buttonId, final Game.Side name) {
        //Wire up the left bottom button to do stuff
        //.. get the button
        Button btnMeansState = findViewById(buttonId);
        //.. set what happens when the user clicks
        btnMeansState.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String currentState = startGame.getChosenSideName();
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
