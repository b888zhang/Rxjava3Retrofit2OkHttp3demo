package com.example.zb.rxjava3retrofit2okhttp3demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zb.rxjava3retrofit2okhttp3demo.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {
    private MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        Button bt=findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData() {


        presenter.userLogin("admin", "bolesoft");


    }
}
