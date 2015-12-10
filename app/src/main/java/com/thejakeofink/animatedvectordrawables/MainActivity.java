package com.thejakeofink.animatedvectordrawables;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;

    boolean isUp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageView = (ImageView) findViewById(R.id.my_image_view);

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isUp = !isUp;
                Drawable d = getResources().getDrawable(isUp ? R.drawable.avd_caret_up_to_down : R.drawable.avd_caret_down_to_up, getTheme());

                myImageView.setImageDrawable(d);
                if (d instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) d).start();
                }
            }
        });

    }
}
