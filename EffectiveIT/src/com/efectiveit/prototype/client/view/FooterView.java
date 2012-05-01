package com.efectiveit.prototype.client.view;

import com.efectiveit.prototype.client.presenter.FooterPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FooterView extends Composite implements Display {

    private static FooterViewUiBinder uiBinder = GWT.create(FooterViewUiBinder.class);

    interface FooterViewUiBinder extends UiBinder<Widget, FooterView> {
    }

    public FooterView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void bind() {
        
    }

}
