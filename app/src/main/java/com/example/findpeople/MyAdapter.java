//package com.example.findpeople;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//
//    String data1[], data2[];
//    int images[];
//    Context context;
//
//    public MyAdapter(Context ct, String s1[], String s2[], int img[]){
//        context = ct;
//        data1 = s1;
//        data2 = s2;
//        images = img;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        //create出 my_row 版面
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.my_row, parent, false);
//        MyViewHolder vh = new MyViewHolder(view);
//
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//        //產生資料
//        holder.myText1.setText(data1[position]);
//        holder.myText2.setText(data2[position]);
//        holder.myImage.setImageResource(images[position]);
//
//
//        //觸發mainLayout listener
////        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(context, Page2.class);
////                intent.putExtra("data1", data1[position]);
////                intent.putExtra("data2", data2[position]);
////                intent.putExtra("myImage", images[position]);
////                context.startActivity(intent);
////            }
////        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return images.length;
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder{
//
//        TextView myText1, myText2;
//        ImageView myImage;
//        ConstraintLayout mainLayout;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            //抓取id
//            myText1 = itemView.findViewById(R.id.myText1);
//            myText2 = itemView.findViewById(R.id.myText2);
//            myImage = itemView.findViewById(R.id.myImageView);
//            mainLayout = itemView.findViewById(R.id.mainLayout);
//        }
//    }
//}
