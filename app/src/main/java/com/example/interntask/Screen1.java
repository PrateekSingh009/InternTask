package com.example.interntask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Screen1 extends AppCompatActivity {

    Fragment fr1;
    int open = 1;
    ImageView recent,contacted,down, recentImage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
        recent = findViewById(R.id.recent);
        contacted = findViewById(R.id.contacted);
        recentImage = findViewById(R.id.RecentImage);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fr1= new Details();
        down = findViewById(R.id.down);
        ft.add(R.id.details12, fr1 , "top");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    public void jumpToScreen4(View view)
    {
        Intent intent = new Intent( Screen1.this, Screen4.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );


    }

    public void openDetails(View view)
    {



        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fr1= new Details();

        if(open == 0)
        {

            ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            ft.add(R.id.details12, fr1 , "top");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.commit();
            getSupportFragmentManager().executePendingTransactions();
            open=1;

            recent.setClickable(false);




            down.setVisibility(View.VISIBLE);
            contacted.setVisibility(View.INVISIBLE);

            int imageResource = getResources().getIdentifier(     "@drawable/path39", null, getPackageName() );
            Drawable res = getResources().getDrawable(imageResource);
            recentImage.setImageDrawable( res );

        }
        else
        {

//            ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
//            ft.add(R.id.details, fr1 , "top");
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

            Fragment frm = getSupportFragmentManager().findFragmentByTag("top");
            FragmentTransaction fragmentTransaction;
            if(frm!=null) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_out_down, R.anim.slide_in_down);
                fragmentTransaction.remove(frm);
                fragmentTransaction.commit();

            }
//           ft.setCustomAnimations(R.anim.slide_out_down, R.anim.slide_in_down);
//           ft.remove(fr1);
//           ft.commit();
           open=0;
           //recent.setClickable(true);

            recent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jumpToScreen4(v);
                }
            });
            down.setVisibility(View.INVISIBLE);
            contacted.setVisibility(View.VISIBLE);

            int imageResource = getResources().getIdentifier(     "@drawable/path246", null, getPackageName() );
            Drawable res = getResources().getDrawable(imageResource);
            recentImage.setImageDrawable( res );

        }





    }

}