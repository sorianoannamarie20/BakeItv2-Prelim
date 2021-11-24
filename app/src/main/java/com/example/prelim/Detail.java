package com.example.prelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Detail extends AppCompatActivity {
    ImageView imageView;
    TextView tvItemName;
    TextView tvItemIngredients;
    TextView tvItemInstructions;
    String photoUrl;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        imageView = findViewById(R.id.image);
        tvItemName = findViewById(R.id.nameItem);
        tvItemIngredients = findViewById(R.id.ingredientsItem);
        tvItemInstructions = findViewById(R.id.instructionsItem);

        Intent intent = getIntent();
        photoUrl = intent.getStringExtra("IMAGE");

        Glide.with(this).load(photoUrl).into(imageView);

        String itemName = intent.getStringExtra("NAME");
        tvItemName.setText(itemName);

        String itemIngredients = intent.getStringExtra("INGREDIENTS");
        tvItemIngredients.setText(itemIngredients);

        String itemInstructions = intent.getStringExtra("INSTRUCTIONS");
        tvItemInstructions.setText(itemInstructions);

        key = intent.getStringExtra("KEY");


    }

    public void deleteItem(View view) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("UploadRecipe");
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Detail.this);
        builder.setTitle("Delete Recipe");
        builder.setMessage("Do you really want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reference.child(key).removeValue();
                Toast.makeText(Detail.this,"Recipe Deleted Successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Detail.this,AddRecipe.class));
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        }); builder.show();

    }
    public void back(View view) {
        Intent toAccount = new Intent (Detail.this, AddRecipe.class);
        startActivity (toAccount);
    }
}

