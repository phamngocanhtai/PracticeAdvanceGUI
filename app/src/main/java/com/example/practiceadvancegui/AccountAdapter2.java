package com.example.practiceadvancegui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter2 extends ArrayAdapter<Account> {
    public AccountAdapter2(@NonNull Context context,  @NonNull List<Account> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_item, parent,false);

        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtAddress = convertView.findViewById(R.id.txtAddress);

        Account account = getItem(position);
        txtName.setText(account.name);
        txtAddress.setText(account.address);


        return convertView;
    }
}
