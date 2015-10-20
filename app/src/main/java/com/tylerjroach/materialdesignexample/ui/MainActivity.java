package com.tylerjroach.materialdesignexample.ui;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.tylerjroach.materialdesignexample.R;
import com.tylerjroach.materialdesignexample.listener.MainListener;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, MainListener {

  @Bind(R.id.drawer_layout) DrawerLayout drawer;
  @Bind(R.id.nav_view) NavigationView navigationView;
  @Bind(R.id.header_name) TextView headerName;
  @Bind(R.id.header_username) TextView headerUsername;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    FragmentManager fragmentManager = getSupportFragmentManager();
    if (fragmentManager.findFragmentByTag(MainFragment.class.getName()) == null) {

      fragmentManager.beginTransaction()
          .replace(R.id.container, MainFragment.newInstance(), MainFragment.class.getName())
          .commit();
    }


    navigationView.setNavigationItemSelectedListener(this);

    headerName.setText("Tyler Roach");
    headerUsername.setText("@tylerjroach");

  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    return super.onOptionsItemSelected(item);
  }



  @SuppressWarnings("StatementWithEmptyBody") @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    //implement click handlers here

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override public DrawerLayout getDrawer() {
    return drawer;
  }
}
