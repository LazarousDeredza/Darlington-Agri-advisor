package com.example.agribusinessadvisor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Mushroom extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Mushroom Production");
        setContentView(R.layout.activity_mushroom);

        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("mushroom.pdf").load();
    }
}