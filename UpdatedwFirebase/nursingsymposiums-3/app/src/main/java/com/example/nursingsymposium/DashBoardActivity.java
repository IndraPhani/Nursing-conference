package com.example.nursingsymposium;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.nursingsymposium.fragments.About;
import com.example.nursingsymposium.fragments.ConferenceFragment;
import com.example.nursingsymposium.fragments.SchduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        frameLayout=findViewById(R.id.id_frameLayout);
        bottomNavigationView=findViewById(R.id.id_bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.id_conference:
                        replacefragment(new ConferenceFragment());
                        break;
                    case R.id.id_myschedule:
                        replacefragment(new SchduleFragment());
                        break;
                    case R.id.id_about:
                        replacefragment(new About());
                        break;
                    case R.id.id_logout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(DashBoardActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });

        // default fragment
        replacefragment(new ConferenceFragment());
    }

    private void replacefragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.id_frameLayout, fragment);
        fragmentTransaction.commit();
    }


}