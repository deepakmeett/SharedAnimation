package com.example.sharedanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;

import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        cardView = findViewById(R.id.cardView);


        cardView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(imageView, "img");

                ActivityOptions options = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                }
                assert options != null;
                startActivity(intent, options.toBundle());
            }


        });


    }
}
