package a816.android.soldesk.jungangrssfeeder;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    NewsListFragment allNewsListFragment;
    NewsListFragment socialNewsListFragment;
    NewsListFragment politicNewsListFragment;
    NewsListFragment econimicNewsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        allNewsListFragment = NewsListFragment.newNewsListFragment("http://rss.joins.com/joins_news_list.xml");
        socialNewsListFragment = NewsListFragment.newNewsListFragment("http://rss.joins.com/joins_life_list.xml");
        politicNewsListFragment = NewsListFragment.newNewsListFragment("http://rss.joins.com/joins_politics_list.xml");
        econimicNewsListFragment = NewsListFragment.newNewsListFragment("http://rss.joins.com/joins_money_list.xml");

        getSupportFragmentManager().beginTransaction().replace(R.id.container, allNewsListFragment).commit();


        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("전체"));
        tabs.addTab(tabs.newTab().setText("사회"));
        tabs.addTab(tabs.newTab().setText("정치"));
        tabs.addTab(tabs.newTab().setText("경제"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = fragment1;
                if (position == 0) {
                    selected = allNewsListFragment;
                } else if (position == 1) {
                    selected = socialNewsListFragment;
                } else if (position == 2) {
                    selected = politicNewsListFragment;
                } else if (position == 3) {
                    selected = econimicNewsListFragment;
                }

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

