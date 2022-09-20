package com.example.agribusinessadvisor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ModelFarming extends AppCompatActivity {
    private List<The_Slide_Items_Model_Class> listItems;
    private ViewPager page;
    private TabLayout tabLayout;
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Model Farming");
        setContentView(R.layout.activity_model_farming);


        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("modelfarmer.pdf").load();

        Log.e("status ","1");


        page = findViewById(R.id.my_pager) ;
        tabLayout = findViewById(R.id.my_tablayout);

        // Make a copy of the slides you'll be presenting.
        listItems = new ArrayList<>() ;
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.model1,"."));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.model2,".."));



        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(this, listItems);
        page.setAdapter(itemsPager_adapter);

        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new ModelFarming.The_slide_timer(),4000,6000);
        tabLayout.setupWithViewPager(page,true);


        Log.e("status ","2");

    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            ModelFarming.this.runOnUiThread(new Runnable() {
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