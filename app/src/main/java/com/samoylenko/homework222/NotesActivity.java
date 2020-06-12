package com.samoylenko.homework222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle(R.string.tittle_notes);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Intent intent = new Intent(getApplicationContext(), NotesActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_notes, Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_main) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_main, Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_pay) {
            Intent intent = new Intent(getApplicationContext(), PayActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_pay, Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_custom_adapter) {
            Intent intent = new Intent(getApplicationContext(), CustomActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_adapter, Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
