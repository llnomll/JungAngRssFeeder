package a816.android.soldesk.jungangrssfeeder;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;


    ArrayList<NewsListFragment> tabFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<CategoryInfo> tab_list = CategoryCreater.create(getIntent().getStringExtra("company"));


        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        for(int i=0;i<tab_list.size();i++){
            tabFragmentList.add(NewsListFragment.newNewsListFragment(tab_list.get(i).getUrl()));
            tabs.addTab(tabs.newTab().setText(tab_list.get(i).getTitle()));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, tabFragmentList.get(0)).commit();



        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = tabFragmentList.get(position);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        getSupportActionBar().hide();
    }
}

