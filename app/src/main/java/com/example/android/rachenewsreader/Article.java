package com.example.android.rachenewsreader;

public class Article {
    private String mSectionName;
    private String mTitle;

    public Article(String title, String sectionName) {
        mTitle = title;
        mSectionName = sectionName;
    }
    public String getSectionName(){
        return mSectionName;
    }
    public void setSectionName(String sectionName){
        this.mSectionName = sectionName;
    }
    public String getTitle(){
        return mTitle;
    }
    public void setTitle(String title){
        this.mTitle = title;
    }

}
