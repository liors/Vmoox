package com.efectiveit.prototype.client;

import com.efectiveit.prototype.client.presenter.UberPresenter;
import com.google.gwt.core.client.EntryPoint;

public class EffectiveIT implements EntryPoint {
    public void onModuleLoad() {
        UberPresenter uberPresenetr = new UberPresenter();
        uberPresenetr.bind();
    }
}
