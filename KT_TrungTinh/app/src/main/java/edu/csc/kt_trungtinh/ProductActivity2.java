package edu.csc.kt_trungtinh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

import model.Product;
import model.SaleManager;

public class ProductActivity2 extends AppCompatActivity {
    public final static String EXTRA_POSITION = "position";
    EditText txtProductName,txtUnit,txtPrice;
    model.Product product;
    int position;
    Button btnOK,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product2);
        //lấy các control trên layout
        txtProductName = (EditText)findViewById(R.id.txtProductName);
        txtUnit = (EditText)findViewById(R.id.txtUnit);
        txtPrice = (EditText)findViewById(R.id.txtPrice);

        btnOK = (Button)findViewById(R.id.btnOK);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        //hiển thị lên màn hình
        Intent it = getIntent();
        position = it.getExtras().getInt(EXTRA_POSITION);

        if(position != -1) {
            product = (model.Product) SaleManager.get().getProducts().get(position);
            txtProductName.setText(product.getProductName());
            txtUnit.setText(product.getUnit());
            String s = (new DecimalFormat("#,###.##")).format(product.getPrice());
            txtPrice.setText(s);
        }
        //position = 100;
        //Khởi tạo các sản phẩm
        //SaleManager saleManager = SaleManager.get();
        //saleManager.generateProducts();
        //lấy các product từ class saleManager
        //Products.add(new Product("Bánh mì gừng", "Ổ", 10000));
        //ArrayList products = saleManager.getProducts();
        if(position == -1) {
            product = new Product();
            //int length = Products.lastIndexOf(product);
            //product = (Product) SaleManager.get().getProducts().get(-1);
            Log.d("position", "-1");
        }
        //thiết đặt sự kiện khi click vào các button
        btnOK.setOnClickListener(new ProductActivity2.OKClickListener());
        btnCancel.setOnClickListener(new ProductActivity2.CancelClickListener());
    }
    class OKClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            //lấy dữ liệu từ layout để cập nhật lại các sản phẩm trong mảng
            product.setProductName(txtProductName.getText().toString());
            product.setUnit(txtUnit.getText().toString());
            String s = txtPrice.getText().toString();
            s = s.replace(",", "");
            double price = Double.parseDouble(s);
            product.setPrice(price);
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }
    class CancelClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            // không làm gì cả và trở về màng hình trước
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
    }
}