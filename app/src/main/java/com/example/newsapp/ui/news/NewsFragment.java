package com.example.newsapp.ui.news;

import androidx.annotation.NonNull;



import com.example.newsapp.base.BaseFragment;
import com.example.newsapp.databinding.FragmentNewsBinding;
import com.example.newsapp.ui.news.view.Tabs;
import com.example.newsapp.ui.news.view.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<FragmentNewsBinding> {
    private ViewPagerAdapter adapter;
    private ArrayList<Tabs> fragments;
    @Override
    protected FragmentNewsBinding bind() {
        return FragmentNewsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void callRequests() {

    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        fragments=new ArrayList<>();
        fragments.add(new Tabs(new TopNewsFragment(),"Top News"));
        fragments.add(new Tabs(new BusinessNewsFragment(),"Business News"));
        fragments.add(new Tabs(new EntertainmentNewsFragment(),"Entertainment News"));
        fragments.add(new Tabs(new HealthNewsFragment(),"Health News"));
        fragments.add(new Tabs(new GeneralNewsFragment(),"General News"));
        fragments.add(new Tabs(new ScienceNewsFragment(),"Science News"));
        fragments.add(new Tabs(new SportsNewsFragment(),"Sports News"));
        fragments.add(new Tabs(new TechnologyNewsFragment(),"Technology News"));

        adapter=new ViewPagerAdapter(this);
        adapter.setFragments(fragments);
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragments.get(position).getNews());
            }
        }).attach();
    }
}
