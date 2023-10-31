package com.example.timemanagement;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HobbyAdapter extends RecyclerView.Adapter<HobbyAdapter.HobbyViewHolder> {
    private List<Hobby> hobbies;
    private OnItemClickListener onItemClickListener;

    public HobbyAdapter(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public HobbyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hobby, parent, false);
        return new HobbyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HobbyViewHolder holder, int position) {
        Hobby hobby = hobbies.get(position);
        holder.hobbyName.setText(hobby.getName());
    }

    @Override
    public int getItemCount() {
        return hobbies.size();
    }

    public class HobbyViewHolder extends RecyclerView.ViewHolder {
        TextView hobbyName;

        public HobbyViewHolder(View itemView) {
            super(itemView);
            hobbyName = itemView.findViewById(R.id.hobbyName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}