package com.recursively.antidebug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.content.Context;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method

        Button ptrace_button = (Button)findViewById(R.id.ptrace_button);
        Button tracerpid_button = (Button)findViewById(R.id.tracerpid_button);
        Button commonport_button = (Button)findViewById(R.id.commonport_button);
        Button filedetection_button = (Button)findViewById(R.id.filedetect_button);
        Button bkpt_button = (Button)findViewById(R.id.bkpt_button);
        Button inotify_button = (Button)findViewById(R.id.inotify_button);
        Button timelatency_button = (Button)findViewById(R.id.timelatency_button);

        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        ptrace_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, stringFromPtrace(),Toast.LENGTH_LONG).show();
            }
        });

        tracerpid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, stringFromTracerPid(),Toast.LENGTH_LONG).show();
            }
        });

        commonport_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, stringFromCommonPort(),Toast.LENGTH_LONG).show();
            }
        });

        filedetection_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, stringFromFileDetection(),Toast.LENGTH_LONG).show();
            }
        });

        bkpt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, stringFromBKPT(),Toast.LENGTH_LONG).show();
            }
        });

        inotify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, stringFromInotify(),Toast.LENGTH_LONG).show();
            }
        });

        timelatency_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context, stringFromTimeLatency(),Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String stringFromPtrace();
    public native String stringFromTracerPid();
    public native String stringFromCommonPort();
    public native String stringFromFileDetection();
    public native String stringFromBKPT();
    public native String stringFromInotify();
    public native String stringFromTimeLatency();
}
