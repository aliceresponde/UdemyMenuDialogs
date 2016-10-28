package com.example.alice.udemymenudialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
     * inflate - Link context menues per View
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

    /**
     * AlertDialog not cancelable, with positive, negative buttons, title and message
     * Using AlertDialog.Builder
     * @param view
     */
    public void showAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog")
                .setMessage("Do you want to kill the app?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setCancelable(false);

        AlertDialog dialog = builder.create();
         dialog.show();
    }

    /**
     * User spinner Style
     * indefined tieme
     * cancelable
     * @param view
     */
    public void showSpinerProgressDialog(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("User profile");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        progressDialog.show();
    }

    /**
     * Note:  it must to be indeterminate, and show before set progress
     * @param view
     */
    public void showHorizontalProgressDialog(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("User profile");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        progressDialog.setProgress(30);
    }

    /**
     *
     * @param view
     */
    public void showCustomDialog(View view) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        Button btnAdd = (Button) dialog.findViewById(R.id.btnAdd);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Contact Added", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.setTitle("Contacts");
        dialog.setCancelable(false);
        dialog.show();

    }
}
