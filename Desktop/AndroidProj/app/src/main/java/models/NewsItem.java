package models;


/*
POJO  without setters;
* */
public class NewsItem {
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;
    public NewsItem(String title, String description,
                    String url,String publishedAt){
        this.title = title;
        this.description = description;
        this.publishedAt=publishedAt;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
    public String getpublishedAt(){

        return publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }



}
