package com.example.practiceadvancegui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity12 extends AppCompatActivity implements AccountAdapter.OnItemLongClickListener {

    RecyclerView rvAccount;
    ArrayList<Account> accountArrayList;
    AccountAdapter accountAdapter;
    int mPos;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        rvAccount = findViewById(R.id.rvAccount);
        accountArrayList = new ArrayList<>();
        accountArrayList.addAll(Account.GetAccounts());
        accountAdapter = new AccountAdapter(MainActivity12.this, accountArrayList, MainActivity12.this);
        rvAccount.setLayoutManager(new LinearLayoutManager(MainActivity12.this, LinearLayoutManager.VERTICAL, false));
        rvAccount.setAdapter(accountAdapter);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                accountArrayList.add(new Account("Asss", "231231"));
                accountAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void setOnUserLongClickListener(int pos) {
        mPos = pos;
    }
}