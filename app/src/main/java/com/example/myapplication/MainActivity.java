package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        layouts = new int[]{
                R.layout.slide_1,
                R.layout.slide_2,
                R.layout.slide_3,
                R.layout.slide_4
        };

        IntroAdapter introAdapter = new IntroAdapter(layouts, viewPager); // Pass viewPager
        viewPager.setAdapter(introAdapter);
    }
}
