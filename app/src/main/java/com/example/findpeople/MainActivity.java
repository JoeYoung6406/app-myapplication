package com.example.findpeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button goToNotYetPage;
    private Button goToCreateGroup;
    private Button joinGroupIng;
    private Button groupHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //參加揪團跳轉
        goToNotYetPage =findViewById(R.id.goToNotYetPage);
        goToNotYetPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Page1.class);
                startActivity(intent);
            }
        });

        //創建揪團跳轉
        goToCreateGroup = findViewById(R.id.goToCreateGroup);
        goToCreateGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Page3.class);
                startActivity(intent);
            }
        });

        //參加中揪團跳轉
        joinGroupIng = findViewById(R.id.joinGroupIng);
        joinGroupIng.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Page4.class);
                startActivity(intent);
            }
        });

        groupHistory = findViewById(R.id.groupHistory);
        groupHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Page6.class);
                startActivity(intent);
            }
        });

    }
}