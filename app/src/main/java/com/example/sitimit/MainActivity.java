package com.example.sitimit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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

    ViewPager pager;
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        replaceFragment(new HomeFragment());




//
//        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
//        pager = (ViewPager)findViewById()

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

//    private  void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(com.denzcoskun.imageslider.R.id.linear_layout, fragment);
//        fragmentTransaction.commit();
//
//    }
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

