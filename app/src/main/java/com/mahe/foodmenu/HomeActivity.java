package com.mahe.foodmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu:
                Toast.makeText(this, "menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPopUpmenu(View view){
        PopupMenu menu = new PopupMenu(this,view);
        getMenuInflater().inflate(R.menu.home_menu, menu.getMenu());

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.menu:
                        startActivity(new Intent(HomeActivity.this,Home_menu.class));
                        break;
                }
                return false;
            }
        });
        menu.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Are you sure exit?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}