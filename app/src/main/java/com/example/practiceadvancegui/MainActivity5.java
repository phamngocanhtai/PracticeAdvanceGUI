package com.example.practiceadvancegui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    ImageView imageViewPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        imageViewPopUp = findViewById(R.id.imgPopUp);
        imageViewPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity5.this, v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.mnuAbout)
                        {
                            Toast.makeText(MainActivity5.this, "Menu About", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });

                popupMenu.inflate(R.menu.popup_menu);

                popupMenu.show();
            }

        });
    }
}