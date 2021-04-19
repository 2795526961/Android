package com.example.recycleview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdaper extends RecyclerView.Adapter<PersonAdaper.ViewHolder> {

    private List<Person> personList;
    public PersonAdaper(List<Person> personList) {
        this.personList = personList;
    }


    //自定义点击事件需要接口回调
    private MyOnItemClickListener listener;
    private View itemView;
    private ViewHolder viewHolder;

    public  interface MyOnItemClickListener{
        void onClick(View view,int i);
    }
    public void setMyOnItemClickListener(MyOnItemClickListener listener) {
        this.listener = listener;
    }












    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemview);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull PersonAdaper.ViewHolder holder, int position) {
//        holder.id.setText(personList.get(position).setId(1));

        holder.name.setText(personList.get(position).getName());
        holder.imageView.setImageResource(personList.get(position).getImageBig());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view,position);
            }
        });




    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView imageView;
        private final TextView name;
        private final TextView id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView);
            name = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
