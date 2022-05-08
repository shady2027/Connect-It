package com.example.cardsdemoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cardsdemoapp.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CardContainer extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_card_container);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        FloatingActionButton fab =(FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // get a reference to the already created main layout
//                CoordinatorLayout mainLayout = (CoordinatorLayout) findViewById(R.id.card_layout);
//
//                // inflate (create) another copy of our custom layout
//                LayoutInflater inflater = getLayoutInflater();
//                View myLayout = inflater.inflate(R.layout.activity_card_container, mainLayout, false);
//
//                // make changes to our custom layout and its subviews
//                myLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
//                TextView textView = (TextView) myLayout.findViewById(R.id.textView);
//                textView.setText("New Layout");
//
//                // add our custom layout to the main layout
//                mainLayout.addView(myLayout);
//            }
//        });
    }

    public void addCard(View view) {
        // get a reference to the already created main layout
        CoordinatorLayout mainLayout = (CoordinatorLayout) findViewById(R.id.card_layout);

        // inflate (create) another copy of our custom layout
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.activity_card_container, mainLayout, false);

        // make changes to our custom layout and its subviews
        myLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        TextView textView = (TextView) myLayout.findViewById(R.id.textView);
        textView.setText("New Layout");

        // add our custom layout to the main layout
        mainLayout.addView(myLayout);
    }
}