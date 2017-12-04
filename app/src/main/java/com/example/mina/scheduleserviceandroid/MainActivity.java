package com.example.mina.scheduleserviceandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mina.scheduleserviceandroid.utils.AlarmMangerUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStartService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartService= findViewById(R.id.btn_start_Service);
        btnStartService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AlarmMangerUtil.setAlarm(this,60000);

    }
}
