package com.backupbuddy.gesturetwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    ArrayList<String> titles;
    ArrayList<String> description;
    ArrayList<Integer> images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles = new ArrayList<>();
        description = new ArrayList<>();
        images = new ArrayList<>();


        titles.add("Must Have");
        titles.add("Maybe");
        titles.add("Probably Not");
        titles.add("School Bag");
        titles.add("Cap");
        titles.add("One Plus");
        titles.add("Watch");
        titles.add("IPhone Mobile");
        description.add("");
        description.add("");
        description.add("");
        description.add("200$");
        description.add("100$");
        description.add("400$");
        description.add("300$");
        description.add("600$");
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.bag);
        images.add(R.drawable.cap);
        images.add(R.drawable.phone1);
        images.add(R.drawable.watch);
        images.add(R.drawable.phone2);

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(titles, description, images,  this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }
    ItemTouchHelper.SimpleCallback callback=new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.START|ItemTouchHelper.END,0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            if (viewHolder.getItemViewType()!=0){
                int fromPos=viewHolder.getAdapterPosition();
                int toPos=target.getAdapterPosition();
                if (toPos!=0){
                    Collections.swap(titles,fromPos,toPos);
                    Collections.swap(description,fromPos,toPos);
                    Collections.swap(images,fromPos,toPos);
                    recyclerView.getAdapter().notifyItemMoved(fromPos,toPos);
                }

            }
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };
}