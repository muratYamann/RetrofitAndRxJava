package com.murat.enuygun.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bahamasoft.retrofitandrxjava.R;
import com.murat.enuygun.pojo.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHoleder> {

    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHoleder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout,parent,false);


        return new PostViewHoleder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHoleder holder, int position) {

        holder.tvAuthor.setText(postList.get(position).getId().toString());
        holder.tvTitle.setText(postList.get(position).getTitle());
        holder.tvContent.setText(new StringBuilder(postList.get(position).getBody().substring(0,25)).append("....").toString());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
