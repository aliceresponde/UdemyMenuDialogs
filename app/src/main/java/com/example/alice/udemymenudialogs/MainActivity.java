package com.example.alice.udemymenudialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnClickMe;
    ImageView imgAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClickMe = (Button) findViewById(R.id.btnClickMe);
        imgAndroid = (ImageView) findViewById(R.id.imgViewAndroid);

        // Register views for context Menu
        registerForContextMenu(btnClickMe);
        registerForContextMenu(imgAndroid);
    }

    /**
     * Link context menues per View
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.btnClickMe:
                getMenuInflater().inflate(R.menu.btn_click_menu, menu);
                break;

            case R.id.imgViewAndroid:
                getMenuInflater().inflate(R.menu.imagev_android_menu, menu);
                break;
        }
        menu.setHeaderTitle("Select one");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    /**
     * Perform Context Menu
     *
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_android_copy:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_android_share:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case  R.id.action_clickme_delete:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case  R.id.action_clickme_safe:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * Inflate menu options
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * Perform click on menu option
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //get itmem ID
        int id = item.getItemId();
        switch (id) {
            case R.id.action_first:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_second:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_settings:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
