package com.android.todolistapp.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.android.todolistapp.R;
import com.android.todolistapp.fragments.AddTaskFragment;
import com.android.todolistapp.fragments.ProfileFragment;
import com.android.todolistapp.fragments.TaskListFragment;


public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNav=(BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmnet_container,new TaskListFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_taskList:
                            selectedFragment=new TaskListFragment();
                            break;
                        case R.id.nav_addTask:
                            selectedFragment=new AddTaskFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment= new ProfileFragment();
                            break;
                    }
                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmnet_container,selectedFragment);
                    transaction.commit();

                    return true;
            }
    };
}
