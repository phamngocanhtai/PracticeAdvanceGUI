package com.example.practiceadvancegui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ItemAccountItem> {

    Context context;
    ArrayList<Account> accountArrayList;
    OnItemLongClickListener onItemLongClickListener;


    public AccountAdapter(Context context, ArrayList<Account> accountArrayList, OnItemLongClickListener onItemLongClickListener) {
        this.context = context;
        this.accountArrayList = accountArrayList;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    interface OnItemLongClickListener {
        void setOnUserLongClickListener(int pos);
    }

    @NonNull
    @Override
    public ItemAccountItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_item, parent,false);

        return new ItemAccountItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAccountItem holder, int position) {
        Account account = accountArrayList.get(position);
        holder.txtName.setText(account.name);
        holder.txtAddress.setText(account.address);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.setOnUserLongClickListener(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return accountArrayList.size();
    }

    class ItemAccountItem extends RecyclerView.ViewHolder{
        TextView txtName, txtAddress;

        public ItemAccountItem(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }
    }
}
