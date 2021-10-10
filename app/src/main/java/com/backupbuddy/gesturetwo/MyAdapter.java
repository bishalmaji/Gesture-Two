package com.backupbuddy.gesturetwo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String > title2;
    ArrayList<String > desc2;
    ArrayList<Integer > img2;
    Context context;


    public MyAdapter(ArrayList<String> title2, ArrayList<String> desc2, ArrayList<Integer> img2, Context context) {
        this.title2 = title2;
        this.desc2 = desc2;
        this.img2 = img2;
        this.context=context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_one,parent,false);
        View view2=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_two,parent,false);
        if (viewType==0){
            return new ViewHolder1(view1);
        }else{
         return new ViewHolder2(view2);
     }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (title2.get(position).equals("Must Have")||title2.get(position).equals("Maybe")||title2.get(position).equals("Probably Not")){
            ViewHolder1 viewHolder1 = (ViewHolder1)holder;
            viewHolder1.v1title.setText(title2.get(position));

        }else {
            ViewHolder2 viewHolder2= (ViewHolder2) holder;
            viewHolder2.v2title.setText(title2.get(position));
            viewHolder2.desc.setText(desc2.get(position));
            viewHolder2.img.setImageResource(img2.get(position));

        }

    }

    @Override
    public int getItemCount() {
        return title2.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (title2.get(position).equals("Must Have")||title2.get(position).equals("Maybe")||title2.get(position).equals("Probably Not")){
            return 0;
        }else {
            return 1;
        }


    }

    class ViewHolder1 extends RecyclerView.ViewHolder{
       TextView v1title;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            v1title=itemView.findViewById(R.id.r1_title);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        TextView v2title,desc;
        ImageView img;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            v2title=itemView.findViewById(R.id.r2_title);
            img=itemView.findViewById(R.id.r2_img);
            desc=itemView.findViewById(R.id.r2_desc);
        }
    }


}

