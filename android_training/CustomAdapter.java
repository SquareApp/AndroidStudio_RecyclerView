package com.squareapp.android_training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if(getItemViewType(position) == 1)
        {

        }
        else
        {
            ((NormaleViewHolder)holder).taskText.setText(dataList.get(position-1).getTask());
            ((NormaleViewHolder)holder).descriptionText.setText(dataList.get(position-1).getDescription());
            ((NormaleViewHolder)holder).dateText.setText(dataList.get(position-1).getDate());
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
        TextView dateText;


        public NormaleViewHolder(View itemView)
        {
            super(itemView);


            taskText = (TextView)itemView.findViewById(R.id.taskText);
            descriptionText = (TextView)itemView.findViewById(R.id.descriptionText);
            dateText = (TextView)itemView.findViewById(R.id.dateText);

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
