package a816.android.soldesk.jungangrssfeeder;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-06.
 */
public class CategoryCreater {

    private static final String[] JUNG_TITLE = {"전체","사회","경제","정치"};
    private static final String[] JUNG_URL = {
            "http://rss.joins.com/joins_news_list.xml",
        "http://rss.joins.com/joins_life_list.xml",
        "http://rss.joins.com/joins_money_list.xml",
        "http://rss.joins.com/joins_politics_list.xml"
    };



    public static ArrayList<CategoryInfo> create(String company){
        ArrayList<CategoryInfo> result = new ArrayList<>();
        switch (company){
            case "cho":

                break;
            case "jung":
                for(int i = 0; i< JUNG_TITLE.length; i++){
                    CategoryInfo ci = new CategoryInfo(JUNG_TITLE[i], JUNG_URL[i]);
                    result.add(ci);
                }
                break;
            case "dong":
                break;
        }
        return result;
    }

}
