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
import android.widget.Toast;

import java.util.Locale;

public class ViewSeats_P extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    databaseHelper databaseHelper;
    int price=0;
    int clickcount = 0;
    private int bState1, bState27, bState28, bState29, bState30, bState31, bState32, bState33, bState34, bState35, bState36, bState37 = 1;
    private int bState2, bState16, bState17, bState18, bState19, bState20, bState21, bState22, bState23, bState24, bState25, bState26 = 1;
    private int bState3, bState4, bState5, bState6, bState7, bState8, bState9, bState10, bState11, bState12, bState13, bState14, bState15 = 1;
    private int bState38, bState39, bState40, bState41, bState42, bState43, bState44, bState45 = 1;

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_view_seats__p);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseHelper=new databaseHelper(this);

         b1=(Button)findViewById(R.id.Pymnt);
        final Button bs1 = (Button) findViewById(R.id.seat1);
        final Button bs2 = (Button) findViewById(R.id.seat2);
        final Button bs3 = (Button) findViewById(R.id.seat3);
        final Button bs4 = (Button) findViewById(R.id.seat4);
        final Button bs5 = (Button) findViewById(R.id.seat5);
        final Button bs6 = (Button) findViewById(R.id.seat6);
        final Button bs7 = (Button) findViewById(R.id.seat7);
        final Button bs8 = (Button) findViewById(R.id.seat8);
        final Button bs9 = (Button) findViewById(R.id.seat9);
        final Button bs10 = (Button) findViewById(R.id.seat10);
        final Button bs11 = (Button) findViewById(R.id.seat11);
        final Button bs12 = (Button) findViewById(R.id.seat12);
        final Button bs13 = (Button) findViewById(R.id.seat13);
        final Button bs14 = (Button) findViewById(R.id.seat14);
        final Button bs15 = (Button) findViewById(R.id.seat15);
        final Button bs16 = (Button) findViewById(R.id.seat16);
        final Button bs17 = (Button) findViewById(R.id.seat17);
        final Button bs18 = (Button) findViewById(R.id.seat18);
        final Button bs19 = (Button) findViewById(R.id.seat19);
        final Button bs20 = (Button) findViewById(R.id.seat20);
        final Button bs21 = (Button) findViewById(R.id.seat21);
        final Button bs22 = (Button) findViewById(R.id.seat22);
        final Button bs23 = (Button) findViewById(R.id.seat23);
        final Button bs24 = (Button) findViewById(R.id.seat24);
        final Button bs25 = (Button) findViewById(R.id.seat25);
        final Button bs26 = (Button) findViewById(R.id.seat26);
        final Button bs27 = (Button) findViewById(R.id.seat27);
        final Button bs28 = (Button) findViewById(R.id.seat28);
        final Button bs29 = (Button) findViewById(R.id.seat29);
        final Button bs30 = (Button) findViewById(R.id.seat30);
        final Button bs31 = (Button) findViewById(R.id.seat31);
        final Button bs32 = (Button) findViewById(R.id.seat32);
        final Button bs33 = (Button) findViewById(R.id.seat33);
        final Button bs34 = (Button) findViewById(R.id.seat34);
        final Button bs35 = (Button) findViewById(R.id.seat35);
        final Button bs36 = (Button) findViewById(R.id.seat36);
        final Button bs37 = (Button) findViewById(R.id.seat300);
        final Button bs38 = (Button) findViewById(R.id.seat38);
        final Button bs39 = (Button) findViewById(R.id.seat39);
        final Button bs40 = (Button) findViewById(R.id.seat40);
        final Button bs41 = (Button) findViewById(R.id.seat41);
        final Button bs42 = (Button) findViewById(R.id.seat42);
        final Button bs43 = (Button) findViewById(R.id.seat43);
        final Button bs44 = (Button) findViewById(R.id.seat44);
        final Button bs45 = (Button) findViewById(R.id.seat45);

       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payment();
            }
        });

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState1 % 2 == 0) {

                    clickcount = clickcount + 1;
                    bs1.setBackgroundColor(getResources().getColor(R.color.green));
//                    Toast.makeText(getBaseContext(), "Button background color green" + clickcount, Toast.LENGTH_SHORT).show();


                } else {
                    clickcount = clickcount - 1;
                    bs1.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background color accent" + clickcount, Toast.LENGTH_SHORT).show();

                }
                bState1++;
            }
        });
        bs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState2 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs2.setBackgroundColor(getResources().getColor(R.color.green_light2));
//                    Toast.makeText(getBaseContext(), "Button background color green" + clickcount, Toast.LENGTH_SHORT).show();


                } else {
                    clickcount = clickcount - 1;
                    bs2.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background color accent" + clickcount, Toast.LENGTH_SHORT).show();

                }
                bState2++;
            }
        });

        bs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState3 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs3.setBackgroundColor(getResources().getColor(R.color.green));
//                    Toast.makeText(getBaseContext(), "Button background color green" + clickcount, Toast.LENGTH_SHORT).show();


                } else {
                    clickcount = clickcount - 1;
                    bs3.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background color accent", Toast.LENGTH_SHORT).show();

                }
                bState3++;
            }
        });
        bs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState4 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs4.setBackgroundColor(getResources().getColor(R.color.green_light2));

//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs4.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                }
                bState4++;
            }
        });

        bs5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState5 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs5.setBackgroundColor(getResources().getColor(R.color.green_light1));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs5.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();
                }
                bState5++;
            }
        });
        bs6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState6 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs6.setBackgroundColor(getResources().getColor(R.color.green_light1));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs6.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();
                }
                bState6++;
            }
        });

        bs7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState7 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs7.setBackgroundColor(getResources().getColor(R.color.green_light1));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs7.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();
                }
                bState7++;
            }
        });

        bs8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState8 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs8.setBackgroundColor(getResources().getColor(R.color.green_light1));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs8.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();
                }
                bState8++;
            }
        });

        bs9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState9 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs9.setBackgroundColor(getResources().getColor(R.color.green_light1));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs9.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();
                }
                bState9++;
            }
        });

        bs10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState10 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs10.setBackgroundColor(getResources().getColor(R.color.green_light1));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs10.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();
                }
                bState10++;
            }
        });

        bs11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bState11 % 2 == 0) {
                    clickcount = clickcount + 1;
                    bs11.setBackgroundColor(getResources().getColor(R.color.green_light1));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();

                } else {
                    clickcount = clickcount - 1;
                    bs11.setBackgroundColor(getResources().getColor(R.color.white));
//                    Toast.makeText(getBaseContext(), "Button background" + clickcount, Toast.LENGTH_SHORT).show();
                }
                bState11++;
            }
        });


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

    public void payment(){
        Intent intent2 = new Intent(getApplicationContext(), PaymentPage.class);
        intent2.putExtra("message", clickcount);
        startActivity(intent2);
    }
    public void selectlanguage()
    {
        final String[] listiems={"English","සිංහල","தமிழ்"};
        AlertDialog.Builder nbuilder=new AlertDialog.Builder(ViewSeats_P.this);
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

    public void onButtonClick_ToPayment_sltb(View view) {

        int total=0;
        total=clickcount*price;
        String total1 = String.valueOf(total);

        boolean IsinsertData=databaseHelper.insertDataBooking(total1);
        if(IsinsertData = true)
            Toast.makeText(ViewSeats_P.this,"data inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(ViewSeats_P.this,"data not inserted",Toast.LENGTH_LONG).show();
        //  viewAll();
//
        Intent intent2 = new Intent(getApplicationContext(), ViewSeats_P.class);// to janani nangi's page
        intent2.putExtra("message", total);
        startActivity(intent2);
    }
}
