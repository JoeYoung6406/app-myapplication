package com.example.findpeople;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Page1 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private int images[] = {R.drawable.yushan, R.drawable.jalishan, R.drawable.guguan, R.drawable.huhwanshan,
            R.drawable.baydawushan, R.drawable.namguashan, R.drawable.jalishan, R.drawable.guguan, R.drawable.huhwanshan};
    private ArrayList<String> movieList = new ArrayList<>();
    private ArrayList<String> movieList2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        movieList.add("jjo");
        movieList.add("aas");
        movieList.add("ccc");
        movieList.add("ccc");
        movieList.add("ccc");
        movieList.add("ccc");
        movieList.add("ccc");
        movieList.add("ccc");
        movieList.add("ccc");
        movieList.add("ccc");
//        movieList.add("合歡群峰ddd");
//        movieList.add("北大武山");
//        movieList.add("玉山");
//        movieList.add("谷關七雄");
//        movieList.add("合歡群峰");
//        movieList.add("北大武山");


        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");
        movieList2.add("標高 3742 公尺，中央山脈第三高峰，山姿雄偉，為台灣「五嶽」之一。");


        recyclerView = findViewById(R.id.noYetJoinTitlePage1);


        myAdapter = new MyAdapter(this, movieList, movieList2, images);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
//
            @Override
            public boolean onQueryTextChange(String newText) {
            myAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable{

        private ArrayList<String> data1, data2, arrayList1Filter;
        private int images[];
        private Context context;

        public MyAdapter(Context ct, ArrayList<String> movieList, ArrayList<String> movieList2, int img[]) {
            context = ct;
            data1 = movieList;
            data2 = movieList2;
            images = img;
            arrayList1Filter = new ArrayList<>();
            arrayList1Filter.addAll(movieList);
//            this.arrayList1Filter = new ArrayList<>(movieList);
        }

        @Override
        public Filter getFilter() {
            return mFilter;
        }

        Filter mFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                 ArrayList<String> filteredList = new ArrayList<>();
                if (constraint == null || constraint.length() == 0){
                    filteredList.addAll(arrayList1Filter);
                }else{
                    for(String movie : arrayList1Filter){
                        if (movie.toLowerCase().contains(constraint.toString().toLowerCase())){
                            filteredList.add(movie) ;
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                movieList.clear();
                movieList.addAll((Collection<? extends  String>) results.values);
                notifyDataSetChanged();
            }
        };

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private TextView myText1, myText2;
            private ImageView myImage;
            private ConstraintLayout mainLayout;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                //抓取id
                myText1 = itemView.findViewById(R.id.myText1);
                myText2 = itemView.findViewById(R.id.myText2);
                myImage = itemView.findViewById(R.id.myImageView);
                mainLayout = itemView.findViewById(R.id.mainLayout);

                /**點擊事件*/
                itemView.setOnClickListener(this);
            }
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), data1.get(getAdapterPosition())
                        , Toast.LENGTH_SHORT).show();
            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            //create出 my_row 版面
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.my_row, parent, false);
            MyViewHolder vh = new MyViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            //產生資料
            holder.myText1.setText(data1.get(position));
            holder.myText2.setText(data2.get(position));
            holder.myImage.setImageResource(images[position]);

           // 觸發mainLayout listener
            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Page2.class);
                    intent.putExtra("data1", data1.get(position));
                    intent.putExtra("data2", data2.get(position));
                    intent.putExtra("myImage", images[position]);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }

 }
