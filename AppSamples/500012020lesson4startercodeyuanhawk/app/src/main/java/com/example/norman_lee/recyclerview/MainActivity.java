package com.example.norman_lee.recyclerview;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CharaAdapter charaAdapter;
    ImageView imageViewAdded;

    DataSource dataSource;

    final String KEY_DATA = "data";
    final String LOGCAT = "RV";
    final String PREF_FILE = "mainsharedpref";
    final int REQUEST_CODE_IMAGE = 1000;

    SharedPreferences mPreferences;

    final int READ_PERMISSION = 1;
    final int WRITE_PERMISSION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_PERMISSION);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_PERMISSION);

        initWidgets();

        //TODO 12.7 Load the Json string from shared Preferences
        mPreferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
        String val = mPreferences.getString(KEY_DATA, "");

        //TODO 12.8 Initialize your dataSource object with the Json string
        dataSource = new Gson().fromJson(val, DataSource.class);

        //TODO 11.2 Create your dataSource object by calling Utils.firstLoadImages
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.pikachu);
        images.add(R.drawable.snorlax);
        images.add(R.drawable.eevee);
        images.add(R.drawable.squirtle);
        images.add(R.drawable.gyrados);
        images.add(R.drawable.bulbasaur);
        images.add(R.drawable.psyduck);
        images.add(R.drawable.spearow);
        dataSource = Utils.firstLoadImages(this, images);

        //TODO 11.3 --> Go to CharaAdapter
        //TODO 11.8 Complete the necessary code to initialize your RecyclerView
        charaAdapter = new CharaAdapter(this, dataSource);
        recyclerView.setAdapter(charaAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        //TODO 12.9 [OPTIONAL] Add code to delete a RecyclerView item upon swiping. See notes for the code.
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int pos = viewHolder.getAdapterPosition();
                dataSource.removeDataData(pos);
                charaAdapter.notifyItemRemoved(pos);
            }
        };

        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);


        //TODO 12.1 Set up an Explicit Intent to DataEntry Activity with startActivityForResult (no coding)
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DataEntry.class);
                startActivityForResult(intent, REQUEST_CODE_IMAGE);

            }
        });
    }

    //TODO 11.1 Get references to the widgets
    private void initWidgets() {
        imageViewAdded = findViewById(R.id.imageViewAdded);
        recyclerView = findViewById(R.id.charaRecyclerView);
    }

    //TODO 12.6 Complete onPause to store the DataSource object in SharedPreferences as a JSON string
    @Override
    protected void onPause(){
        super.onPause();

        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(KEY_DATA, new Gson().toJson(dataSource));
        editor.apply();
    }


    /*@Override
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    //TODO 12.5 Write onActivityResult to get the data passed back from DataEntry and add to DataSource object
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == REQUEST_CODE_IMAGE && resultCode == Activity.RESULT_OK){
            String name = data.getStringExtra(DataEntry.KEY_NAME);
            String path = data.getStringExtra(DataEntry.KEY_PATH);

            dataSource.addData(name, path);

            Bitmap bitmap = null;
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                bitmap = Utils.loadImageFromStorage(path, name);

            if (bitmap == null) {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            }
            imageViewAdded.setImageBitmap(bitmap);

            Toast.makeText(this, "New image added", Toast.LENGTH_LONG).show();

            charaAdapter.notifyDataSetChanged();
            recyclerView.invalidate();
        }


    }
}
