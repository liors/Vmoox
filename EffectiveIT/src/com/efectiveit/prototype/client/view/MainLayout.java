package com.efectiveit.prototype.client.view;

import com.efectiveit.prototype.client.presenter.UberPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainLayout extends Composite implements Display {

    private static MainLayoutUiBinder uiBinder = GWT.create(MainLayoutUiBinder.class);

    interface MainLayoutUiBinder extends UiBinder<Widget, MainLayout> {
    }

    @UiField(provided = true) TopNavigationView topNavigationView;
    @UiField(provided = true) LeftNavigationView leftNavigationView;
    @UiField(provided = true) TopActionsView topActionsView;
    @UiField(provided = true) BreadcrumbView breadcrumbView;
    @UiField(provided = true) GridView gridView;

    
    public MainLayout(TopNavigationView topNavigationView, LeftNavigationView leftNavigationView, TopActionsView topActionsView, BreadcrumbView breadcrumbView, GridView gridView) {
        this.topNavigationView = topNavigationView;
        this.leftNavigationView = leftNavigationView;
        this.topActionsView = topActionsView;
        this.breadcrumbView = breadcrumbView;
        this.gridView = gridView;
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void bind() {
        // TODO Auto-generated method stub
        
    }


}
