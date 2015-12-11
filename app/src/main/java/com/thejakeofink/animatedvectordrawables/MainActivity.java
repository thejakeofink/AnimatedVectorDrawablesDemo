package com.thejakeofink.animatedvectordrawables;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        myImageView.setImageDrawable(getDirectionalDrawable());

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable d = getDirectionalDrawable();

                myImageView.setImageDrawable(d);
                if (d instanceof Animatable) {
                    ((Animatable) d).start();
                }

                isUp = !isUp;
            }
        });

    }

    private Drawable getDirectionalDrawable() {
        return getDrawable(isUp ? R.drawable.avd_caret_up_to_down : R.drawable.avd_caret_down_to_up);
    }
}
