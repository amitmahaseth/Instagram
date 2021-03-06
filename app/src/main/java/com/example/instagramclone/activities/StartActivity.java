 package com.example.instagramclone.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.instagramclone.R;
import com.example.instagramclone.databinding.ActivityStartBinding;
import com.example.instagramclone.fragments.HomeFragment;
import com.example.instagramclone.fragments.NotificationFragment;
import com.example.instagramclone.fragments.ProfileFragment;
import com.example.instagramclone.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StartActivity extends AppCompatActivity {
    ActivityStartBinding binding;
    private Fragment selectorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                     case R.id.nav_home:
                         selectorFragment=new HomeFragment();
                         break;

                     case R.id.nav_search:
                         selectorFragment=new SearchFragment();
                         break;

                     case R.id.nav_add:
                         selectorFragment=null;
                         startActivity(new Intent(StartActivity.this,PostActivity.class));
                         break;

                     case R.id.nav_heart:
                        selectorFragment=new NotificationFragment();
                          break;

                     case R.id.nav_profile:
                         selectorFragment=new ProfileFragment();
                         break;
            }
            if (selectorFragment!=null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectorFragment).commit();
            }

                return true;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }
}