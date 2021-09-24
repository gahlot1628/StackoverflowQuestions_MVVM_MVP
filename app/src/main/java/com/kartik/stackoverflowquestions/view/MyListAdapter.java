package com.kartik.stackoverflowquestions.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.kartik.stackoverflowquestions.Model.MyListData;
import com.kartik.stackoverflowquestions.R;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private List<MyListData> listdata;

    public MyListAdapter(List<MyListData> listdata){
        this.listdata=listdata;
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyListData myListData=listdata.get(position);

        holder.text_view1.setText(myListData.getTitle());
        holder.text_view2.setText(String.valueOf(myListData.getQuestion_id()));
        holder.text_view3.setText(String.valueOf(myListData.getUp_vote_count()));
        holder.constraint_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), myListData.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView text_view1;
        public TextView text_view2;
        public TextView text_view3;
        public ConstraintLayout constraint_layout;
        public ViewHolder(View itemView){
            super(itemView);
            this.text_view1=(TextView) itemView.findViewById(R.id.textView_question);
            this.text_view2=(TextView) itemView.findViewById(R.id.questionId);
            this.text_view3=(TextView) itemView.findViewById(R.id.up_vote);
            constraint_layout=(ConstraintLayout) itemView.findViewById((R.id.constraint_layout));
        }
    }

}
