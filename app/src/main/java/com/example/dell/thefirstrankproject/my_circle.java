package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/9/3.
 */
public class my_circle extends Activity {
    private String user=null;
    private ImageButton personal=null;
    private ImageButton mainPage=null;
    private ImageButton circleSearch=null;
    private ButtonListener buttonListener=null;
    private String[] names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_circle);
        getInfoFromLastActivity();
        GetMyCircleNames getName=new GetMyCircleNames();
        names=getName.getMyCircleNames(user);
        //setListView();
        SetListView listView=new SetListView();
        listView.setListView(names,this,R.id.circleName);
        setListener();
    }
    private boolean getInfoFromLastActivity(){
        Intent intent=getIntent();
        user=intent.getStringExtra("user");
        return true;
    }
//    private boolean setListView(){
//        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
//        for (int i=0;i<names.length;i++){
//            Map<String,Object> listItem=new HashMap<String,Object>();
//            listItem.put("name",names[i]);
//            listItems.add(listItem);
//        }
//        SimpleAdapter simpleAdapter= new SimpleAdapter(this,listItems,R.layout.link_people,
//                new String[]{"name"},new int[]{R.id.name});
//        ListView list=(ListView)findViewById(R.id.circleName);
//        list.setAdapter(simpleAdapter);
//        return true;
//    }
    private boolean setListener(){
        buttonListener=new ButtonListener();
        mainPage=(ImageButton)findViewById(R.id.mainPage);
        personal=(ImageButton)findViewById(R.id.personal);
        circleSearch=(ImageButton)findViewById(R.id.circleSearch);
        mainPage.setOnClickListener(buttonListener);
        personal.setOnClickListener(buttonListener);
        circleSearch.setOnClickListener(buttonListener);
        return true;
    }
    class ButtonListener implements View.OnClickListener{
        public void onClick(View v){
            if(v.getId()==R.id.mainPage){
                PageChange pageChange=new PageChange();
                pageChange.pageChange(user,my_circle.this,main_page.class);
                finish();
//                Intent intent=new Intent();
//                intent.putExtra("user",user);
//                intent.setClass(my_circle.this,main_page.class);
//                my_circle.this.startActivity(intent);
//                finish();
            }
            else if(v.getId()==R.id.personal){
                PageChange pageChange=new PageChange();
                pageChange.pageChange(user,my_circle.this,personal.class);
                finish();
//                Intent intent=new Intent();
//                intent.putExtra("user",user);
//                intent.setClass(my_circle.this,personal.class);
//                my_circle.this.startActivity(intent);
//                finish();
            }
            else if(v.getId()==R.id.circleSearch){
                PageChange pageChange=new PageChange();
                pageChange.pageChange(user,my_circle.this,circle_search.class);
//                Intent intent=new Intent();
//                intent.putExtra("user",user);
//                intent.setClass(my_circle.this,circle_search.class);
//                my_circle.this.startActivity(intent);
            }
        }
    }
}
