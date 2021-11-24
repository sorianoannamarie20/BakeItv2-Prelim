package com.example.prelim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddRecipe extends AppCompatActivity implements Callback {
    RecyclerView recyclerView;
    ArrayList<Recipe> arrayList;
    DataAdapter adapter;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Item Loading...");
        databaseReference = FirebaseDatabase.getInstance().getReference("UploadRecipe");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Recipe recipe = ds.getValue(Recipe.class);
                    recipe.setKey(ds.getKey());
                    arrayList.add(recipe);


                }
                adapter = new DataAdapter(AddRecipe.this, arrayList, AddRecipe.this);
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(AddRecipe.this, "Error" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Add);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.Add:
                        return true;

                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Account:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;
            }
        });
    }


    public void uploadClick(View view) {

        startActivity(new Intent(AddRecipe.this,Upload.class));
    }
    @Override
    public void onClick(int i) {
        Intent intent= new Intent(AddRecipe.this,Detail.class);
        intent.putExtra("IMAGE", arrayList.get(i).getPhotoUrl());
        intent.putExtra("NAME",arrayList.get(i).getName());
        intent.putExtra("INGREDIENTS",arrayList.get(i).getIngredients());
        intent.putExtra("INSTRUCTIONS",arrayList.get(i).getInstructions());
        intent.putExtra("KEY",arrayList.get(i).getKey());
        startActivity(intent);

    }

}