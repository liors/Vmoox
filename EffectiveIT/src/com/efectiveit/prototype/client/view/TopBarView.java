package com.efectiveit.prototype.client.view;

import com.efectiveit.prototype.client.presenter.TopBarPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TopBarView extends Composite implements Display {

    private static TopBarViewUiBinder uiBinder = GWT.create(TopBarViewUiBinder.class);

    interface TopBarViewUiBinder extends UiBinder<Widget, TopBarView> {
    }

    public TopBarView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void bind() {
        // TODO Auto-generated method stub
        
    }
}
