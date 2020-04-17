package com.sudheer.dailynewsforu.acitvities.ui.Headlines;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sudheer.dailynewsforu.interfaces.UserConsentInterface;
import com.sudheer.dailynewsforu.models.HeadlineModel;
import com.sudheer.dailynewsforu.repository.HeadLinesRepo;
import com.sudheer.dailynewsforu.utils.RetrofitSSLCertificate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeadLinesViewModel extends ViewModel {

    HeadLinesRepo headLinesRepo;
    private MutableLiveData<List<HeadlineModel.ArticlesBean>> listHeadlineMutableLiveData;

    public HeadLinesViewModel() {
        listHeadlineMutableLiveData = new MutableLiveData<List<HeadlineModel.ArticlesBean>>();
        //listMutableLiveData.setValue("This is Headlines fragment");

    }

    public void init() {

      /*  if (listHeadlineMutableLiveData != null) {
            return;
        }
*/
        getlistData();
        // headLinesRepo = HeadLinesRepo.getInstance();
        // listHeadlineMutableLiveData = headLinesRepo.getHeadlineList();


    }

    /*Retrofit Service Calling for Login*/
    private UserConsentInterface getInterfaceCheckService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                //this is for ssl certificate
                .client(RetrofitSSLCertificate.getUnsafeOkHttpClient())
                .build();
        final UserConsentInterface mInterfaceService = retrofit.create(UserConsentInterface.class);
        return mInterfaceService;
    }

    public LiveData<List<HeadlineModel.ArticlesBean>> getHeadlinesList() {
        return listHeadlineMutableLiveData;
    }

    public void getlistData() {
        Log.d("service ", "doinf service call");
        UserConsentInterface mApiService = this.getInterfaceCheckService();
        try {


            Call<HeadlineModel> mService = mApiService.getUserConsents("in", "e23f1c9b8dcc447ab0c227c737e0a13c");
            try {
                mService.enqueue(new Callback<HeadlineModel>() {

                    @Override
                    public void onResponse(Call<HeadlineModel> call, Response<HeadlineModel> response) {
                        List<HeadlineModel.ArticlesBean> headlineModels = new ArrayList<>();
                        for(int i=0;i<response.body().getArticles().size();i++){
                            headlineModels.add(response.body().getArticles().get(i));

                        }
                       /* for(int i=0;i<response.body().getTotalResults();i++){

                        }*/



                        listHeadlineMutableLiveData.setValue(headlineModels);
                        Log.d("service ", "datacame" + response.code());
                        //  listHeadlineMutableLiveData.setValue(response);
                    }

                    @Override
                    public void onFailure(Call<HeadlineModel> call, Throwable t) {
                        Log.d("service ", "faild");
                    }
                });
            } catch (Exception e) {
                e.getMessage();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}