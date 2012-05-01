package com.efectiveit.prototype.client.view;

import com.efectiveit.prototype.client.presenter.BreadcrumbPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class BreadcrumbView extends Composite implements Display {

    private static BreadcrumbViewUiBinder uiBinder = GWT.create(BreadcrumbViewUiBinder.class);

    interface BreadcrumbViewUiBinder extends UiBinder<Widget, BreadcrumbView> {
    }
    
    @UiField AnchorElement parent;
    @UiField LIElement child;

    public BreadcrumbView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void bind() {        
    }

    @Override
    public void setParentText(String text) {
        parent.setInnerHTML(text);
    }

    @Override
    public void setChildText(String text) {
        child.setInnerHTML(text);
    }    
}
