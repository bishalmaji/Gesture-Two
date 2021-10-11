package com.backupbuddy.gesturetwo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String > title;
    ArrayList<String > price;
    ArrayList<Integer > img;
    Context context;


    public ShoppingItemAdapter(ArrayList<String> title, ArrayList<String> price, ArrayList<Integer> img, Context context) {
        this.title = title;
        this.price = price;
        this.img = img;
        this.context=context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //defining two layout one for shopping items and other for title
        View view1= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_title,parent,false);
        View view2=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shoping_item,parent,false);

        if (viewType==0){
            return new ViewHolder1(view1);
        }else{
         return new ViewHolder2(view2);
     }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // checks if the view item is a shopping item or a title
        if (title.get(position).equals("Must Have")|| title.get(position).equals("Maybe")|| title.get(position).equals("Probably Not")){
            ViewHolder1 viewHolder1 = (ViewHolder1)holder;
            viewHolder1.v1title.setText(title.get(position));

        }else {
            ViewHolder2 viewHolder2= (ViewHolder2) holder;
            viewHolder2.itemName.setText(title.get(position));
            viewHolder2.descTv.setText(price.get(position));
            viewHolder2.imageView.setImageResource(img.get(position));

        }

    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    @Override
    public int getItemViewType(int position) {
        // checks if the view item is a shopping item or a title
        if (title.get(position).equals("Must Have")|| title.get(position).equals("Maybe")|| title.get(position).equals("Probably Not")){
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
        TextView itemName,descTv;
        ImageView imageView;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            itemName =itemView.findViewById(R.id.r2_title);
            imageView=itemView.findViewById(R.id.r2_img);
            descTv=itemView.findViewById(R.id.r2_desc);
        }
    }


}

