package com.example.s550_encore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.ConsumerIrManager;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageButton plus;
    ImageButton minus;
    ImageButton plus1;
    ImageButton minus1;
    ImageButton  mute;
    ImageButton power;
    ImageButton frnt;
    ImageButton cen;
    ImageButton tre;
    ImageButton adjplus;
    ImageButton rear;
    ImageButton sw;
    ImageButton bass;
    ImageButton adjminus;
    ImageButton pluslight;
    ImageButton minuslight;
    ImageButton ch51;
    ImageButton ch2;
    ImageButton reset;
    ImageButton surr;
    boolean state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        pluslight = (ImageButton) findViewById(R.id.pluslight);
        minuslight = (ImageButton) findViewById(R.id.minuslight);
        ch51 = (ImageButton) findViewById(R.id.channel51);
        ch2 = (ImageButton) findViewById(R.id.channel2);
        plus = (ImageButton) findViewById(R.id.plus);
        minus = (ImageButton) findViewById(R.id.minus);
        plus1 = (ImageButton) findViewById(R.id.plus1);
        minus1 = (ImageButton) findViewById(R.id.minus1);
        mute = (ImageButton) findViewById(R.id.mute);
        power = (ImageButton) findViewById(R.id.power);
        frnt = (ImageButton) findViewById(R.id.frnt);
        cen = (ImageButton) findViewById(R.id.cen);
        tre = (ImageButton) findViewById(R.id.tre);
        adjplus = (ImageButton) findViewById(R.id.adjplus);
        rear = (ImageButton) findViewById(R.id.rear);
        sw = (ImageButton) findViewById(R.id.sw);
        bass = (ImageButton) findViewById(R.id.bass);
        adjminus = (ImageButton) findViewById(R.id.adjminus);
        reset = (ImageButton) findViewById(R.id.reset);
        surr = (ImageButton) findViewById(R.id.surr);
        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        final String errIr = "The device is not equipped with an IR port";
        final ConsumerIrManager consumerIrManager = (ConsumerIrManager) this.getSystemService(Context.CONSUMER_IR_SERVICE);
        final int frequency = 36000;
        final int vibratemilsec = 50;
        final int delaysender = 150;
        final int[] vplus = new int[]{8800,4350, 600,550, 550,550, 600,500, 550,550, 550,1650, 550,550, 550,550, 550,550, 550,1650, 550,1650, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,500, 600,500, 600,500, 600,1650, 550,550, 550,1650, 550,1650, 550,1650, 550,1650, 550,1650, 550};
        final int[] vminus = new int[]{8900,4350, 650,500, 600,500, 650,450, 650,450, 600,1550, 650,500, 650,450, 600,500, 600,1550, 650,1550, 650,1600, 600,500, 650,450, 650,1550, 600,1600, 650,1550, 600,1600, 650,1550, 650,1550, 650,450, 650,450, 650,450, 650,1550, 650,450, 650,450, 700,400, 700,450, 650,1500, 650,1600, 600,1600, 600,500, 600,1500, 700};
        final int[] mutecode = new int[]{8900,4350, 600,550, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,500, 600,500, 600,500, 600,1600, 600,500, 650,450, 650,1550, 600,1600, 600,1650, 550,1650, 550,1650, 550,550, 600,1600, 550};
        final int[] powercode = new int[]{8900,4350, 600,550, 550,550, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1650, 550,550, 550,550, 550,1650, 550,1650, 550,1650, 600,500, 600,1600, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,1650, 550,550, 550,550, 550,1650, 550,1650, 600,1600, 600,500, 600,1600, 600};
        final int[] frntCode = new int[]{8900,4350, 650,500, 600,500, 600,500, 650,450, 650,1500, 650,500, 600,500, 650,450, 650,1500, 650,1600, 600,1600, 600,500, 650,450, 650,1550, 600,1600, 600,1600, 600,1600, 600,1600, 650,1550, 650,450, 650,450, 650,450, 700,400, 650,450, 650,500, 550,550, 550,550, 550,1650, 600,1500, 700,1600, 600,1600, 600,1600, 600};
        final int[] cenCode = new int[]{8850,4400, 600,500, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,550, 550,1650, 550,1650, 550,1650, 550,1650, 550,550, 550,550, 550,1650, 550,550, 550,550, 550,550, 550,550, 600,500, 600,1600, 600,1600, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600};
        final int[] treCode = new int[]{8900,4350, 600,550, 550,550, 550,550, 550,550, 550,1650, 550,550, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1650, 550,550, 550,550, 550,1650, 550,550, 550,1650, 550,1650, 550,1650, 550,550, 550,1650, 550};
        final int[] adjPlusCode = new int[]{8900,4350, 550,550, 600,500, 650,450, 650,450, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1650, 550,1650, 550,500, 600,500, 600,1650, 550,1650, 550,1650, 550,1650, 550,1650, 550,500, 600,500, 600,500, 600,500, 600,500, 600,500, 600,500, 600,550, 550,1650, 550,1650, 550,1650, 550,1650, 550,1650, 550,1650, 550};
        final int[] adjMinusCode = new int[]{8900,4400, 600,500, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1650, 550,1650, 550,550, 550,1650, 550,550, 550,550, 550,550, 550,550, 550,550, 550,550, 550,1650, 550,550, 550,1650, 550,1650, 600,1600, 600,1600, 600,1600, 600,1600, 600};
        final int[] bassCode = new int[]{8900,4350, 600,550, 550,550, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,1600, 600,1650, 550,1650, 550,1650, 550,550, 550,1650, 550,550, 550,1650, 550,550, 550,550, 550,550, 550,550, 600,1600, 600,500, 600,1600, 600};
        final int[] swCode = new int[]{8850,4400, 600,500, 600,550, 550,550, 550,550, 550,1650, 550,550, 550,550, 550,550, 550,1650, 550,1650, 550,1650, 550,550, 600,500, 550,1650, 600,1600, 600,1600, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1650, 550};
        final int[] rearCode = new int[]{8900,4350, 650,500, 600,500, 600,500, 650,450, 650,1450, 700,500, 650,450, 650,450, 650,1500, 700,1550, 650,1550, 650,450, 650,450, 650,1500, 700,1550, 650,1600, 600,500, 600,500, 600,1500, 700,1600, 600,1600, 600,500, 600,1550, 650,500, 600,1500, 700,1600, 600,500, 600,500, 650,450, 650,1550, 600,500, 650,1550, 600};
        final int[] minusLightCode = new int[]{8850,4400, 650,500, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,1600, 600,500, 600,1600, 600,1600, 600,500, 650,450, 650,450, 650,450, 650,450, 650,1550, 650,450, 650,450, 650,1600, 600,1600, 600,1600, 600};
        final int[] plusLightCode = new int[]{8900,4350, 600,550, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,500, 650,450, 650,1550, 650,1600, 600,500, 600,1600, 550,550, 600,500, 600,1600, 550,1650, 550,550, 600,500, 600,1600, 600,500, 600,1600, 600};
        final int[] ch51Code = new int[]{8950,4300, 600,550, 550,550, 600,500, 600,500, 600,1600, 550,550, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,1600, 600,500, 600,1600, 600,1600, 600,500, 650,1550, 600,550, 600,1600, 550,550, 600,1600, 550,550, 600,500, 600,1600, 550,550, 600,1600, 550};
        final int[] ch2Code = new int[]{8900,4350, 600,500, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1650, 550,1650, 550,550, 550,550, 550,1650, 550,1650, 550,1650, 550,550, 550,550, 600,500, 600,1600, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600};
        final int[] resetCode = new int[]{8850,4400, 600,500, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1650, 550,550, 550,550, 600,1600, 600,1600, 550,1650, 550,500, 650,450, 600,500, 650,450, 650,450, 650,450, 650,450, 650,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,1600, 600,1600, 600,1600, 600,1600, 600};
        final int[] surrCode = new int[]{8900,4400, 550,550, 600,500, 600,500, 600,500, 600,1600, 600,500, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,1600, 600,1600, 600,1600, 600,1600, 600,500, 650,450, 650,450, 650,1550, 650,1550, 600,1650, 550,1650, 600,500, 600,1600, 600,1600, 600,1600, 600,500, 600,500, 600,500, 600,500, 600};
        SwitchCompat onOffSwitch = (SwitchCompat)  findViewById(R.id.on_off_switch);
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", ""+isChecked);
                state = isChecked;
            }

        });

        surr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, surrCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, resetCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, ch2Code);
