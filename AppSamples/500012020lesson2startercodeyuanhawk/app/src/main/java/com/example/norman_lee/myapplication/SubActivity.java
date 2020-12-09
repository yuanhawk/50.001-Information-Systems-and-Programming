package com.example.norman_lee.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    Button buttonBackToCalculator;
    EditText editTextSubValueOfA;
    EditText editTextSubValueOfB;
    public final static String INTENT_EXCH_RATE = "Exchange Rate";
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.subsharedprefs"; // created an instance sharedPref in Application
    public final static String A_KEY = "A_KEY";
    public final static String B_KEY = "B_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        initWidgets();

        //TODO 4.9 Implement saving to shared preferences for the contents of the EditText widget
        mPreferences = MyApplication.getSharedPref();
        if (!mPreferences.getString(A_KEY, "").equals(""))
            editTextSubValueOfA.setText(mPreferences.getString(A_KEY, "").trim());
        if (!mPreferences.getString(B_KEY, "").equals(""))
            editTextSubValueOfB.setText(mPreferences.getString(B_KEY, "").trim());

        //TODO 3.7 Set up setOnClickListener
        //TODO 3.8 Obtain the values stored in the editTextWidgets
        buttonBackToCalculator.setOnClickListener(view -> {
            String valA = String.valueOf(editTextSubValueOfA.getText()).trim();
            String valB = String.valueOf(editTextSubValueOfB.getText()).trim();

            //TODO 3.9 Check that these values are valid --> See the Utils class
            //TODO 3.12 Decide how you are going to handle a situation when the editText widgets are empty

            if (!TextUtils.isEmpty(valA) && !TextUtils.isEmpty(valB)) {
                double a = 0, b = 0;

                //TODO 3.11 Decide how you are going to handle a divide-by-zero situation or when negative numbers are entered
                try {
                    a = Double.parseDouble(valA);
                    if (a <= 0) {
                        editTextSubValueOfA.setError("Please key in a value that is more than 0");
                        return;
                    }
                } catch (NumberFormatException e) {
                    editTextSubValueOfA.setError("You have not keyed in a valid number");
                    return;
                }

                try {
                    b = Double.parseDouble(valB);
                    if (b <= 0) {
                        editTextSubValueOfB.setError("Please key in a value that is more than 0");
                        return;
                    }
                } catch (NumberFormatException e) {
                    editTextSubValueOfB.setError("You have not keyed in a valid number");
                    return;
                }


                //TODO 3.10 Set up an explicit intent and pass the exchange rate back to MainActivity
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(A_KEY, valA);
                intent.putExtra(B_KEY, valB);

                startActivity(intent);
                finish();
            }
        });

    }

    //TODO 3.5 Get references to the editText widgets
    //TODO 3.6 Get a reference to the Back To Calculator Button
    private void initWidgets() {
        buttonBackToCalculator = findViewById(R.id.buttonBackToCalculator);
        editTextSubValueOfA = findViewById(R.id.editTextSubValueA);
        editTextSubValueOfB = findViewById(R.id.editTextSubValueB);
    }

    //TODO 4.10 Don't forget to override onPause()

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(A_KEY, String.valueOf(editTextSubValueOfA.getText()).trim());
        editor.putString(B_KEY, String.valueOf(editTextSubValueOfB.getText()).trim());
        editor.apply();
    }
}
