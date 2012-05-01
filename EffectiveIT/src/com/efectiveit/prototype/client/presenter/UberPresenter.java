package com.efectiveit.prototype.client.presenter;

import com.efectiveit.prototype.client.view.BreadcrumbView;
import com.efectiveit.prototype.client.view.Containers;
import com.efectiveit.prototype.client.view.GridView;
import com.efectiveit.prototype.client.view.LeftNavigationView;
import com.efectiveit.prototype.client.view.MainLayout;
import com.efectiveit.prototype.client.view.TopActionsView;
import com.efectiveit.prototype.client.view.TopNavigationView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class UberPresenter {

    public interface Display {
        void removeFromParent();
        Widget asWidget();
        void bind();
    }
    
    MainLayout view;
    public UberPresenter() {        
    }

    public void bind() {
        SimpleEventBus eventBus = new SimpleEventBus();
        
        TopBarPresenter topBarPresenter = new TopBarPresenter(eventBus);
        topBarPresenter.bind();
        
        FooterPresenter footerPresenter = new FooterPresenter(eventBus);
        footerPresenter.bind();
        
        TopNavigationView topNavigationView = new TopNavigationView();
        TopNavigationPresenter topNavigationPresenter = new TopNavigationPresenter(eventBus, topNavigationView);
        topNavigationPresenter.bind();
        
        LeftNavigationView leftNavigationView = new LeftNavigationView(); 
        LeftNavigationPresenter leftNavigationPresenter = new LeftNavigationPresenter(eventBus, leftNavigationView);
        leftNavigationPresenter.bind();
        
        TopActionsView topActionsView = new TopActionsView(); 
        TopActionsPresenter topActionsPresenter = new TopActionsPresenter(eventBus, topActionsView);
        topActionsPresenter.bind();
        
        BreadcrumbView breadcrumbView = new BreadcrumbView(); 
        BreadcrumbPresenter breadcrumbPresenter = new BreadcrumbPresenter(eventBus, breadcrumbView);
        breadcrumbPresenter.bind();
        
        GridView gridView = new GridView();
        GridPresenter gridPresenter = new GridPresenter(eventBus, gridView);
        gridPresenter.bind();
        
        view = new MainLayout(topNavigationView, leftNavigationView, topActionsView, breadcrumbView, gridView);
        topActionsPresenter.bind();
        
        bindLayout();

    }

    private void bindLayout() {
        HasWidgets container = RootPanel.get(Containers.LAYOUT);
        container.clear();
        container.add(view.asWidget());
        view.bind();
    }
}
