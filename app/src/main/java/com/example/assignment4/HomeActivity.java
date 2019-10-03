package com.example.assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button disableButton;
    EditText textView;

    Boolean textDisabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // find the button
        disableButton =(Button) findViewById(R.id.disableBtn);
        // find the text
        textView = (EditText) findViewById(R.id.editText);

        // check if there is saved boolean
        if (savedInstanceState != null){
            // change the state to what was saved
            textDisabled = savedInstanceState.getBoolean("state");

            // change the state of the editText
            // if the text is disabled...
            if (textDisabled){
                // disable the text
                textView.setEnabled(false);
            }
            // else...
            else{
                // enable the text
                textView.setEnabled(true);
            }
        }
        // no need to do this for editText, because it saves it automatically

        disableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textDisabled == true){
                    Toast.makeText(getApplicationContext(), "Text has been enabled", Toast.LENGTH_SHORT)
                            .show();
                    textDisabled = false;
                    textView.setEnabled(true);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Text has been disabled", Toast.LENGTH_SHORT)
                            .show();
                    textDisabled = true;
                    textView.setEnabled(false);
                }
            }
        });

    }

    // save the state of the boolean
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("state", textDisabled);
    }
}
