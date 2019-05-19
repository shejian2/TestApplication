package com.jrud.lib.mvp.contract;

import com.jrud.lib.mvp.base.IBasePresenter;
import com.jrud.lib.mvp.base.IBaseView;

/**
 * 契约类
 */
public interface HelloContract {

    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter {
    }
}
