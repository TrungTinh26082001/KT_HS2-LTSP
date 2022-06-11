package edu.csc.kt_trungtinh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_KT2 extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kt2);
        button=findViewById(R.id.chuyendoi);
        textView=findViewById(R.id.amlich);
        editText=findViewById(R.id.duonglich);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String []arrCan={"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
                String []arrChi={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
                int namDuong=Integer.parseInt(editText.getText().toString());
                String can=arrCan[namDuong%10];
                String chi=arrChi[namDuong%12];
                textView.setText(can+" "+chi);
            }
        });
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("KT SỐ 2");
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
                i = new Intent(MainActivity_KT2.this, TTSVMainActivity.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
//            case R.id.menu2:
//                Toast.makeText(this,"Bạn vừa chọn menu 2",Toast.LENGTH_LONG).show();
//                //code xử lý khi bấm menu2
//                break;
            case R.id.menu3:
                i = new Intent(MainActivity_KT2.this, MainActivity_KT3.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu4:
                i = new Intent(MainActivity_KT2.this, MainActivity_KT4.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

}