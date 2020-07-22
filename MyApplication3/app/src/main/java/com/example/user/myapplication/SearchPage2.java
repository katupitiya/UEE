package com.example.user.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SearchPage2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG="SearchPage";
    private TextView mDisplayDate;
    databaseHelper myDb;
    AutoCompleteTextView start,destination;
    EditText startt,destinationt,price;
    TextView date;
    Button button1;
    FloatingActionButton chatb;
    String t1,t2,t3,t4,t5;

    private DatePickerDialog.OnDateSetListener mDateSetListner;
    private static final String[] districts=new String[]{
            "kurunegala","kuruwita","malabe","mathale"


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();

        myDb=new databaseHelper(this);
        setContentView(R.layout.activity_search_page2);
        start=(AutoCompleteTextView)findViewById(R.id.editText5);
        destination=(AutoCompleteTextView)findViewById(R.id.editText2);
        date=(TextView)findViewById(R.id.editText);
       // startt=(EditText)findViewById(R.id.editText3);
      //  destinationt=(EditText)findViewById(R.id.editText10);
      //  price=(EditText)findViewById(R.id.editText11);




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

        button1=(Button)findViewById(R.id.button4) ;
        mDisplayDate=(TextView) findViewById(R.id.editText);
        chatb=(FloatingActionButton)findViewById(R.id.fab);

        Date c= Calendar.getInstance().getTime();
        SimpleDateFormat df=new SimpleDateFormat("M/d/yyy");
        String formattdDate=df.format(c);
        mDisplayDate.setText(formattdDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(SearchPage2.this,android.R.style.Theme_DeviceDefault_Dialog_MinWidth,mDateSetListner,year,month,day);
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListner=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet:mm/dd/yyy:"+month+"/"+day+"/"+year);
                String date=month+"/"+day+"/"+year;
                mDisplayDate.setText(date);



            }
        };
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAct();
            }
        });

        chatb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChat();
            }
        });
        String[] cou=getResources().getStringArray(R.array.cities);

        AutoCompleteTextView editText= (AutoCompleteTextView) findViewById(R.id.editText2);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cou);
        editText.setAdapter(adapter);
        AutoCompleteTextView editText1= (AutoCompleteTextView) findViewById(R.id.editText5);
        ArrayAdapter<String> adapter1 =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cou);
        editText1.setAdapter(adapter1);
        closeKeyboard();

    }
    public void closeKeyboard()
    {
        View view=this.getCurrentFocus();
        if(view!=null)
        {

            InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }


    }
    public void openChat(){
        Intent intent=new Intent(this,ChatPage.class);
        startActivity(intent);
    }
    public void openAct()
    {
       /* Intent intent=new Intent(this,BookingPage2.class);
        startActivity(intent);*/

      /* boolean IsinsertData=myDb.insertDataticket(start.getText().toString(),destination.getText().toString(),date.getText().toString(),startt.getText().toString(),destinationt.getText().toString(),price.getText().toString());
        if(IsinsertData = true)
            Toast.makeText(SearchPage2.this,"data inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(SearchPage2.this,"data not inserted",Toast.LENGTH_LONG).show();*/
        // viewAll1();
       if( start.getText().toString().isEmpty()||destination.getText().toString().isEmpty()) {
            start.setError(((getString(R.string.requird))));
            destination.setError(((getString(R.string.requird))));
        }
      else
         viewAll1();
        //viewAll1();

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
        AlertDialog.Builder nbuilder=new AlertDialog.Builder(SearchPage2.this);

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

    public void viewAll1() {


      Cursor res = myDb.getAllData(start.getText().toString(), destination.getText().toString(), date.getText().toString());
      // Cursor res = myDb.getAll();
        if (res.getCount() == 0) {
            TextView tv=(TextView)findViewById(R.id.textView40);
            tv.setVisibility(View.VISIBLE);



        } else {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                TextView tv=(TextView)findViewById(R.id.textView40);
                tv.setVisibility(View.INVISIBLE);
                // buffer.append("name"+res.getString(0)+"\n");
                buffer.append("" + res.getString(1) + "\n");
                //t.setText(res.getString(1));
                buffer.append("" + res.getString(2) + "\n");
                buffer.append("" + res.getString(3) + "\n");
                buffer.append("" + res.getString(4) + "\n");
                buffer.append("" + res.getString(5) + "\n");
                buffer.append("" + res.getString(6) + "\n");

               t1=res.getString(1);
                t2=res.getString(2);
                t3=res.getString(4);
                t4=res.getString(5);
                t5=res.getString(6);
            }
            //  b.returnme(t1,t2);

           // showmessage("data", buffer.toString());

            Intent intent = new Intent(this, BookingPage2.class);
            intent.putExtra("start", t1);
            intent.putExtra("end", t2);
            intent.putExtra("starttime", t3);
            intent.putExtra("endtime", t4);
            intent.putExtra("price", t5);
            startActivity(intent);


        }
    }


    public void showmessage(String title,String message){
        android.support.v7.app.AlertDialog.Builder builder=new android.support.v7.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
