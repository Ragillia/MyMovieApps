package com.example.ikhsannursyahbanu.myfilmapps.Activities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ikhsannursyahbanu.myfilmapps.Activities.Activities.MainActivity;
import com.example.ikhsannursyahbanu.myfilmapps.Activities.Model.Movie;
import com.example.ikhsannursyahbanu.myfilmapps.MovieActivity;
import com.example.ikhsannursyahbanu.myfilmapps.R;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private List<Movie> myList;
    RequestOptions options;
    private Context mContext;



    public RvAdapter(Context mContext, List<Movie> lst) {

        this.mContext = mContext;
        this.myList = lst;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.movie_row_list, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, MovieActivity.class);
                // sending data process
                i.putExtra("name_popularity",myList.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("movie_popularity",myList.get(viewHolder.getAdapterPosition()).getPopularity());
                i.putExtra("movie_sinopsis",myList.get(viewHolder.getAdapterPosition()).getSinopsis());
                i.putExtra("movie_rating",myList.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("movie_img",myList.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);

            }
        });
        // click listener here
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_name.setText(myList.get(position).getName());
        holder.tv_rate.setText(myList.get(position).getRating());
        holder.tv_popularity.setText(myList.get(position).getPopularity());
        holder.tv_sinopsis.setText(myList.get(position).getSinopsis());

        // load image from the internet using Glide
        Glide.with(mContext).load(myList.get(position).getImage_url()).apply(options).into(holder.movie_thumbnail);

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_rate, tv_sinopsis, tv_popularity;
        ImageView movie_thumbnail;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.movie_name);
            tv_rate = itemView.findViewById(R.id.movie_rating);
            tv_sinopsis = itemView.findViewById(R.id.movie_sinopsis);
            tv_popularity = itemView.findViewById(R.id.movie_popularity);
            movie_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }


}
