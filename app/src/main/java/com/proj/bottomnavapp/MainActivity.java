package com.proj.bottomnavapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.proj.bottomnavapp.fragment.chat.ChatScreen;
import com.proj.bottomnavapp.fragment.home.HomeScreen;
import com.proj.bottomnavapp.fragment.profile.ProfileScreen;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav;
    Fragment fragment ;
    FragmentTransaction transaction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();

        fragment = new HomeScreen();
        fragmentTrans(R.id.home);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                fragmentTrans(id);

                return true;
            }
        });

    }

    private void initialView() {

        nav = findViewById(R.id.bottomNav);

    }

    private void fragmentTrans( int id ){
        transaction = getSupportFragmentManager().beginTransaction();

        switch (id) {
            case R.id.home:
                fragment = new HomeScreen();
                transaction.replace(R.id.fragments_container,fragment);
                break;
            case R.id.chat:
                fragment = new ChatScreen();
                transaction.replace(R.id.fragments_container,fragment);
                break ;
            case R.id.profile:
                fragment = new ProfileScreen();
                transaction.replace(R.id.fragments_container,fragment);
                break ;

        }
        transaction.addToBackStack(null);
        transaction.commit();
    }


}