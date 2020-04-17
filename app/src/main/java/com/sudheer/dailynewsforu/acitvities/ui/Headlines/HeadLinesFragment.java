package com.sudheer.dailynewsforu.acitvities.ui.Headlines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sudheer.dailynewsforu.R;
import com.sudheer.dailynewsforu.adapters.HeadlinesAdapter;
import com.sudheer.dailynewsforu.models.HeadlineModel;

import java.util.List;

public class HeadLinesFragment extends Fragment {

    private RecyclerView recyclerViewHeadline;
    private HeadlinesAdapter headlinesAdapter;
    private HeadLinesViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HeadLinesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_headlines, container, false);
        //   final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.init();
      /*  homeViewModel.getHeadlinesList().observe(getViewLifecycleOwner(), new Observer<Object>() {
            @Override
            public void onChanged(List<HeadlineModel> headLinesViewModels) {

            }
        });*/
      homeViewModel.getHeadlinesList().observe(getViewLifecycleOwner(), new Observer<List<HeadlineModel.ArticlesBean>>() {
          @Override
          public void onChanged(List<HeadlineModel.ArticlesBean> headlineModels) {
              headlinesAdapter = new HeadlinesAdapter(getContext(), homeViewModel.getHeadlinesList().getValue());
              recyclerViewHeadline = root.findViewById(R.id.rec_headline_);
              RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
              recyclerViewHeadline.setLayoutManager(layoutManager);
              recyclerViewHeadline.setAdapter(headlinesAdapter);
              headlinesAdapter.notifyDataSetChanged();
          }
      });

        return root;
    }
}
