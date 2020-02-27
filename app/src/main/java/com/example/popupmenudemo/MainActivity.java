package com.example.popupmenudemo;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenuViolator;

import com.fullstory.FS;

public class MainActivity  extends AppCompatActivity {

    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_popup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("main",FS.getCurrentSessionURL());
                showPopup(v);
            }
        });
    }

    public void showPopup(View v) {
        PopupMenuViolator popup = new PopupMenuViolator(v.getContext(), v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();

        //use violator
        ListView menuLV = popup.getMenuListView();
        FS.addClass(menuLV, FS.UNMASK_CLASS);
    }

}
