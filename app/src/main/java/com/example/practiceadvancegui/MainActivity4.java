package com.example.practiceadvancegui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    ListView lsAccount;
    ArrayList<Account> accountArrayList;
    AccountAdapter2 accountAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        lsAccount = findViewById(R.id.lsAccount);
        accountArrayList = new ArrayList<>();
        accountArrayList.addAll(Account.GetAccounts());
        accountAdapter2 = new AccountAdapter2(MainActivity4.this, accountArrayList);
        lsAccount.setAdapter(accountAdapter2);

        registerForContextMenu(lsAccount);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuEdit:
                Toast.makeText(this, "mnu Edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuDelete:
                Toast.makeText(this, "Menu Delete", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }
}