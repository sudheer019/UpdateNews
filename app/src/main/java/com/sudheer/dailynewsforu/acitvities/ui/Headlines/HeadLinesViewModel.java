package com.sudheer.dailynewsforu.acitvities.ui.Headlines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class HeadLinesViewModel extends ViewModel {

    private MutableLiveData<List<HeadLinesViewModel>> listHeadlineMutableLiveData;

    public HeadLinesViewModel() {
        listHeadlineMutableLiveData = new MutableLiveData<List<HeadLinesViewModel>>();
        //listMutableLiveData.setValue("This is Headlines fragment");
    }

    public LiveData<List<HeadLinesViewModel>> getHeadlinesList() {
        return listHeadlineMutableLiveData;
    }
}