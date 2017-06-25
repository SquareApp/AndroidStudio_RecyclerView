package com.squareapp.android_training;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Valentin Purrucker on 23.06.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private LayoutInflater inflator;

    private Context context;

    public ArrayList<MyObject> dataList = new ArrayList<>();


    public MyAdapter(Context context, ArrayList<MyObject> data)
    {
       inflator =  LayoutInflater.from(context);
        this.context = context;

        dataList = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

           if(viewType == 1)
           {
               View firstItemView = inflator.inflate(R.layout.recyclerview_first_item, parent, false);
               return new MyViewHolderFirstItem(firstItemView);
           }
        else
           {
                View normalView = inflator.inflate(R.layout.custom_row, parent, false);
               return new MyViewHolder(normalView);
           }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)
    {



        if(getItemViewType(position) == 1)
        {

        }
        else
        {
            Log.d("Vali", "onBindViewHolder called " + position);

            //you have to get the item on position 'position -1' 'cause the firstItem takes position 0 and only then the actual item are displayed

            ((MyViewHolder)holder).taskText.setText(dataList.get(position-1).getTask());
            ((MyViewHolder)holder).descriptionText.setText(dataList.get(position-1).getDescription());
            ((MyViewHolder)holder).dateText.setText(dataList.get(position-1).getDate());


            ((MyViewHolder)holder).taskText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context , "Item clicked at position " + position , Toast.LENGTH_SHORT).show();

                }
            });




            ((MyViewHolder)holder).cardView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {

                    Toast.makeText(context, "Share item at " + position, Toast.LENGTH_SHORT).show();

                    return false;

                }
            });

        }


    }


    @Override
    public int getItemViewType(int position)
    {
        if(position == 0)
        {
            return 1;
        }
        else
            return 2;
    }

    @Override
    public int getItemCount()
    {
        //size has to be one more than the actual size 'cause the firstItemView takes the position 0
        int size = dataList.size() +1;
        return size;
    }



    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView taskText;
        TextView descriptionText;
        TextView dateText;

        CardView cardView;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            taskText = (TextView)itemView.findViewById(R.id.taskText);
            descriptionText = (TextView)itemView.findViewById(R.id.descriptionText);
            dateText = (TextView)itemView.findViewById(R.id.dateText);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }

    class MyViewHolderFirstItem extends RecyclerView.ViewHolder
    {




        public MyViewHolderFirstItem(View itemView)
        {
            super(itemView);



        }


    }
}
