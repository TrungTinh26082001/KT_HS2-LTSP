package edu.csc.kt_trungtinh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ListViewMainActivity extends AppCompatActivity {
    Intent i;
    String ListView1, ListView2,ListView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("KT SỐ 3");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                i = new Intent(ListViewMainActivity.this, TTSVMainActivity.class);
                startActivity(i);
                break;
//            case R.id.menu2:
//                Toast.makeText(this,"Bạn vừa chọn menu 2",Toast.LENGTH_LONG).show();
//                //code xử lý khi bấm menu2
//                break;
            case R.id.menu3:
                i = new Intent(ListViewMainActivity.this, MainActivity_KT3.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu4:
                i = new Intent(ListViewMainActivity.this, MainActivity_KT4.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Listview1(View view) {
        i = new Intent(ListViewMainActivity.this, ListView1.class);
        startActivity(i);
    }

    public void Listview2(View view) {
        i = new Intent(ListViewMainActivity.this, ListView2.class);
        startActivity(i);
    }


    public void Listview4(View view) {
        i = new Intent(ListViewMainActivity.this, ListView4.class);
        startActivity(i);

    }

    public void Listview3(View view) {
        i = new Intent(ListViewMainActivity.this, ListView3.class);
        startActivity(i);

    }
}