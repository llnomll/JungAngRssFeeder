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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Vector;

public class Fragment1 extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;

    //뉴스의 title 부분을 저장하기 위한 객체 선언
    Vector<String> titlevec = new Vector<String>();

    // 뉴스의 putDate 부분 저장
    Vector<String> datevec = new Vector<String>();

    //뉴스의 descirtion 을 저장하기 위한 객체 선언
    Vector<String> descvec = new Vector<String>();

    //뉴스의 데이터들을 뽑아 오는 클래스 선언
    NewsContent newsContent = new NewsContent();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //doInBackground 메소드를 호출해줌
        newsContent.execute(null,null,null);

        //execute();
        //AsyncTask를 실행시킨다. execute()메서드에 의해 가장 먼저 호출되는
        // 메서드가 inPreExcute()이고
        // 다음으로 자동으로 호출되는 메서드가 doInBackground()이다.

        while (true) {
            try {
                Thread.sleep(1000); //1.0초마다 실행
                if(newsContent.flag == true) {
                    titlevec = newsContent.titlevec;
                    datevec = newsContent.datevec;
                    descvec = newsContent.descvec;

                    break; //반복문 종료
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }//while

        //어뎁터 클래스 생성후 타이틀 벡터를 붙임
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                       android.R.layout.simple_expandable_list_item_1,
                                       titlevec)
         */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.textitem,titlevec);

        //생성된 어뎁터를 리스트뷰에 붙임
        listView.setAdapter(adapter);

        //리스트뷰 객체를 생성


        //이벤트 부착
        listView.setOnItemClickListener(this);
        return super.onCreateView(inflater, container, savedInstanceState);
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
        String content = descvec.get(position);
        System.out.println(content);
        //새로운 화면을 띄우기 위한 클래스 작성
        Intent intent = new Intent().setClass(getActivity(),Content.class);
        //새로운 화면에 데이터를 전달
        intent.putExtra("content",content);
        //새로운 화면으로 전환
        startActivity(intent);
    }
}