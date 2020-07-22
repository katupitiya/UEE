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
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ChatPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText emailValidate;
    TextView textView ;
    EditText nameValidate;
    EditText msgValidate,phne;
    TextView textView1;
    TextView textView2;
    Button btn;
    db_helper myDb;

    public static final String extra_text = "com.example.tramsport_me.sxtra_text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_chat_page);
        myDb = new db_helper(this);
        emailValidate = (EditText) findViewById(R.id.txtbox_email);
        textView = (TextView) findViewById(R.id.emailValid);
        textView1 = (TextView) findViewById(R.id.nameValid);
        textView2 = (TextView) findViewById(R.id.msgValid);
        btn = (Button) findViewById(R.id.chat_btn);
        nameValidate = (EditText) findViewById(R.id.txtbox_name);
        msgValidate = (EditText) findViewById(R.id.txtbox_msg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result1 = validate();
                boolean result2 = validName();
                boolean result3 = validMsg();
                boolean result;

                if (result1 == true && result2 == true && result3 == true) {
                    //result = AddData();

                   // if (result == true) {
                        Intent intent = new Intent(ChatPage.this, ChatList.class);
                        intent.putExtra(extra_text, nameValidate.getText().toString());
                        startActivity(intent);
                    //}
                }

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

        }
        else if (id == R.id.nav_manage1) {
            Intent intent=new Intent(this,AboutUsPage.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private boolean validate(){
        String email = emailValidate.getText().toString().trim();

        if(email.isEmpty()){
            textView.setText("Field can't be empty");
            textView.setError("");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            textView.setText("Please Enter Valid Email Address");
            textView.setError("");
            return false;
        }
        else{
            textView.setText(null);
            textView.setError(null);
            return true;
        }
    }

    private boolean validName(){
        String name =  nameValidate.getText().toString();

        if(name.isEmpty()){
            textView1.setText("Field can't be empty");
            textView1.setError("");
            return false;
        }
        else {
            textView1.setText(null);
            textView1.setError(null);
            return true;
        }

    }

    public boolean validMsg(){
        String msg = msgValidate.getText().toString();


        if(msg.isEmpty()){
            textView2.setText("Field can't be empty");
            textView2.setError("");
            return false;
        }
        else {
            textView2.setText(null);
            textView2.setError(null);
            return true;
        }

    }
    public void selectlanguage()
    {
        final String[] listiems={"English","සිංහල","தமிழ்"};
        AlertDialog.Builder nbuilder=new AlertDialog.Builder(ChatPage.this);

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

    public void openAct()
    {
        Intent intent=new Intent(this,ChatList.class);
        startActivity(intent);

    }


    public boolean AddData(){
        boolean check = myDb.InsertData(nameValidate.getText().toString(),
                emailValidate.getText().toString(),phne.getText().toString(),msgValidate.getText().toString());

        if(check == true) {
            Toast.makeText(ChatPage.this, "Message Delivered", Toast.LENGTH_LONG).show();
            return true;
        }
        else {
            Toast.makeText(ChatPage.this, "Message Not Delivered", Toast.LENGTH_LONG).show();
            return false;
        }

    }


}
