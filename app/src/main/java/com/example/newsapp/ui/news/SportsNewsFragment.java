package com.example.newsapp.ui.news;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.newsapp.base.BaseFragment;
import com.example.newsapp.common.Resource;
import com.example.newsapp.data.model.MainResponse;
import com.example.newsapp.databinding.FragmentSportsNewsBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SportsNewsFragment extends BaseFragment<FragmentSportsNewsBinding> {
    private  SportsNewsViewModel viewModel;
    private NewsAdapter adapter;
    @Override
    protected FragmentSportsNewsBinding bind() {
        return FragmentSportsNewsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity())
                .get(SportsNewsViewModel.class);
        adapter = new NewsAdapter();
        binding.recycler.setAdapter(adapter);
    }

    @Override
    protected void callRequests() {
        viewModel.getSportNews();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponse>>() {
            @Override
            public void onChanged(Resource<MainResponse> resource) {
                switch (resource.status){
                    case LOADING:{
                        //TODO Add progress
                        break;
                    }
                    case SUCCESS:{
                        adapter.setNewsList(resource.data.getArticles());
                        break;
                    }
                    case ERROR:{
                        Snackbar.make(binding.getRoot(),
                                resource.msg,
                                BaseTransientBottomBar.LENGTH_LONG);
                        break;
                    }
                }
            }
        });
    }
}
