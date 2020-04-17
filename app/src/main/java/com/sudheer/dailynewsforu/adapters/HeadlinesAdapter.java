package com.sudheer.dailynewsforu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sudheer.dailynewsforu.R;
import com.sudheer.dailynewsforu.models.HeadlineModel;

import java.util.List;

/**
 * Created by Your name on 12/4/20.
 */
public class HeadlinesAdapter extends RecyclerView.Adapter<HeadlinesAdapter.ViewHolder> {
    private Context context;
    private List<HeadlineModel.ArticlesBean> headlineModels;

    public HeadlinesAdapter(Context context, List<HeadlineModel.ArticlesBean> headlineModels) {
        this.context = context;
        this.headlineModels = headlineModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_news_title.setText(headlineModels.get(position).getTitle());
        holder.tv_news_disc.setText(headlineModels.get(position).getDescription());
        Glide.with(context).load(headlineModels.get(position).getUrlToImage()).centerCrop().placeholder(R.drawable.ic_launcher_foreground).into(holder.title_news_Image);

    }
    public void setList(List<HeadlineModel.ArticlesBean> moviesList) {
        this.headlineModels = moviesList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return headlineModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_news_title, tv_news_disc, tv_his_usename, tv_his_resmsg, tv_his_txnDate, tv_his_ercode, tv_his_service;
        LinearLayout li_txt_errormsg, li_txt_errorcode;
        ImageView title_news_Image;

        public ViewHolder(View itemView) {
            super(itemView);

            this.tv_news_title = itemView.findViewById(R.id.title);
            this.tv_news_disc = itemView.findViewById(R.id.discrption);
            this.title_news_Image = itemView.findViewById(R.id.title_news_Image);
           /* this.tv_his_usename = itemView.findViewById(R.id.tv_his_usename);
            this.tv_his_ercode = itemView.findViewById(R.id.tv_his_errorcode);
            this.tv_his_resmsg = itemView.findViewById(R.id.tv_his_resmsg);
            this.tv_his_txnDate = itemView.findViewById(R.id.tv_his_txnDate);
            this.tv_his_service = itemView.findViewById(R.id.tv_his_servicetype);
            this.li_txt_errorcode = itemView.findViewById(R.id.li_txt_errorcode);
            this.li_txt_errormsg = itemView.findViewById(R.id.li_txt_errormsg);*/
        }
    }
}
