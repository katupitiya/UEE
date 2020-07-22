package com.example.user.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static com.example.user.myapplication.R.string.requird;

public class PaymentPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    databaseHelper myDb;
    Button submit;
    EditText Name,Pno, P_N_no,Email;
    TextView Amount;
    EditText cvv,cno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();

        setContentView(R.layout.activity_payment_page);
        myDb=new databaseHelper(this);
        Name=(EditText)findViewById(R.id.editText9);
        Pno=(EditText)findViewById(R.id.editText4);
        P_N_no=(EditText)findViewById(R.id.editText5);
        Email=(EditText)findViewById(R.id.editText6);
        cno=(EditText)findViewById(R.id.editText7);
        cvv=(EditText)findViewById(R.id.editText8);
        submit=(Button) findViewById(R.id.button);
        Amount=(TextView) findViewById(R.id.textView14);

        Log.d("instance",Name.getText().toString());
      // viewAll();
       // insertdata();
        Amount.setText(" AMOUNT                    RS.200/=");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();

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
        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("instance","jjjjjjjjjjjjjjjj");
            }
        });*/
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
        AlertDialog.Builder nbuilder=new AlertDialog.Builder(PaymentPage.this);
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

 public void insertdata(){

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean IsinsertData=myDb.insertData(Name.getText().toString(),Pno.getText().toString(),P_N_no.getText().toString(),Email.getText().toString(),Amount.getText().toString());
                if(IsinsertData = true)
                    Toast.makeText(PaymentPage.this,"Inserted payment values",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(PaymentPage.this," not inserted",Toast.LENGTH_LONG).show();
            }
        });

  }


    public void popup() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( Name.getText().toString().isEmpty()||Pno.getText().toString().isEmpty()||P_N_no.getText().toString().isEmpty()||Email.getText().toString().isEmpty()) {
                    Name.setError(((getString( R.string.requird))));
                    Pno.setError(((getString( R.string.requird))));
                    P_N_no.setError(((getString( R.string.requird))));
                    Email.setError(((getString( R.string.requird))));
                }
                if (cno.getText().toString().isEmpty() || cvv.getText().toString().isEmpty()) {
                    cno.setError(((getString( R.string.cno_val))));
                    cvv.setError(((getString( R.string.cvv_val))));
                }

                //submit.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                else {

                    insertdata();
                    //insertdata();
                    AlertDialog.Builder builder = new AlertDialog.Builder(PaymentPage.this);
                    // View view;
                    view = LayoutInflater.from(PaymentPage.this).inflate(R.layout.custom_layout, null);
                    TextView title = (TextView) view.findViewById(R.id.title);
                    ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);
                    title.setText("Payment Successful!");
                    imageButton.setImageResource(R.drawable.payment);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ClickMe();
                        }
                    });
                /*builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Never Mind!", Toast.LENGTH_SHORT).show();
                    }*/

                   builder.setView(view);
                    builder.show();
                }
            }
        });

   }

    public void ClickMe(){
        Intent intent=new Intent(this,SearchPage2.class);
        startActivity(intent);
    }


    public void viewAll(){
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Cursor res = myDb.getAllDatamy(   );
                        if(res.getCount() == 0){
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            // buffer.append("name"+res.getString(0)+"\n");
                            buffer.append(""+res.getString(1)+"\n");
                            //t.setText(res.getString(1));
                            //  buffer.append(""+res.getString(2)+"\n");
                        }


                        showmessage("data",buffer.toString());



                    }
                }
        );
    }

    public void showmessage(String title,String message) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
