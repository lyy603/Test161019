package com.example.testing.test161019.recyclerviewadapterhelper;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.testing.test161019.R;

import java.util.List;

/**
 * 作者：linyaye on 2017/1/22 10:06
 */

public class BaseRecyclerViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public BaseRecyclerViewAdapter(List<String> data) {
        super(R.layout.item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        if (baseViewHolder.getLayoutPosition() % 10 == 0)
            baseViewHolder.setText(R.id.tv_item, s + "****");
        else
            baseViewHolder.setText(R.id.tv_item, s);
    }
}
