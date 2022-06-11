package edu.csc.kt_trungtinh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import edu.csc.kt_trungtinh.adapter.SanPhamAdapter;
import model.SanPham;

public class MainActivity_KT6 extends AppCompatActivity {
    Intent i;
    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kt6);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("KT SỐ 6");
        actionBar.setDisplayHomeAsUpEnabled(true);
        addControls();
        addEvents();
        fakeData();
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamAdapter.getItem(i);
                Toast.makeText(MainActivity_KT6.this, "Bạn chọn: "+sp.getTen(), Toast.LENGTH_LONG).show();
            }
        });
        lvSanPham.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham c = sanPhamAdapter.getItem(i);
                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity_KT6.this);
                //Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý xoá không?");
                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sanPhamAdapter.remove(c);
                    }
                });
                //Nút Cancel
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                //Tạo dialog
                AlertDialog al = b.create();
                //Hiển thị
                al.show();
                return false;
            }
        });
    }
    

    private void addControls() {
        lvSanPham = findViewById(R.id.lvSanPham);
        sanPhamAdapter = new SanPhamAdapter(MainActivity_KT6.this,R.layout.item);
        lvSanPham.setAdapter(sanPhamAdapter);
    }

    private void fakeData() {
        sanPhamAdapter.add(new SanPham(R.drawable.baby_cau_vong,"Hoa Baby Cầu Vòng",88000));
        sanPhamAdapter.add(new SanPham(R.drawable.baby_tim," Hoa Baby Tím",69000));
        sanPhamAdapter.add(new SanPham(R.drawable.cam_tu_cau,"Hoa Cẩm Tú Cầu",139000));
        sanPhamAdapter.add(new SanPham(R.drawable.hoa_hong_do,"Hoa Hồng Đỏ",230000));
        sanPhamAdapter.add(new SanPham(R.drawable.hoa_hong_trang,"Hoa Hồng Trắng",120000));
        sanPhamAdapter.add(new SanPham(R.drawable.hoa_hong_vang,"Hoa Hồng Vàng",198000));
        sanPhamAdapter.add(new SanPham(R.drawable.hoa_hong_xanh,"Hoa Hồng Xanh",209000));
        sanPhamAdapter.add(new SanPham(R.drawable.hoa_ly,"Hoa Ly",200000));
        sanPhamAdapter.add(new SanPham(R.drawable.hoa_sen,"Hoa Sen",49000));
        sanPhamAdapter.add(new SanPham(R.drawable.hoa_tra,"Hoa Trà",42000));
        sanPhamAdapter.add(new SanPham(R.drawable.huong_duong,"Hoa Hướng Dương",59000));
        sanPhamAdapter.add(new SanPham(R.drawable.lan_tim,"Hoa Lan Tím",350000));
        sanPhamAdapter.add(new SanPham(R.drawable.linh_lan,"Hoa Linh Lan",100000));
        sanPhamAdapter.add(new SanPham(R.drawable.mau_don,"Hoa Mẫu Đơn",65000));
        sanPhamAdapter.add(new SanPham(R.drawable.sen_da_kim_cuong,"Hoa Sen Đá Kim Cương",30000));
        sanPhamAdapter.add(new SanPham(R.drawable.thach_thao,"Hoa Thạch Thão",65000));
        sanPhamAdapter.add(new SanPham(R.drawable.thuy_tien,"Hoa Thùy Tiên",99000));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;  case R.id.btnAdd:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}