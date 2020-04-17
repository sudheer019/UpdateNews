package com.sudheer.dailynewsforu.repository;

import androidx.lifecycle.MutableLiveData;

import com.sudheer.dailynewsforu.models.HeadlineModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Your name on 15/4/20.
 */
public class HeadLinesRepo {
    private static HeadLinesRepo instance;
    private ArrayList<HeadlineModel> headlineModels = new ArrayList<>();


    public static HeadLinesRepo getInstance() {
        if (instance == null) {
            instance = new HeadLinesRepo();
        }
        return instance;

    }
/*

    public MutableLiveData<HeadlineModel> getHeadlineList() {
        getserviceCall();
        MutableLiveData<List<HeadlineModel>> listMutableLiveData = new MutableLiveData<>();
        listMutableLiveData.setValue(headlineModels);
        return headlineModels;
    }
*/

    private void getserviceCall() {


    }

}

