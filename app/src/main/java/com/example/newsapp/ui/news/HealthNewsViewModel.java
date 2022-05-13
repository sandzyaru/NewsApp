package com.example.newsapp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.common.Resource;
import com.example.newsapp.data.model.MainResponse;
import com.example.newsapp.domain.repositories.NewsRepositoriesImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HealthNewsViewModel extends ViewModel {
    private NewsRepositoriesImpl repositories;
    public LiveData<Resource<MainResponse>> liveData;
    @Inject
    public HealthNewsViewModel(NewsRepositoriesImpl repositories) {
        this.repositories = repositories;
    }
    public  void getHealthNews() {
        liveData = repositories.getHealthNews();
    }

}
