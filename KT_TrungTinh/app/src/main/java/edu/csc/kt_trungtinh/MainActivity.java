package edu.csc.kt_trungtinh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView image1, image2, image3, image4, image5, image6;
    Intent i;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.out);
        image1=findViewById(R.id.imageView1);
        image2=findViewById(R.id.imageView2);
        image3=findViewById(R.id.imageView3);
        image4=findViewById(R.id.imageView4);
        image5=findViewById(R.id.imageView5);
        image6=findViewById(R.id.imageView6);
        image1.setOnClickListener(v ->{
            i=new Intent(MainActivity.this,MainActivity_KT1.class);
            startActivity(i);

        });
        image2.setOnClickListener(v ->{
            i=new Intent(MainActivity.this,MainActivity_KT2.class);
            startActivity(i);

        });
        image3.setOnClickListener(v ->{
            i=new Intent(MainActivity.this,ListViewMainActivity.class);
            startActivity(i);

        });
        image4.setOnClickListener(v ->{
            i=new Intent(MainActivity.this,MainActivity_KT4.class);
            startActivity(i);

        });
        image5.setOnClickListener(v ->{
            i=new Intent(MainActivity.this,MainActivity_KT5.class);
            startActivity(i);

        });
        image6.setOnClickListener(v ->{
            i=new Intent(MainActivity.this,MainActivity_KT6.class);
            startActivity(i);

        });
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
                i = new Intent(MainActivity.this, TTSVMainActivity.class);
                startActivity(i);
                break;
//            case R.id.menu2:
//                Toast.makeText(this,"B???n v???a ch???n menu 2", Toast.LENGTH_LONG).show();
//                //code x??? l?? khi b???m menu2
//                break;
            case R.id.menu3:
                i = new Intent(MainActivity.this, MainActivity_KT3.class);
                startActivity(i);
                //code x??? l?? khi b???m menu3
                break;
            case R.id.menu4:
                i = new Intent(MainActivity.this, MainActivity_KT4.class);
                startActivity(i);
                //code x??? l?? khi b???m menu3
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void xulyout(View view) {
        //T???o ?????i t?????ng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thi???t l???p ti??u ?????
        b.setTitle("X??c nh???n");
        b.setMessage("B???n c?? ?????ng ?? tho??t ch????ng tr??nh kh??ng?");
        // N??t Ok
        b.setPositiveButton("?????ng ??", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        //N??t Cancel
        b.setNegativeButton("Kh??ng ?????ng ??", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
//T???o dialog
        AlertDialog al = b.create();
//Hi???n th???
        al.show();
    }
}