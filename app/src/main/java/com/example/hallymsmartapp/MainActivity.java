package com.example.hallymsmartapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MenuItem mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //메뉴 생성하는 onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //search_menu.xml 등록
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        mSearch=menu.findItem(R.id.search);



        //menuItem을 이용해서 SearchView 변수 생성
        SearchView sv=(SearchView)mSearch.getActionView();

        //SearchView의 검색 이벤트
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //검색버튼을 눌렀을 경우
            @Override
            public boolean onQueryTextSubmit(String query) {
                TextView text = (TextView)findViewById(R.id.txtresult);
                Classroom key=new Classroom(query);
                String value=key.building();
                if(value.equals("존재하지 않습니다.")) text.setText(value);
                else {
                    int value2=key.thisFloor();
                    text.setText(query+" : "+value+" ("+value2+"층)");
                }
                return true;
            }

            //텍스트가 바뀔때마다 호출
            @Override
            public boolean onQueryTextChange(String newText) {
                TextView text = (TextView)findViewById(R.id.txtsearch);
                text.setText("검색식 : "+newText);
                return true;
            }
        });
        return true;
    }

}