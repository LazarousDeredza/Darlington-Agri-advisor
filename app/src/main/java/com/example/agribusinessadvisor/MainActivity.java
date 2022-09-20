package com.example.agribusinessadvisor;





import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agribusinessadvisor.databinding.ActivityMainBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    FloatingActionButton profile,settings,help,logout;

    FloatingActionsMenu floatingActionsMenu;

    CardView mushroom,beekeeping,modelfarmer;

    CircleImageView imgtwitter,imgwhatsapp,imgphone,imgemail;
    TextView txttwitter,txtwhatsapp,txtphone,txtemail;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        
        imgtwitter=findViewById(R.id.imgtwitter);
        imgwhatsapp = findViewById(R.id.imgwhatsapp);
        imgphone=findViewById(R.id.imgphone);
        imgemail=findViewById(R.id.imgemail);

        txttwitter=findViewById(R.id.txttwitter);
        txtwhatsapp=findViewById(R.id.txtwhatsapp);
        txtphone=findViewById(R.id.txtphone);
        txtemail=findViewById(R.id.txtemail);
     
        setSupportActionBar(binding.appBarMain.toolbar);

        mushroom=findViewById(R.id.mushroom);
        beekeeping=findViewById(R.id.beekeeping);

        modelfarmer=findViewById(R.id.modelfarmer);



        /*binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Floating Clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        profile=(FloatingActionButton) findViewById(R.id.profile);
        settings=(FloatingActionButton) findViewById(R.id.settings);
        help=(FloatingActionButton) findViewById(R.id.help);
        logout=(FloatingActionButton) findViewById(R.id.logout);
        floatingActionsMenu=(FloatingActionsMenu) findViewById(R.id.floatingActionsMenu);



        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);








        imgtwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gototwitter();
            }
        });
        txttwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gototwitter();
            }
        });

        imgwhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendwhatsapp();
            }
        });

        txtwhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendwhatsapp();
            }
        });

        imgphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMe();
            }
        });
        txtphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMe();
            }
        });

        imgemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailme();
            }
        });

        txtemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailme();
            }
        });


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floatingActionsMenu.collapse();
                Toast.makeText(MainActivity.this, "item 3", Toast.LENGTH_SHORT).show();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floatingActionsMenu.collapse();
                Toast.makeText(MainActivity.this, "item 3", Toast.LENGTH_SHORT).show();

            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floatingActionsMenu.collapse();
                Toast.makeText(MainActivity.this, "Item 3", Toast.LENGTH_SHORT).show();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floatingActionsMenu.collapse();

                Intent intent =new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
                Toast.makeText(MainActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });


        floatingActionsMenu.collapse();



        floatingActionsMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
            //    Toast.makeText(MainActivity.this, "Expanded", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onMenuCollapsed() {

             //   Toast.makeText(MainActivity.this, "Collapsed", Toast.LENGTH_SHORT).show();
            }
        });



        mushroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  Toast.makeText(MainActivity.this, "mushroom clicked ", Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(MainActivity.this,Mushroom.class);
                startActivity(intent);
            }
        });

        beekeeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Toast.makeText(MainActivity.this, "mushroom clicked ", Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(MainActivity.this,Bee.class);
                startActivity(intent);
            }
        });





        modelfarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Toast.makeText(MainActivity.this, "mushroom clicked ", Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(MainActivity.this,ModelFarming.class);
                startActivity(intent);
            }
        });







    }

    private void emailme() {
        
        Intent emailintent=new Intent(Intent.ACTION_SEND); 
        emailintent.setType("message/rfc822");
        emailintent.putExtra(Intent.EXTRA_EMAIL,new String[]{"rimaafrika4@gmail.com"});

        
        try {
            startActivity(Intent.createChooser(emailintent,"send mail"));
        }catch (ActivityNotFoundException ex){
            Toast.makeText(this, "No app supports sending email function installed", Toast.LENGTH_SHORT).show();
        }
                
    }

    private void callMe() {
        Uri number=Uri.parse("tel:263776348601");
        Intent call =new Intent(Intent.ACTION_DIAL,number);
        startActivity(call);
    }

    private void sendwhatsapp() {
        String number ="+263776348601";
        Uri uri=Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s",number));
        Intent intent=new Intent( Intent.ACTION_VIEW);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);  
        }catch (ActivityNotFoundException ex){
            Toast.makeText(this, "Whatsapp not installed", Toast.LENGTH_SHORT).show();
        }
        
    }

    private void gototwitter() {

        String sAppLink="twitter://user?screen_name=AfrikaRima";
        String sPackage="com.twitter.android";
        String sWebLink="https://twitter.com/AfrikaRima";

        openLink(sAppLink,sPackage,sWebLink);


    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {

        try {
            //when apllication is installed
            Uri uri=Uri.parse(sAppLink);
             Intent intent=new Intent(Intent.ACTION_VIEW);
              intent.setData(uri);
              intent.setPackage(sPackage);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
        }catch (ActivityNotFoundException ex){
            //open link in browser
            Uri uri=Uri.parse(sWebLink);
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}