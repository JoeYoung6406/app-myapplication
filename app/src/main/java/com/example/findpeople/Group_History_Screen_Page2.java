package com.example.findpeople;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Group_History_Screen_Page2 extends AppCompatActivity {

    ImageView mainImageViewGroup_History_Screen_Page2;
    TextView titleGroup_History_Screen_Page2, descriptionGroup_History_Screen_Page2;


    String data5, data6;
    int imagesPage6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_history_screen_page2);

        //抓 xml id
        mainImageViewGroup_History_Screen_Page2 = findViewById(R.id.mainImageViewGroup_History_Screen_Page2);
        titleGroup_History_Screen_Page2 = findViewById(R.id.titleGroup_History_Screen_Page2);
        descriptionGroup_History_Screen_Page2 = findViewById(R.id.descriptionGroup_History_Screen_Page2);

        getData();
        setData();
    }

    private void  getData() {
        if (getIntent().hasExtra("myImagePage6") && getIntent().hasExtra("data1Page6") && getIntent().hasExtra("data1Page6")){


            //產生資料
            data5 = getIntent().getStringExtra("data1Page6");
            data6 = getIntent().getStringExtra("data1Page6");
            imagesPage6 = getIntent().getIntExtra("myImagePage6", 1);

        }else{
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData(){

        //輸出版面
        titleGroup_History_Screen_Page2.setText(data5);
        descriptionGroup_History_Screen_Page2.setText(data6);
        mainImageViewGroup_History_Screen_Page2.setImageResource(imagesPage6);
    }

    public void GoBackLastPage(View view) {
        Intent intent = new Intent();
        intent.setClass(Group_History_Screen_Page2.this, Group_History_Screen.class);
        startActivity(intent);
    }


    public void GoToJoinOthers(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("離開歷史查詢？");
        alert.setMessage("確定要前往參加揪團頁面嗎？");
        alert.setPositiveButton("前往", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setClass(Group_History_Screen_Page2.this, Join_Group_Screen.class);
                startActivity(intent);
            }
        });
        alert.setNegativeButton("等等再說", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.create().show();
    }
}