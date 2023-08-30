package ca.usamayarkhan.androiddevelopmentnewsapp;

import java.util.List;

import ca.usamayarkhan.androiddevelopmentnewsapp.Models.NewsHeadlines;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
