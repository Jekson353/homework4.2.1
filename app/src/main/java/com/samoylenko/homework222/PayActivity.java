package com.samoylenko.homework222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    private String typePay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle(R.string.tittle_pay);
        setSupportActionBar(myToolbar);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Intent intent = new Intent(getApplicationContext(), NotesActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_notes, Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_main) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_main, Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_pay) {
            Intent intent = new Intent(getApplicationContext(), PayActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_pay, Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_custom_adapter) {
            Intent intent = new Intent(getApplicationContext(), CustomActivity.class);
            startActivity(intent);
            Toast.makeText(this, R.string.toast_adapter, Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputMany = mInputMoney.getText().toString();
                String inputInfo = mInputInfo.getText().toString();
                boolean bankCard = mBankCardChkBx.isChecked();
                boolean mobilePhone = mMobilePhoneChkBx.isChecked();
                boolean cashAddress = mCashAddressChkBx.isChecked();

                if (inputMany.isEmpty() | inputInfo.isEmpty()) {
                    Toast.makeText(PayActivity.this, R.string.no_input_value, Toast.LENGTH_LONG).show();
                } else {
                    if (bankCard) {
                        typePay = getString(R.string.with_bank_card);
                    } else if (mobilePhone) {
                        typePay = getString(R.string.with_mobile_phone);
                    } else if (cashAddress) {
                        typePay = getString(R.string.with_address_cash);
                    } else {
                        typePay = getString(R.string.no_type_pay);
                    }
                    int money = Integer.parseInt(inputMany);
                    String result = getString(R.string.result_pay, money, inputInfo, typePay);

                    Toast.makeText(PayActivity.this, result, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void resetCheckBoxes() {
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        mCashAddressChkBx.setChecked(true);
                        break;
                    default:
                }
            }
        }
    };
}
