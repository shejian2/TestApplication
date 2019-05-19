package com.jrud.lib.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jrud.lib.entity.MultipleItem;

import java.util.List;

public class CommonAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public CommonAdapter(List<MultipleItem> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {

    }
}
