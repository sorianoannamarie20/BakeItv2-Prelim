package com.example.prelim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private GridView gridView;
    int [] pic={R.drawable.rhubarbbuckle, R.drawable.peanutbutterpie,R.drawable.bowlchocolatecakeiii,R.drawable.bestlemonbars,
            R.drawable.creamyricepudding, R.drawable.keylimepievii, R.drawable.spanishflan,R.drawable.tiramisuii, R.drawable.pannacottawithstrawberryjam,
            R.drawable.capirotadaalaantiguamexicanbreadpudding,R.drawable.realstrawberryfrosting, R.drawable.simplestrawberrysauce,
            R.drawable.triplechocolatechunkcookies, R.drawable.deliciousraspberryoatmealcookiebars,R.drawable.oatmealpeanutbuttercookiesii,
            R.drawable.saltedchocolatecookies,R.drawable.westcoasttrailcookies, R.drawable.springlimeteacookies,
            R.drawable.snickerdoodlesv, R.drawable.lemonrhubarbbars,R.drawable.blueberrydropcookies,R.drawable.carrotcakecheesecake, R.drawable.rhubarbcheesecake,
            R.drawable.lemonmeringuecheesecake,R.drawable.aapricotcheesecake, R.drawable.keylimecheesecakei,R.drawable.strawberrycheesecake, R.drawable.whitechocolateraspberrycheesecake,
            R.drawable.pineapplecheesecake, R.drawable.bananacheesecakewithbananacreampietopping, R.drawable.lemoncheesecake, R.drawable.citruscheesecake, R.drawable.rhubarbcheesecakepie,
            R.drawable.hawaiiancheesecake, R.drawable.italiancreamcheeseandricottacheesecake, R.drawable.greenteamoussecheesecake, R.drawable.grandmothercheesecake, R.drawable.lemonpoundcake,
            R.drawable.blueberrylemonpoundcake, R.drawable.oldfashionedlemonpoundcake, R.drawable.sourcreamlemonpoundcakewithcherrycompote,
            R.drawable.yogurtcake, R.drawable.lemonpoundcakecookies, R.drawable.lemonpecanpoundcake, R.drawable.lemonbuttermilkpoundcakewithauntevelynslemonglaze,R.drawable.glazedlemonsupremepoundcake,
            R.drawable.easterlemonbread,R.drawable.oneegglemonpoundcake, R.drawable.rainbowcupcakes, R.drawable.rainbowcitruscake,};
    String [] foodNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        foodNames=getResources().getStringArray(R.array.food);

        gridView = (GridView)findViewById(R.id.gridViewId);

        CustomAdapter adapter = new CustomAdapter(this,foodNames, pic);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Home.this, Dessert1.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(Home.this, Dessert2.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(Home.this, Dessert3.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(Home.this, Dessert4.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(Home.this, Dessert5.class);
                    startActivity(intent);
                }

                if (i == 5) {
                    Intent intent = new Intent(Home.this, Dessert6.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(Home.this, Dessert7.class);
                    startActivity(intent);
                }
                if (i == 7) {
                    Intent intent = new Intent(Home.this, Dessert8.class);
                    startActivity(intent);
                }

                if (i == 8) {
                    Intent intent = new Intent(Home.this, Dessert9.class);
                    startActivity(intent);
                }
                if (i == 9) {
                    Intent intent = new Intent(Home.this, Dessert10.class);
                    startActivity(intent);
                }
                if (i == 10) {
                    Intent intent = new Intent(Home.this, Dessert11.class);
                    startActivity(intent);
                }

                if (i == 11) {
                    Intent intent = new Intent(Home.this, Dessert12.class);
                    startActivity(intent);
                }
                if (i == 12) {
                    Intent intent = new Intent(Home.this, Dessert13.class);
                    startActivity(intent);
                }
                if (i == 13) {
                    Intent intent = new Intent(Home.this, Dessert14.class);
                    startActivity(intent);
                }

                if (i == 14) {
                    Intent intent = new Intent(Home.this, Dessert15.class);
                    startActivity(intent);
                }
                if (i == 15) {
                    Intent intent = new Intent(Home.this, Dessert16.class);
                    startActivity(intent);
                }
                if (i == 16) {
                    Intent intent = new Intent(Home.this, Dessert17.class);
                    startActivity(intent);
                }

                if (i == 17) {
                    Intent intent = new Intent(Home.this, Dessert18.class);
                    startActivity(intent);
                }
                if (i == 18) {
                    Intent intent = new Intent(Home.this, Dessert19.class);
                    startActivity(intent);
                }
                if (i == 19) {
                    Intent intent = new Intent(Home.this, Dessert20.class);
                    startActivity(intent);
                }

                if (i == 20) {
                    Intent intent = new Intent(Home.this, Dessert21.class);
                    startActivity(intent);
                }
                if (i == 21) {
                    Intent intent = new Intent(Home.this, Dessert22.class);
                    startActivity(intent);
                }
                if (i == 22) {
                    Intent intent = new Intent(Home.this, Dessert23.class);
                    startActivity(intent);
                }

                if (i == 23) {
                    Intent intent = new Intent(Home.this, Dessert24.class);
                    startActivity(intent);
                }
                if (i == 24) {
                    Intent intent = new Intent(Home.this, Dessert25.class);
                    startActivity(intent);
                }
                if (i == 25) {
                    Intent intent = new Intent(Home.this, Dessert26.class);
                    startActivity(intent);
                }
                if (i == 26) {
                    Intent intent = new Intent(Home.this, Dessert27.class);
                    startActivity(intent);
                }

                if (i == 27) {
                    Intent intent = new Intent(Home.this, Dessert28.class);
                    startActivity(intent);
                }
                if (i == 28) {
                    Intent intent = new Intent(Home.this, Dessert29.class);
                    startActivity(intent);
                }
                if (i == 29) {
                    Intent intent = new Intent(Home.this, Dessert30.class);
                    startActivity(intent);
                }

                if (i == 30) {
                    Intent intent = new Intent(Home.this, Dessert31.class);
                    startActivity(intent);
                }
                if (i == 31) {
                    Intent intent = new Intent(Home.this, Dessert32.class);
                    startActivity(intent);
                }
                if (i == 32) {
                    Intent intent = new Intent(Home.this, Dessert33.class);
                    startActivity(intent);
                }

                if (i == 33) {
                    Intent intent = new Intent(Home.this, Dessert34.class);
                    startActivity(intent);
                }
                if (i == 34) {
                    Intent intent = new Intent(Home.this, Dessert35.class);
                    startActivity(intent);
                }
                if (i == 35) {
                    Intent intent = new Intent(Home.this, Dessert36.class);
                    startActivity(intent);
                }

                if (i == 36) {
                    Intent intent = new Intent(Home.this, Dessert37.class);
                    startActivity(intent);
                }
                if (i == 37) {
                    Intent intent = new Intent(Home.this, Dessert38.class);
                    startActivity(intent);
                }
                if (i == 38) {
                    Intent intent = new Intent(Home.this, Dessert39.class);
                    startActivity(intent);
                }

                if (i == 39) {
                    Intent intent = new Intent(Home.this, Dessert40.class);
                    startActivity(intent);
                }
                if (i == 40) {
                    Intent intent = new Intent(Home.this, Dessert41.class);
                    startActivity(intent);
                }
                if (i == 41) {
                    Intent intent = new Intent(Home.this, Dessert42.class);
                    startActivity(intent);
                }

                if (i == 42) {
                    Intent intent = new Intent(Home.this, Dessert43.class);
                    startActivity(intent);
                }
                if (i == 43) {
                    Intent intent = new Intent(Home.this, Dessert44.class);
                    startActivity(intent);
                }
                if (i == 44) {
                    Intent intent = new Intent(Home.this, Dessert45.class);
                    startActivity(intent);
                }

                if (i == 45) {
                    Intent intent = new Intent(Home.this, Dessert46.class);
                    startActivity(intent);
                }
                if (i == 46) {
                    Intent intent = new Intent(Home.this, Dessert47.class);
                    startActivity(intent);
                }
                if (i == 47) {
                    Intent intent = new Intent(Home.this, Dessert48.class);
                    startActivity(intent);
                }

                if (i == 48) {
                    Intent intent = new Intent(Home.this, Dessert49.class);
                    startActivity(intent);
                }
                if (i == 49) {
                    Intent intent = new Intent(Home.this, Dessert50.class);
                    startActivity(intent);
                }
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.Add:
                        startActivity(new Intent(getApplicationContext(), AddRecipe.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Home:
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
}