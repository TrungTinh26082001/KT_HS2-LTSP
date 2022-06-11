package edu.csc.kt_trungtinh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView2 extends AppCompatActivity {

    ListView listView;
    String []arrData2;
    Intent i;
    ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ListView 2");
        actionBar.setDisplayHomeAsUpEnabled(true);
        addControls();
        addEvents();
    }
    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView2.this, "Bạn đã chọn : "+ arrData2[position], Toast.LENGTH_SHORT).show();
            }
        });
        ;
    }

    private void addControls() {
        listView = findViewById(R.id.ListViewData2);
        arrData2=getResources().getStringArray(R.array.tinh);
        adapter2 = new ArrayAdapter<String>(ListView2.this, android.R.layout.simple_list_item_1,arrData2);
        //gán adapter cho listview
        listView.setAdapter(adapter2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                i = new Intent(ListView2.this, TTSVMainActivity.class);
                startActivity(i);
                break;
//            case R.id.menu2:
//                Toast.makeText(this, "Bạn vừa chọn menu 2", Toast.LENGTH_LONG).show();
//                //code xử lý khi bấm menu2
//                break;
            case R.id.menu3:
                i = new Intent(ListView2.this, MainActivity_KT3.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu4:
                i = new Intent(ListView2.this, MainActivity_KT4.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}