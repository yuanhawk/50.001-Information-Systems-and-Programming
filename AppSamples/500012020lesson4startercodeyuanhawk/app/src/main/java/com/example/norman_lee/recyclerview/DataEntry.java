package com.example.norman_lee.recyclerview;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class DataEntry extends AppCompatActivity {

    EditText editTextNameEntry;
    Button buttonSelectImage;
    Button buttonOK;
    ImageView imageViewSelected;
    Bitmap bitmap;
    final static int REQUEST_IMAGE_GET = 2000;
    final static String KEY_PATH = "Image";
    final static String KEY_NAME = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        editTextNameEntry = findViewById(R.id.editTextNameEntry);
        buttonSelectImage = findViewById(R.id.buttonSelectImage);
        imageViewSelected = findViewById(R.id.imageViewSelected);
        buttonOK = findViewById(R.id.buttonOK);

        //TODO 12.2 Set up an implicit intent to the image gallery (standard code)
        buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_GET);
                }

            }
        });

        //TODO 12.4 When the OK button is clicked, set up an intent to go back to MainActivity
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(editTextNameEntry.getText()).trim();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(DataEntry.this, "Please fill in the name and select an image", Toast.LENGTH_LONG).show();
                    return;
                }

                String path = null;
                if (ContextCompat.checkSelfPermission(DataEntry.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                    path = Utils.saveToInternalStorage(bitmap, name, DataEntry.this);

                if (path == null) {
                    Toast.makeText(DataEntry.this, "Error", Toast.LENGTH_LONG).show();
                    return;
                }

                int resultCode = Activity.RESULT_OK;
                Intent intent = new Intent();

                intent.putExtra(KEY_NAME, name);
                intent.putExtra(KEY_PATH, path);

                setResult(resultCode, intent);
                finish();
            }
        });

        //TODO 12.5 --> Go back to MainActivity


    }

    //TODO 12.3 Write onActivityResult to get the image selected
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            try {
                bitmap = MediaStore.Images
                        .Media.getBitmap(getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }

            imageViewSelected.setImageBitmap(bitmap);
        }
    }
}
