package com.gy.recyclerviewadapter.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gy.recyclerviewadapter.BR;
import com.gy.recyclerviewadapter.R;
import com.gy.recyclerviewadapter.entity.Movie;
import com.gy.recyclerviewadapter.entity.MoviePresenter;

import java.util.List;

/**
 * Created by luoxiongwen on 16/10/24.
 */

public class DataBindingUseAdapter extends BaseQuickAdapter<Movie, DataBindingUseAdapter.MovieViewHolder> {

    private MoviePresenter mPresenter;

    public DataBindingUseAdapter(int layoutResId, List<Movie> data) {
        super(layoutResId, data);

        mPresenter = new MoviePresenter();
    }

    @Override
    protected void convert(MovieViewHolder helper, Movie item) {
        ViewDataBinding binding = helper.getBinding();
        binding.setVariable(BR.movie, item);
        binding.setVariable(BR.presenter, mPresenter);
        binding.executePendingBindings();
        switch (helper.getLayoutPosition() %
                2) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;

        }
    }

    /*  @Override
      protected MovieViewHolder createBaseViewHolder(View view) {
          return new MovieViewHolder(view);
      }
  */
    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    public static class MovieViewHolder extends BaseViewHolder {

        public MovieViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }
}
