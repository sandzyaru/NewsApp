package com.example.newsapp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.common.Resource;
import com.example.newsapp.data.model.MainResponse;
import com.example.newsapp.domain.repositories.NewsRepositoriesImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NewsViewModel extends ViewModel {
    private NewsRepositoriesImpl repositories;
    public LiveData<Resource<MainResponse>> liveData;
    @Inject
    public NewsViewModel(NewsRepositoriesImpl repositories) {
        this.repositories = repositories;
    }
    public  void getTopNews() {
        liveData = repositories.getTopNews();
    }
    public  void getBusinessNews() {
        liveData = repositories.getBusinessNews();
    }
    public  void getEntertainmentNews() {
        liveData = repositories.getEntertainmentNews();
    }
    public  void getGeneralNews() {
        liveData = repositories.getGeneralNews();
    }
    public  void getHealthNews() {
        liveData = repositories.getHealthNews();
    }
    public  void getScienceNews() {
        liveData = repositories.getScienceNews();
    }
    public  void getSportNews() {
        liveData = repositories.getSportNews();
    }
    public  void getTechnologyNews() {
        liveData = repositories.getTechnologyNews();
    }
}