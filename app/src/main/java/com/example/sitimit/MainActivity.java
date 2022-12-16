package com.example.sitimit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    int images[] = {R.drawable.kantor, R.drawable.kantor, R.drawable.kantor};
    int currentPageCunter = 0;

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SliderAdapter(images, MainActivity.this));

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length) {
                    currentPageCunter = -0;

                }
                viewPager.setCurrentItem(currentPageCunter++, true);

            }
            };


           Timer timer = new Timer();
           timer.schedule(new TimerTask() {
               @Override
               public void run() {
                   handler.post(update);
               }

           },2500,2500);



        bottomNavigation = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null ;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_kalkulator:
                        selectedFragment = new KalkulatorFragment();
                        break;
                    case R.id.nav_produk:
                        selectedFragment = new ProdukFragment();
                        break;
                    case R.id.nav_tentangKami:
                        selectedFragment = new TentangKamiFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });
    }
    public void Hitung(View view){
        Intent intent = new Intent(MainActivity.this, KalkulatorBata.class);
        startActivity(intent);

    }
//    public void backHome(){
//        Intent intent =new Intent(this, MainActivity.class);
//        startActivity(intent);
//
//    }

        }

