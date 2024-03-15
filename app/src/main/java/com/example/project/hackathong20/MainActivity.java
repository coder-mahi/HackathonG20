package com.example.project.hackathong20;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{
    BottomNavigationView bottom_navigation;
    TextView profilename, header_email, loggedInStatus;
    ImageButton noticationBtn;
    DrawerLayout drawerLayout;  //maindrawer
    Toolbar toolbar;     //toolbar
    NavigationView navigationView;   //nDrawer
    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    ActionBarDrawerToggle drawerToggle;
    //header
    ImageView header_profile_icon;
    TextView emailname, header_username, header_login_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticationBtn = (ImageButton) findViewById(R.id.noticationBtn);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar); //Application name inside toolbar
        noticationBtn = (ImageButton) findViewById(R.id.noticationBtn);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar); //Application name inside toolbar

//header Details
        View header = LayoutInflater.from(getApplicationContext()).inflate(R.layout.header, null);
        navigationView.addHeaderView(header);
        navigationView.getHeaderView(R.layout.header);

        header_profile_icon = findViewById(R.id.header_profile_icon);
        header_username = findViewById(R.id.header_username);
        header_email = findViewById(R.id.header_email);
//
//        View header = navigationView.getHeaderView(0);
//
        profilename = header.findViewById(R.id.header_username);
        emailname = header.findViewById(R.id.header_email);

        String selectedUser = getIntent().getStringExtra("user");
        String getUsername = getIntent().getStringExtra("username");
        emailname.setText(getUsername);
        loggedInStatus.setText(selectedUser);
//        //profilename.setText( From Database Access the Name Of User);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

/*        navigationView.setNavigationItemSelectedListener(this);
        bottom_navigation.setBackground(null);
*/
        if (selectedUser != null) {
            if (selectedUser.equals("DOCTOR")) {
                MainActivity.this.loadFragment(new DoctorDashboardFragment());
            } else if (selectedUser.equals("PATIENT")) {
                MainActivity.this.loadFragment(new PatientDashboardFragment());
            }
        } else {
            Toast.makeText(this, "selected user is null", Toast.LENGTH_SHORT).show();
        }

//        bottom navigation
       /* bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.bottom_home_menu) {
                    if(selectedUser.equals("admin")){
                        MainActivity.this.loadFragment(new AdminDashboardFragment());
                    } else if (selectedUser.equals("staff")) {
                        MainActivity.this.loadFragment(new MentorDashboardFragment());
                    }else{
                        MainActivity.this.loadFragment(new HomeFragment());
                    }
                } else if (id == R.id.bottom_chat_menu) {
//                    MainActivity.this.loadFragment(new ChatFragment());
                    Toast.makeText(MainActivity.this, "Chat menu..!", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.bottom_profile_menu){
                    if (selectedUser.equals("admin")){
                        Bundle bundle = new Bundle();
                        bundle.putString("admin_username", Enrollment_No);
                        ProfileFragment fragobj = new ProfileFragment();
                        fragobj.setArguments(bundle);
                        MainActivity.this.loadFragment(new AdminProfileFragment());
                        Toast.makeText(MainActivity.this, "Admin Profile menu..!", Toast.LENGTH_SHORT).show();
                    }else if(selectedUser.equals("staff")||selectedUser.equals("student")){
                        //passing enrollment no to profile fragment
                        Bundle bundle = new Bundle();
                        bundle.putString("user_id", Enrollment_No);
                        ProfileFragment fragobj = new ProfileFragment();
                        fragobj.setArguments(bundle);
                        MainActivity.this.loadFragment(new ProfileFragment());
                        Toast.makeText(MainActivity.this, "Profile menu..!", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
        */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.profile_menu) {
                    Toast.makeText(MainActivity.this, "Profile menu..!", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.dashboard_menu) {
                    if (selectedUser.equals("DOCTOR")) {
                        MainActivity.this.loadFragment(new DoctorDashboardFragment());
                    } else if (selectedUser.equals("PATIENT")) {
                        MainActivity.this.loadFragment(new PatientDashboardFragment());
                    }
                } else if (id == R.id.rate_menu) {
                    Toast.makeText(MainActivity.this, "Rate menu..!", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.reset_password_menu) {
                    Toast.makeText(MainActivity.this, "You are not able to change Password..!", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.share_menu) {
                    Toast.makeText(MainActivity.this, "Share menu..!", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.logout_menu) {
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "No Value", Toast.LENGTH_SHORT).show();
                    }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        noticationBtn.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Notifications are not yet available..!", Toast.LENGTH_SHORT).show());

    }
    //     drawer navigation
//     navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
  /*  @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile_menu) {
            MainActivity.this.loadFragment(new ProfileFragment());
            Toast.makeText(MainActivity.this, "Profile menu..!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.rate_menu) {
//        MainActivity.this.loadFragment(new RateFragment());
            Toast.makeText(MainActivity.this, "Rate menu..!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.reset_password_menu) {
            Toast.makeText(MainActivity.this, "You are not able to change Password..!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.share_menu) {
//                    loadFragment(new HomeFragment());
            Toast.makeText(MainActivity.this, "Share menu..!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.logout_menu) {
            SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);
            if (sp.contains("uname")) {
                SharedPreferences.Editor editor = sp.edit();
                editor.remove("uname");
                editor.putString("msg", "Logout Successfully");
                editor.commit();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            } else {
                Toast.makeText(this, "No Value", Toast.LENGTH_SHORT).show();
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //    });
   */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //fragment loading via method
    private void loadFragment(Fragment fragment) {
        FrameLayout frameLayout = findViewById(R.id.container);
        frameLayout.removeAllViews();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.commit();
    }
//    @SuppressLint("UnsafeIntentLaunch")
//    @Override
//    public void recreate(){
//        finish();
//        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//        startActivity(getIntent());
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//    }
}
