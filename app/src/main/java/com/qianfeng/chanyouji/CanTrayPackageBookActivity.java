package com.qianfeng.chanyouji;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CanTrayPackageBookActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView text_Name;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_can_tray_package_book);
        Intent intent = getIntent();
        String name_zh_cn = intent.getStringExtra("name_Zh_cn");
        btnBack = ((Button) findViewById(R.id.btnback));
        btnBack.setOnClickListener(this);
        text_Name = ((TextView) findViewById(R.id.text_name));
        text_Name.setText(name_zh_cn+"口袋书");
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
