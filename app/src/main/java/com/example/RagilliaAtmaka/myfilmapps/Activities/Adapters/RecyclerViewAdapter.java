package com.example.RagilliaAtmaka.myfilmapps.Activities.Activities.;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.*
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ikhsannursyahbanu.myfilmapps.Activities.Model.Movie;
import com.example.ikhsannursyahbanu.myfilmapps.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Movie> mData;
    RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for glide
        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view=inflater.inflate(R.layout.movie_row_list, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(mData.get(i).getName());
        myViewHolder.tv_sinopsis.setText(mData.get(i).getSinopsis());
        myViewHolder.tv_rating.setText(mData.get(i).getRating());

        //load image from internet

        Glide.with(mContext).load(mData.get(i).getImage_url()).apply(options).into(myViewHolder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_rating;
        TextView tv_sinopsis;
        ImageView img_thumbnail;
        public MyViewHolder(View itemView){
            super(itemView);

            tv_name= itemView.findViewById(R.id.film_name);
            tv_rating = itemView.findViewById(R.id.film_rating);
            tv_sinopsis=itemView.findViewById(R.id.film_sinopsis);
            img_thumbnail=itemView.findViewById(R.id.thumbnail);
        }


    }
}
