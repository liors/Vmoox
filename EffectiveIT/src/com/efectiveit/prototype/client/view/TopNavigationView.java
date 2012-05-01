package com.efectiveit.prototype.client.view;

import java.util.ArrayList;
import java.util.List;

import com.efectiveit.prototype.client.presenter.TopNavigationPresenter;
import com.efectiveit.prototype.client.presenter.TopNavigationPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TopNavigationView extends Composite implements Display {

    private static TopNavigationViewUiBinder uiBinder = GWT.create(TopNavigationViewUiBinder.class);

    interface TopNavigationViewUiBinder extends UiBinder<Widget, TopNavigationView> {
    }

    @UiField LIElement datacenterContainer;
    @UiField Anchor datacenter;
    @UiField LIElement operationsContainer;
    @UiField Anchor operations;
    
    private List<LIElement> containers = new ArrayList<LIElement>();
    private TopNavigationPresenter presenter;
    
    public TopNavigationView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void bind() {
        containers.add(datacenterContainer);
        containers.add(operationsContainer);
        operationsContainer.addClassName("active");
        
        bindEvents();
    }
    
    @Override
    public void setPresenter(TopNavigationPresenter presenter) {
        this.presenter = presenter;
    }

    private void bindEvents() {
        datacenter.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                unSelectAllTabs();
                datacenterContainer.addClassName("active");
                presenter.onDatacenterSelected();
                
            }
        });
        
        operations.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                unSelectAllTabs();
                operationsContainer.addClassName("active");
                presenter.onOperationSelected();
            }
        });
    }

    protected void unSelectAllTabs() {
        for(LIElement container : containers) {
            container.removeClassName("active");
        }
    }
}
