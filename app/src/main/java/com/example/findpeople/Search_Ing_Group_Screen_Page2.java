package com.example.findpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Search_Ing_Group_Screen_Page2 extends AppCompatActivity {
    ImageView mainImageViewSearch_Ing_Group_Screen_Page2;
    TextView titleSearch_Ing_Group_Screen_Page2, descriptionSearch_Ing_Group_Screen_Page2;
    String data3, data4;
    int imagesPage4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ing_group_screen_page2);

//
//        //抓 xml id
        mainImageViewSearch_Ing_Group_Screen_Page2 = findViewById(R.id.mainImageViewSearch_Ing_Group_Screen_Page2);
        titleSearch_Ing_Group_Screen_Page2 = findViewById(R.id.titleSearch_Ing_Group_Screen_Page2);
        descriptionSearch_Ing_Group_Screen_Page2 = findViewById(R.id.descriptionSearch_Ing_Group_Screen_Page2);

        getData();
        setData();
    }

    private void  getData() {
        if (getIntent().hasExtra("myImagePage4") && getIntent().hasExtra("data1Page4") && getIntent().hasExtra("data2Page4")){


            //產生資料
            data3 = getIntent().getStringExtra("data1Page4");
            data4 = getIntent().getStringExtra("data2Page4");
            imagesPage4 = getIntent().getIntExtra("myImagePage4", 1);

        }else{
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData(){

        //輸出版面
        titleSearch_Ing_Group_Screen_Page2.setText(data3);
        descriptionSearch_Ing_Group_Screen_Page2.setText(data4);
        mainImageViewSearch_Ing_Group_Screen_Page2.setImageResource(imagesPage4);
    }

}