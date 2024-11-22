package com.btec.fpt.appquanlichitieu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class AddTransactionSpendingActivity extends AppCompatActivity {

    private EditText etTransactionName, etAmount, etDescription;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        getWindow().setStatusBarColor(ContextCompat.getColor(AddTransactionSpendingActivity.this, R.color.bar));

        etTransactionName = findViewById(R.id.et_transaction_name);
        etAmount = findViewById(R.id.et_amount);
        etDescription = findViewById(R.id.et_description);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTransaction();
            }
        });
    }

    private void saveTransaction() {

        String transactionName = etTransactionName.getText().toString().trim();
        String amount = etAmount.getText().toString().trim();
        String description = etDescription.getText().toString().trim();


        if (transactionName.isEmpty() || amount.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: Thêm logic lưu trữ giao dịch vào cơ sở dữ liệu ở đây

        // Hiển thị thông báo khi lưu thành công
        Toast.makeText(this, "Giao dịch đã được lưu!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddTransactionSpendingActivity.this, ExpenseActivity.class);
        startActivity(intent);

        // Đặt lại các trường sau khi lưu
        etTransactionName.setText("");
        etAmount.setText("");
        etDescription.setText("");
    }
}
