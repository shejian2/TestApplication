package com.jrud.lib.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

public class MultipleItem implements MultiItemEntity,Serializable {


    @Override
    public int getItemType() {
        return 0;
    }
}
