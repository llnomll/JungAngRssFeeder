package a816.android.soldesk.jungangrssfeeder;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-06.
 */
public class CategoryCreater {

    private static final String[] JUNG_TITLE = {"주요뉴스","인기뉴스","사회","경제","정치","IT/과학","스포츠","연예"};
    private static final String[] JUNG_URL = {
        "http://rss.joins.com/joins_homenews_list.xml",
        "http://rss.joins.com/sonagi/joins_sonagi_total_list.xml",
        "http://rss.joins.com/joins_life_list.xml",
        "http://rss.joins.com/joins_money_list.xml",
        "http://rss.joins.com/joins_politics_list.xml",
        "http://rss.joins.com/joins_it_list.xml",
        "http://rss.joins.com/news/joins_sports_etc_list.xml",
        "http://rss.joins.com/news/joins_star_etc_list.xml"
    };

    private static final String[] JOSUN_TITLE = {"주요뉴스","인기뉴스","사회","경제","정치","스포츠","연예","국제"};
    private static final String[] JOSUN_URL = {
            "http://myhome.chosun.com/rss/www_section_rss.xml",
            "http://newsplus.chosun.com/hitdata/xml/newsplus/index/index.xml",
            "http://www.chosun.com/site/data/rss/national.xml",
            "http://biz.chosun.com/site/data/rss/rss.xml",
            "http://www.chosun.com/site/data/rss/politics.xml",
            "http://www.chosun.com/site/data/rss/sports.xml",
            "http://www.chosun.com/site/data/rss/ent.xml",
            "http://www.chosun.com/site/data/rss/international.xml"
    };

    private static final String[] DONGA_TITLE = {"주요뉴스","사회","경제","정치","스포츠","연예","국제"};
    private static final String[] DONGA_URL = {
            "http://rss.donga.com/total.xml",
            "http://rss.donga.com/national.xml",
            "http://rss.donga.com/economy.xml",
            "http://rss.donga.com/politics.xml",
            "http://rss.donga.com/sportsdonga/sports_general.xml",
            "http://rss.donga.com/sportsdonga/entertainment.xml",
            "http://rss.donga.com/international.xml"
    };



    public static ArrayList<CategoryInfo> create(String company){
        ArrayList<CategoryInfo> result = new ArrayList<>();
        switch (company){
            case "cho":
                for(int i = 0; i< JOSUN_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(JOSUN_TITLE[i], JOSUN_URL[i]);
                    result.add(ci);
                }
                break;
            case "jung":
                for(int i = 0; i< JUNG_TITLE.length; i++){
                    CategoryInfo ci = new CategoryInfo(JUNG_TITLE[i], JUNG_URL[i]);
                    result.add(ci);
                }
                break;
            case "dong":
                for(int i = 0; i< DONGA_TITLE.length; i++) {
                    CategoryInfo ci = new CategoryInfo(DONGA_TITLE[i], DONGA_URL[i]);
                    result.add(ci);
                }
                break;
        }
        return result;
    }

}