//                    final Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            consumerIrManager.transmit(frequency, surrCode);
//
//                        }
//                    },50);

                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });

        ch51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, ch51Code);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        pluslight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, plusLightCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        minuslight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, minusLightCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        rear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, rearCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, swCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        bass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, bassCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        tre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, treCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        cen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, cenCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        frnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, frntCode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, powercode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(state == true) {
                        v.vibrate(vibratemilsec);
                    }
                    consumerIrManager.transmit(frequency, mutecode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        plus.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        vibro.run();
                        mHandler.postDelayed(mAction, 500);
                        Log.e("DOWN","DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        Log.e("UP","UP");
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    System.out.println("Performing action...");
                    try {
                        consumerIrManager.transmit(frequency, vplus);
                    }
                    catch(UnsupportedOperationException e)
                    {

                    }
                    mHandler.postDelayed(this, delaysender);
                }
            };

            Runnable vibro = new Runnable() {
                @Override
                public void run() {
                    Log.e("Vibrate","VIBRO");
                    Log.e("BUT","WORK");
                    try {
                        if(state == true) {
                            v.vibrate(vibratemilsec);
                        }
                        consumerIrManager.transmit(frequency, vplus);
                    }
                    catch(UnsupportedOperationException e)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                errIr, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            };

        });

        minus.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        vibro.run();
                        mHandler.postDelayed(mAction, 500);
                        Log.e("DOWN","DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        Log.e("UP","UP");
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    System.out.println("Performing action...");
                    try {
                        consumerIrManager.transmit(frequency, vminus);
                    }
                    catch(UnsupportedOperationException e)
                    {

                    }
                    mHandler.postDelayed(this, delaysender);
                }
            };

            Runnable vibro = new Runnable() {
                @Override
                public void run() {
                    Log.e("Vibrate","VIBRO");
                    Log.e("BUT","WORK");
                    try {
                        if(state == true) {
                            v.vibrate(vibratemilsec);
                        }
                        consumerIrManager.transmit(frequency, vminus);
                    }
                    catch(UnsupportedOperationException e)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                errIr, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            };

        });

        plus1.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        vibro.run();
                        mHandler.postDelayed(mAction, 500);
                        Log.e("DOWN","DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        Log.e("UP","UP");
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    System.out.println("Performing action...");
                    try {
                        consumerIrManager.transmit(frequency, vplus);
                    }
                    catch(UnsupportedOperationException e)
                    {

                    }
                    mHandler.postDelayed(this, delaysender);
                }
            };

            Runnable vibro = new Runnable() {
                @Override
                public void run() {
                    Log.e("Vibrate","VIBRO");
                    Log.e("BUT","WORK");
                    try {
                        if(state == true) {
                            v.vibrate(vibratemilsec);
                        }
                        consumerIrManager.transmit(frequency, vplus);
                    }
                    catch(UnsupportedOperationException e)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                errIr, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            };

        });

        minus1.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        vibro.run();
                        mHandler.postDelayed(mAction, 500);
                        Log.e("DOWN","DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        Log.e("UP","UP");
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    System.out.println("Performing action...");
                    try {
                        consumerIrManager.transmit(frequency, vminus);
                    }
                    catch(UnsupportedOperationException e)
                    {

                    }
                    mHandler.postDelayed(this, delaysender);
                }
            };

            Runnable vibro = new Runnable() {
                @Override
                public void run() {
                    Log.e("Vibrate","VIBRO");
                    Log.e("BUT","WORK");
                    try {
                        if(state == true) {
                            v.vibrate(vibratemilsec);
                        }
                        consumerIrManager.transmit(frequency, vminus);
                    }
                    catch(UnsupportedOperationException e)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                errIr, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            };

        });

        adjplus.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        vibro.run();
                        mHandler.postDelayed(mAction, 500);
                        Log.e("DOWN","DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        Log.e("UP","UP");
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    System.out.println("Performing action...");
                    try {
                        consumerIrManager.transmit(frequency, adjPlusCode);
                    }
                    catch(UnsupportedOperationException e)
                    {

                    }
                    mHandler.postDelayed(this, delaysender);
                }
            };

            Runnable vibro = new Runnable() {
                @Override
                public void run() {
                    Log.e("Vibrate","VIBRO");
                    Log.e("BUT","WORK");
                    try {
                        if(state == true) {
                            v.vibrate(vibratemilsec);
                        }
                        consumerIrManager.transmit(frequency, adjPlusCode);
                    }
                    catch(UnsupportedOperationException e)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                errIr, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            };

        });

        adjminus.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        vibro.run();
                        mHandler.postDelayed(mAction, 500);
                        Log.e("DOWN","DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        Log.e("UP","UP");
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    System.out.println("Performing action...");
                    try {
                        consumerIrManager.transmit(frequency, adjMinusCode);
                    }
                    catch(UnsupportedOperationException e)
                    {

                    }
                    mHandler.postDelayed(this, delaysender);
                }
            };

            Runnable vibro = new Runnable() {
                @Override
                public void run() {
                    Log.e("Vibrate","VIBRO");
                    Log.e("BUT","WORK");
                    try {
                        if(state == true) {
                            v.vibrate(vibratemilsec);
                        }
                        consumerIrManager.transmit(frequency, adjMinusCode);
                    }
                    catch(UnsupportedOperationException e)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                errIr, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            };

        });



    }
}
