package com.example.norman_lee.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.example.norman_lee.myapplication.util.ExchangeRate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.norman_lee.myapplication.SubActivity.A_KEY;
import static com.example.norman_lee.myapplication.SubActivity.B_KEY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * This is a terrible way to write Android app, only for demo purposes, but you should always separate
     * business logic from application layer, no calculation should be done here (which was done here)!
     *
     * I created only an instance of SharedPref, and you should avoid creating multiple instances of SharedPref
     */

    Button buttonConvert;
    Button buttonSetExchangeRate;
    EditText editTextValue;
    TextView textViewResult;
    TextView textViewExchangeRate;
    double exchangeRate;
    public final String TAG = "Logcat";
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.mainsharedprefs"; // created an instance sharedPref in Application
    public static final String RATE_KEY = "Rate_Key";

    private ExchangeRate rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 2.1 Use findViewById to get references to the widgets in the layout
        initWidget();


        //TODO 4.5 Get a reference to the sharedPreferences object
        mPreferences = MyApplication.getSharedPref();

        //TODO 4.6 Retrieve the value using the key, and set a default when there is none
        if (!mPreferences.getString(RATE_KEY, "").equals(""))
            editTextValue.setText(mPreferences.getString(RATE_KEY, "").trim());


        rate = new ExchangeRate(String.valueOf(2.95));
        //TODO 3.13 Get the intent, retrieve the values passed to it, and instantiate the ExchangeRate class
        String valA = getIntent().getStringExtra(A_KEY);
        String valB = getIntent().getStringExtra(B_KEY);

        if (valA != null && valB != null) {
            rate = new ExchangeRate(valA, valB);
            textViewExchangeRate.setText(String.valueOf(rate.getExchangeRate()));
        }

        //TODO 3.13a See ExchangeRate class --->

        //TODO 2.2 Assign a default exchange rate of 2.95 to the textView
        textViewResult.setText(String.valueOf(2.95));

        //TODO 2.3 Set up setOnClickListener for the Convert Button
        buttonConvert.setOnClickListener(this);

        //TODO 2.4 Display a Toast & Logcat message if the editTextValue widget contains an empty string
        String amount = String.valueOf(editTextValue.getText()).trim();
        if (TextUtils.isEmpty(amount))
            Toast.makeText(this, "EditTextValue widget contains empty string", Toast.LENGTH_SHORT).show();;

        //TODO 2.5 If not, calculate the units of B with the exchange rate and display it


        //TODO 2.5a See ExchangeRate class --->


        //TODO 3.1 Modify the Android Manifest to specify that the parent of SubActivity is MainActivity
        //TODO 3.2 Get a reference to the Set Exchange Rate Button
        //TODO 3.3 Set up setOnClickListener for this
        //TODO 3.4 Write an Explicit Intent to get to SubActivity
        buttonSetExchangeRate.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    private void initWidget() {
        buttonConvert = findViewById(R.id.buttonConvert);
        buttonSetExchangeRate = findViewById(R.id.buttonSetExchangeRate);
        editTextValue = findViewById(R.id.editTextValue);
        textViewResult = findViewById(R.id.textViewResult);
        textViewExchangeRate = findViewById(R.id.textViewExchangeRate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            //TODO 4.1 Go to res/menu/menu_main.xml and add a menu item Set Exchange Rate
            //TODO 4.2 In onOptionsItemSelected, add a new if-statement and code accordingly
            case R.id.set_exchange_rate:
                startActivity(new Intent(this, SubActivity.class));
                return true;

            //TODO 5.1 Go to res/menu/menu_main.xml and add a menu item Open Map App
            //TODO 5.2 In onOptionsItemSelected, add a new if-statement
            //TODO 5.3 code the Uri object and set up the intent
            case R.id.open_map_app:
                Uri geoLocation = new Uri.Builder()
                        .scheme("geo")
                        .opaquePart("0.0")
                        .appendQueryParameter("q", "SUTD")
                        .build();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);

                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonConvert:
                String foreignAmt = String.valueOf(editTextValue.getText()).trim();

                if (!TextUtils.isEmpty(foreignAmt))
                    textViewResult.setText(String.valueOf(rate.calculateAmount(foreignAmt)));
                break;

            //TODO 3.4 Write an Explicit Intent to get to SubActivity
            case R.id.buttonSetExchangeRate:
                startActivity(new Intent(this, SubActivity.class));
                finish();
                break;
        }
    }

    //TODO 4.3 override the methods in the Android Activity Lifecycle here
    //TODO 4.4 for each of them, write a suitable string to display in the Logcat
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: activity started...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: activity paused...");

        //TODO 4.7 In onPause, get a reference to the SharedPreferences.Editor object
        SharedPreferences.Editor editor = mPreferences.edit();
        //TODO 4.8 store the exchange rate using the putString method with a key
        editor.putString(RATE_KEY, String.valueOf(editTextValue.getText()));
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: activity stopped...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: activity destroyed...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: activity restarted...");
    }

}
