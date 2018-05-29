package com.murat.enuygun.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bahamasoft.retrofitandrxjava.R;

public class PostViewHoleder extends RecyclerView.ViewHolder {

    TextView tvTitle,tvContent,tvAuthor;


    public PostViewHoleder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.title);
        tvContent = itemView.findViewById(R.id.content);
        tvAuthor = itemView.findViewById(R.id.auohor);


    }
}
