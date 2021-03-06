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
import android.widget.TextView;

import java.util.Locale;

public class BookingPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button b3,b2;
    TextView t1,t2,t3,t4;
    databaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new databaseHelper(this);
        loadLocale();
        setContentView(R.layout.activity_booking_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b3=(Button)findViewById(R.id.ls1) ;
        b2=(Button)findViewById(R.id.bk_s_back);
        t1 = (TextView) findViewById(R.id.textView30);
        t2 = (TextView) findViewById(R.id.textView31);
        t3 = (TextView) findViewById(R.id.textView32);
        t4 = (TextView) findViewById(R.id.textView8);

       /* String me=p1.returnt();
        t1.setText("jnjj");
        Log.d("thhhhhhhhhhy",me);*/

        t1.setText(" "+("                     "+getIntent().getStringExtra("start")+"-"+getIntent().getStringExtra("end")));
        t2.setText(" "+("                     start at -  "+getIntent().getStringExtra("starttime")));
        t3.setText(" "+("                     end at   - "+getIntent().getStringExtra("endtime")));
        t4.setText(" "+("                     price    -RS"+getIntent().getStringExtra("price")+"/="));


       /* Intent intent = new Intent(this, PaymentPage.class);
        intent.putExtra("price",t4.toString());
        startActivity(intent);*/
        //viewAll();

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               opentAct();
                payment();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opentAct2();
            }
        });

      /*  b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAct();
            }
        });*/

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

    public void openAct1()
    {
        Intent intent=new Intent(this,PaymentPage.class);
        startActivity(intent);

    }

    public void openAct()
    {
        Intent intent=new Intent(this,Public_PaymentPage.class);
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
            Intent intent=new Intent(this,HomePage.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void selectlanguage()
    {
        final String[] listiems={"English","සිංහල","தமிழ்"};
        AlertDialog.Builder nbuilder=new AlertDialog.Builder(BookingPage.this);
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


    public void onButtonClick_viewSeat1s(View view) {
//
        Intent intent2 = new Intent(getApplicationContext(), ViewSeats_S.class);
        startActivity(intent2);


    }
    public void onButtonClick_viewSeat2s(View view) {
//
       Intent intent2 = new Intent(getApplicationContext(), ViewSeats_S.class);
        startActivity(intent2);


    }
    public void onButtonClick_viewSeat3s(View view) {
//
        Intent intent2 = new Intent(getApplicationContext(), ViewSeats_S.class);
        startActivity(intent2);


    }

public void  opentAct(){
    Intent intent2 = new Intent(getApplicationContext(), ViewSeats_S.class);
    startActivity(intent2);

}

    public void  opentAct2(){
        Intent intent2 = new Intent(getApplicationContext(), SearchPage.class);
        startActivity(intent2);

    }

    public void payment(){
        Intent intent = new Intent(this,ViewSeats_S.class);
        intent.putExtra("price",t4.toString());
        startActivity(intent);
    }
}
