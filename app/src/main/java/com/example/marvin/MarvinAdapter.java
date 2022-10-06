package com.example.marvin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MarvinAdapter extends RecyclerView.Adapter<MarvinAdapter.ViewHolder> {

    Context context;
    List<MarvinModel> marvinModels;

    public MarvinAdapter(Context context, List<MarvinModel> marvinModels) {
        this.context = context;
        this.marvinModels = marvinModels;
    }

    @NonNull
    @Override
    public MarvinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view_cell,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MarvinAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context)
                        .load(marvinModels.get(position).getImageurl())
                                .centerCrop()
                                   .placeholder(R.drawable.marvin)
                                        .into(holder.image);

        holder.t1.setText(marvinModels.get(position).getRealname());
        holder.t2.setText(marvinModels.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context , MainActivity2.class);
                i.putExtra("imgggg",marvinModels.get(position).getImageurl());
                i.putExtra("txt1" , marvinModels.get(position).getRealname());
                i.putExtra("txt2" , marvinModels.get(position).getName());
                i.putExtra("txt3",marvinModels.get(position).getBio());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return marvinModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image ;
        TextView t1 ;
        TextView t2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_id);
            t1=itemView.findViewById(R.id.text1_id);
            t2=itemView.findViewById(R.id.text2_id);
        }
    }
}
