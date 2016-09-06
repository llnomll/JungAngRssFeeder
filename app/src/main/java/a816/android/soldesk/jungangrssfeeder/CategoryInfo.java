package a816.android.soldesk.jungangrssfeeder;

/**
 * Created by soldesk on 2016-09-06.
 */
public class CategoryInfo {
    private String title;
    private String url;

    public CategoryInfo(String title,String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
