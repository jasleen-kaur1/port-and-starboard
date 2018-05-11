package com.app1.jasleen.portandstarboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG1= "My Left Button";
    private static final String TAG2= "My Right Button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wire up the left button to do stuff
        //.. get the button
        Button Lbtn = findViewById(R.id.LbtnLeft);
        //.. set what happens when the user clicks
        Lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Port (left) is red");
                Toast.makeText(getApplicationContext(),"Port (left) is red", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        //Wire up the right button to do stuff
        //.. get the button
        Button Rbtn = findViewById(R.id.RbtnRight);
        //.. set what happens when the user clicks
        Rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG2, "Starboard (right) is green");
                Toast.makeText(getApplicationContext(), "Starboard (right) is green", Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }
}
