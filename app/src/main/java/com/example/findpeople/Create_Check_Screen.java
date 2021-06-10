package com.example.findpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class Create_Check_Screen extends AppCompatActivity {
    TextView dateShow, mountainShow, peopleShow, sayShow;
    Button goBackLastPage, goToGroupList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_check_screen);

        dateShow = findViewById(R.id.dateCheck);
        mountainShow = findViewById(R.id.mountainShow);
        peopleShow = findViewById(R.id.peopleShow);
        sayShow = findViewById(R.id.sayShow);


        showResult();
    }

    private void showResult() {


        Bundle bundle = getIntent().getExtras();
        String date = bundle.getString("date");
        String mountain = bundle.getString("mountain");
        String people = bundle.getString("people");
        String say = bundle.getString("sayText");

        dateShow.setText(date);
        mountainShow.setText(mountain);
        peopleShow.setText(people);
        sayShow.setText(say);

    }

    public void backToCreate(View view) {
        goBackLastPage = findViewById(R.id.cancelCreate);
        goBackLastPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Create_Check_Screen.this, Create_Group_Screen.class);
                startActivity(intent);
            }
        });
    }

    public void goToGroupIngList(View view) {
        goToGroupList = findViewById(R.id.submitCreate);
        goToGroupList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Create_Check_Screen.this, Search_Ing_Group_Screen.class);
                startActivity(intent);
            }
        });
    }
}


//        bundle.putString("date", date);
//                bundle.putString("mountain", mountain);
//                bundle.putString("people", people);
//                bundle.putString("sayText", sayText);