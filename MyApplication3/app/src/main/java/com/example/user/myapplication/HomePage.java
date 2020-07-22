package com.example.user.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Locale;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_home_page);
        button=(Button) findViewById(R.id.button2);
        button1=(Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAct();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAct2();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void openAct()
    {
       Intent intent=new Intent(this,SearchPage.class);
        startActivity(intent);

    }

    public void openAct2()
    {
        Intent intent=new Intent(this,SearchPage2.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            selectlanguage();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_manage1) {
            Intent intent=new Intent(this,AboutUsPage.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void selectlanguage()
    {
    final String[] listiems={"English","සිංහල","தமிழ்"};
        AlertDialog.Builder nbuilder=new AlertDialog.Builder(HomePage.this);
        nbuilder.setTitle("choose language");
        nbuilder.setSingleChoiceItems(listiems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0)
                {
                    setLocale("en");
                    recreate();

                }
                if(i==1)
                {
                    setLocale("si");
                    recreate();

                }
                if(i==2)
                {
                    setLocale("ta");
                    recreate();

                }

                dialogInterface.dismiss();
            }
        });
AlertDialog ndialog=nbuilder.create();
ndialog.show();

    }

private void setLocale(String language)
{

    Locale locale=new Locale(language);
    Configuration config=new Configuration();
    config.locale=locale;
    getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
    SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
    editor.putString("MY_LANGUAGE",language);
    editor.apply();




}
public void loadLocale(){

        SharedPreferences prefs=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String Language=prefs.getString("MY_LANGUAGE","");
        setLocale(Language);

}




}
