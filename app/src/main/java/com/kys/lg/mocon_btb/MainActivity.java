package com.kys.lg.mocon_btb;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    BottomNavigationViewEx bottomNavigationViewEx;
    ViewPager vp;
    PagerAdapter pagerAdapter;
    FragmentManager fragmentManager;
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationViewEx=findViewById(R.id.bottom_navigationbar);
        vp=findViewById(R.id.vp);

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);



        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        vp.setAdapter(pagerAdapter);
        bottomNavigationViewEx.setupWithViewPager(vp);

        bottomNavigationViewEx.enableShiftingMode(0,true);



        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.home:
                        vp.setCurrentItem(0);
                        return true;
                    case R.id.search:
                        vp.setCurrentItem(1);
                        return true;
                    case R.id.mylibrary:
                        vp.setCurrentItem(2);
                        return true;
                    case R.id.profile:
                        vp.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });




    }
    @Override
    public void onBackPressed() {

        if(num!=3){
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"'뒤로' 가기를 한 번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
            timer.sendEmptyMessage(0);
        }
    }
    Handler timer= new Handler(){
        @Override
        public void handleMessage(Message msg) {

            timer.sendEmptyMessageDelayed(0,1000);
            if(num>0){
                --num;
            }
            else{
                num=3;

                timer.removeMessages(0);
            }
        }
    };

}

