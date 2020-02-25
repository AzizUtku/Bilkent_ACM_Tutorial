package app.anchorapp.bilkentacm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.anchorapp.bilkentacm.fragments.ProfileFragment;
import app.anchorapp.bilkentacm.fragments.TasksFragment;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private BottomNavigationView bottomNav;

    private Fragment mCurrentFragment;

    //Fragments
    private ProfileFragment profileFragment;
    private TasksFragment tasksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.main_toolbar);
        bottomNav = findViewById(R.id.main_bottom_nav);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
                dialog.setTitle("A");
                dialog.show();
            }
        });
        //Set toolbar
        setSupportActionBar(toolbar);

        profileFragment = new ProfileFragment();
        tasksFragment = new TasksFragment();

        mCurrentFragment = tasksFragment;
        setFragment( tasksFragment,"tasks");

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.menu_nav_profile:

                        switchFragment(profileFragment, "profile");
                        break;
                    case R.id.menu_nav_tasks:
                        switchFragment(tasksFragment, "tasks");
                        break;
                }

                return true;
            }
        });


    }

    private void setFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment, tag);
        fragmentTransaction.commit();
    }

    private void switchFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            fragmentTransaction.add(R.id.main_frame, fragment,tag);
        }

        fragmentTransaction.hide(mCurrentFragment);
        fragmentTransaction.show(fragment);
        mCurrentFragment = fragment;
        fragmentTransaction.commit();
    }


}
