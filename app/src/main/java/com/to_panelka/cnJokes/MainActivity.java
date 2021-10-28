package com.to_panelka.cnJokes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
private BottomNavigationView bottomNavigationView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bottomNavigationView = findViewById(R.id.bottom_nav_view);
    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.mn_itm_jokes,R.id.mn_itm_web).build();
    NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);
    NavController navController = navHostFragment.getNavController();
    NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
  }
}