package com.example.agribusinessadvisor;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Bee extends AppCompatActivity {
    private List<The_Slide_Items_Model_Class> listItems;
    private ViewPager page;
    private TabLayout tabLayout;
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_bee);


        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("beekeeping.pdf").load();

        Log.e("status ","1");


        page = findViewById(R.id.my_pager) ;
        tabLayout = findViewById(R.id.my_tablayout);

        // Make a copy of the slides you'll be presenting.
        listItems = new ArrayList<>() ;
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.bee1,"Swarming is Natural (but probably not Desirable)"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.bee2,"Go Foundationless (Eventually)"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.bee3,"Use One Size For Brood and Honey"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.bee1,"Don't Love them to Death"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.bee2,"Inspect every 7-10 Days"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.bee3,"Two hives is better than one"));


        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(this, listItems);
        page.setAdapter(itemsPager_adapter);

        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),4000,6000);
        tabLayout.setupWithViewPager(page,true);


        Log.e("status ","2");

    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            Bee.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem()< listItems.size()-1) {
                        page.setCurrentItem(page.getCurrentItem()+1);
                    }
                    else
                        page.setCurrentItem(0);
                }
            });
        }
    }
}