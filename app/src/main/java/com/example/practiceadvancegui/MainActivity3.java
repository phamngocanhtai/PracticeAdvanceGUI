package com.example.practiceadvancegui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements AccountAdapter.OnItemLongClickListener {

    RecyclerView rvAccount;
    ArrayList<Account> accountArrayList;
    AccountAdapter accountAdapter;
    int mPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rvAccount = findViewById(R.id.rvAccount);
        accountArrayList = new ArrayList<>();
        accountArrayList.addAll(Account.GetAccounts());
        accountAdapter = new AccountAdapter(MainActivity3.this, accountArrayList, MainActivity3.this);
        rvAccount.setLayoutManager(new LinearLayoutManager(MainActivity3.this, LinearLayoutManager.VERTICAL, false));
        rvAccount.setAdapter(accountAdapter);

        registerForContextMenu(rvAccount);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mnuEdit:
                Toast.makeText(this, "Menu Edit".concat(" Pos ").concat(String.valueOf(mPos)), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuDelete:
                Toast.makeText(this, "Menu Delete".concat(" Pos ").concat(String.valueOf(mPos)), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void setOnUserLongClickListener(int pos) {
        mPos = pos;
    }
}