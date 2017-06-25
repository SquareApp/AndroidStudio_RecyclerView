package com.squareapp.android_training;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Valentin Purrucker on 25.06.2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {




   private ArrayList<MyObject> dataList;

    private LayoutInflater inflater;

    private Context context;

    public CustomAdapter(Context context, ArrayList<MyObject> list)
    {
        dataList = list;
        inflater = LayoutInflater.from(context);

        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if(viewType == 1)
        {
            View firstItemView = inflater.inflate(R.layout.recyclerview_first_item, parent, false);
            return new FirstItemViewHolder(firstItemView);
        }
        else
        {
            View view = inflater.inflate(R.layout.custom_row, parent, false);
            return new NormaleViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position)
    {

        int currentPosition = position -1;

        if(getItemViewType(position) == 1)
        {

        }
        else
        {
            ((NormaleViewHolder)holder).taskText.setText(dataList.get(currentPosition).getTask());
            ((NormaleViewHolder)holder).descriptionText.setText(dataList.get(currentPosition).getDescription());
           
           //Picasso loads images from web and places them into an imageview
            Picasso.with(context)
                    .load(dataList.get(currentPosition).getImageUrl())
                    .placeholder(R.drawable.ic_search_black_36dp)
                    .resize(1000,800).centerCrop()
                    .into(((NormaleViewHolder) holder).img);






        }
    }

    @Override
    public int getItemCount() {
        return dataList.size() +1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
        {
            return 1;
        }
        else
            return 2;
    }

    class NormaleViewHolder extends RecyclerView.ViewHolder
    {

        TextView taskText;
        TextView descriptionText;
        ImageView img;
        CardView cardView;


        public NormaleViewHolder(View itemView)

        {
            super(itemView);


            taskText = (TextView)itemView.findViewById(R.id.taskText);
            descriptionText = (TextView)itemView.findViewById(R.id.descriptionText);
            img = (ImageView)itemView.findViewById(R.id.urlImage);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            Log.d("ViewHolder", "load image from url");
        }
    }

    class FirstItemViewHolder extends RecyclerView.ViewHolder
    {
        public FirstItemViewHolder(View itemView)
        {
            super(itemView);
        }
    }

}
