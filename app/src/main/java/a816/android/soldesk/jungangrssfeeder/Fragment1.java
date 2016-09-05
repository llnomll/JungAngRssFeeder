package a816.android.soldesk.jungangrssfeeder;

/**
 * Created by soldesk on 2016-09-05.
 */

import android.app.ListActivity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Vector;

public class Fragment1 extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    NewsListAdapter adapter;
    NewsContent newsContent = new NewsContent(new NewsContent.OnNewsParseFinishListener() {
        @Override
        public void onNewsParseFinish(ArrayList<NewsDTO> result) {
            for(int i=0;i<result.size();i++){
                Log.i("mm", "onNewsParseFinish: "+result.get(i).getTitle());
            }
            adapter.setList(result);
            adapter.notifyDataSetChanged();
            //어댑터 뉴스 리스트 최신화
        }
    });

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,null);

        //doInBackground 메소드를 호출해줌
        newsContent.execute("http://rss.donga.com/sports.xml");

        //execute();
        //AsyncTask를 실행시킨다. execute()메서드에 의해 가장 먼저 호출되는
        // 메서드가 inPreExcute()이고
        // 다음으로 자동으로 호출되는 메서드가 doInBackground()이다.


        //리스트뷰 객체를 생성
        listView = (ListView) view.findViewById(R.id.newListView);
        //어댑터 생성
        adapter = new NewsListAdapter();
        //어댑터 부착
        listView.setAdapter(adapter);
        //이벤트 부착
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }//inCreate();

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //<?> 제너릭 자료행을 스고 싶으나 실제형 인자가
        //무엇인지를 모르거나 신경쓰고 싶지 않을 때 사용

        // 클릭한 데이터를 읽어드림
//        String content = descvec.get(position);
//        System.out.println(content);
//        //새로운 화면을 띄우기 위한 클래스 작성
//        Intent intent = new Intent().setClass(getActivity(),Content.class);
//        //새로운 화면에 데이터를 전달
//        intent.putExtra("content",content);
//        //새로운 화면으로 전환
//        startActivity(intent);
    }
}