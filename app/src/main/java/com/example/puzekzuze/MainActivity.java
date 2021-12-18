package com.example.puzekzuze;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mClickButton3 = (Button)findViewById(R.id.refresh);
        mClickButton3.setOnClickListener(v -> {
            TextView textView = (TextView) findViewById(R.id.textViewMaxVT);
            textView.setText("hi3");
        });

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        updateText();
        SendMailsService.start(getApplicationContext());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateText();
    }

    private void updateText() {
        TextView textView = (TextView) findViewById(R.id.textViewUpdateTime);
        textView.setText("Last mail time: " + preferences.getString("lastMailTime", "never"));
    }
}