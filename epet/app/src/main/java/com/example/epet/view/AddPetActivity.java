package com.example.epet.view;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.epet.Model.Pet;
import com.example.epet.R;
import com.example.epet.api.ApiAddress;
import com.example.epet.api.PostTask;
import com.example.epet.calback.ImageUploader;
import com.example.epet.calback.PostCallback;
import com.example.epet.util.Messenger;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddPetActivity extends AppCompatActivity implements ImageUploader.UploadCallback, PostCallback {

    // Declare member variables for views
    private TextInputLayout etPetName;
    private TextInputLayout etAge;
    private TextInputLayout etType;
    private TextInputLayout etBreed;
    private TextInputLayout etColor;
    private TextInputLayout etDescription;
    private Spinner spGender;
    private RadioGroup rgAgeType;
    private Button btnAddPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        // Initialize components
        etPetName = findViewById(R.id.houseNumber);
        etAge = findViewById(R.id.age);
        etType = findViewById(R.id.type);
        etBreed = findViewById(R.id.breed);
        etColor = findViewById(R.id.color);
        etDescription = findViewById(R.id.description);
        spGender = findViewById(R.id.sp_gender);
        rgAgeType = findViewById(R.id.ageType);
        btnAddPet = findViewById(R.id.addPet);

        // Set up spinner for gender options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapter);

        // Set up button click listener
        btnAddPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle add pet action here
                addPet();
            }
        });
    }

    private void addPet() {
        // Collect data from input fields
        String petName = etPetName.getEditText().getText().toString().trim();
        String age = etAge.getEditText().getText().toString().trim();
        String type = etType.getEditText().getText().toString().trim();
        String breed = etBreed.getEditText().getText().toString().trim();
        String color = etColor.getEditText().getText().toString().trim();
        String description = etDescription.getEditText().getText().toString().trim();
        String gender = spGender.getSelectedItem().toString();

        int selectedAgeTypeId = rgAgeType.getCheckedRadioButtonId();
        RadioButton selectedAgeType = findViewById(selectedAgeTypeId);
        String ageType = selectedAgeType.getText().toString();

    }

    @Override
    public void onUploadComplete(String response) {

    }

    @Override
    public void onPostSuccess(String responseData) {
        if (getIntent().hasExtra("pet")) {
            Messenger.showAlertDialog(this, "Pet Update", "Pet updated successfully", "Ok").show();
            return;
        }

        Messenger.showAlertDialog(this, "Pet Added", "Pet added successfully", "Ok", "Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(AddPetActivity.this, HeroActivity.class));
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public void onPostError(String errorMessage) {
        Messenger.showAlertDialog(this, "Data Error", errorMessage, "Ok").show();
    }
}
