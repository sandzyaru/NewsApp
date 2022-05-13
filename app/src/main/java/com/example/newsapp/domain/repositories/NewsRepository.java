package com.example.newsapp.domain.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.common.Resource;
import com.example.newsapp.data.model.MainResponse;

public interface NewsRepository {
    MutableLiveData<Resource<MainResponse>> getTopNews();
    MutableLiveData<Resource<MainResponse>> getBusinessNews();
    MutableLiveData<Resource<MainResponse>> getEntertainmentNews();
    MutableLiveData<Resource<MainResponse>> getGeneralNews();
    MutableLiveData<Resource<MainResponse>> getHealthNews();
    MutableLiveData<Resource<MainResponse>> getScienceNews();
    MutableLiveData<Resource<MainResponse>> getSportNews();
    MutableLiveData<Resource<MainResponse>> getTechnologyNews();
}
