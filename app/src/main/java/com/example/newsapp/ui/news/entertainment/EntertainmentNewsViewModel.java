package com.example.newsapp.ui.news.entertainment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.common.Resource;
import com.example.newsapp.data.model.MainResponse;
import com.example.newsapp.domain.repositories.NewsRepositoriesImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class EntertainmentNewsViewModel extends ViewModel {
    private NewsRepositoriesImpl repositories;
    public LiveData<Resource<MainResponse>> liveData;
    @Inject
    public EntertainmentNewsViewModel(NewsRepositoriesImpl repositories) {
        this.repositories = repositories;
    }
    public  void getEntertainmentNews() {
        liveData = repositories.getEntertainmentNews();
    }

}
