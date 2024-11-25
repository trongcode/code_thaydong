package com.btec.fpt.appquanlichitieu;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddTransactionExpenseActivity extends AppCompatActivity {

    private Button btn_date;
    private final Calendar calendar = Calendar.getInstance();
    private EditText etTransactionName, etAmount, etDescription;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction_expense);
        getWindow().setStatusBarColor(ContextCompat.getColor(AddTransactionExpenseActivity.this, R.color.bar));

        etTransactionName = findViewById(R.id.et_transaction_name);
        etAmount = findViewById(R.id.et_amount);
        etDescription = findViewById(R.id.et_description);
        btnSave = findViewById(R.id.btn_save);
        btn_date = findViewById(R.id.date_button);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTransaction();
            }
        });

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
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
        Intent intent = new Intent(AddTransactionExpenseActivity.this, ExpenseActivity.class);
        startActivity(intent);

        // Đặt lại các trường sau khi lưu
        etTransactionName.setText("");
        etAmount.setText("");
        etDescription.setText("");
    }
    private void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy (EEE)", Locale.getDefault());
                        btn_date .setText(dateFormat.format(calendar.getTime()));
                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}
