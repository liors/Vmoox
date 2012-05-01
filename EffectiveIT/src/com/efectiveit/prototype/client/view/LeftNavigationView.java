package com.efectiveit.prototype.client.view;

import java.util.ArrayList;
import java.util.List;

import com.efectiveit.prototype.client.presenter.LeftNavigationPresenter;
import com.efectiveit.prototype.client.presenter.LeftNavigationPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class LeftNavigationView extends Composite implements Display {

    private static LeftNavigationViewUiBinder uiBinder = GWT.create(LeftNavigationViewUiBinder.class);

    interface LeftNavigationViewUiBinder extends UiBinder<Widget, LeftNavigationView> {
    }
    
    public interface LeftNavigationViewStyle extends CssResource {
        String hide();
    }
    
    @UiField LeftNavigationViewStyle style;
    @UiField HTMLPanel operationsSections;
    @UiField Anchor inventory;
    @UiField Anchor workflow;
    @UiField Anchor reports;
    
    @UiField HTMLPanel datacenterSections;
    @UiField Anchor navigation;
    @UiField Anchor site;
    @UiField Anchor datacenters;
    @UiField Anchor servers;
    @UiField Anchor databases;
    @UiField Anchor networks;


    @UiField LIElement workflowRunning;
    @UiField LIElement workflowRepository;
    @UiField LIElement workflowHistory;
    
    @UiField LIElement inventoryContainer;
    @UiField LIElement workflowContainer;
    @UiField LIElement reportsContainer;
    
    private List<LIElement> containers = new ArrayList<LIElement>();
    private LeftNavigationPresenter presenter;


    public LeftNavigationView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @Override
    public void bind() {
        containers.add(inventoryContainer);
        containers.add(workflowContainer);
        containers.add(reportsContainer);
        bindEvents();
    }
    
    @Override
    public void showDatacenterTabs() {
        operationsSections.addStyleName(style.hide());
        datacenterSections.removeStyleName(style.hide());        
    }

    @Override
    public void showOperationTabs() {
        operationsSections.removeStyleName(style.hide());
        datacenterSections.addStyleName(style.hide());
    }
    
    

    @Override
    public void setPresenter(LeftNavigationPresenter leftNavigationPresenter) {
        this.presenter = leftNavigationPresenter;
    }

    private void bindEvents() {
        workflow.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                unSelectAllTabs();
                workflowContainer.addClassName("active");
                showWorkflowActions();
                presenter.workflowSelected();
            }
        });
        
        inventory.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                unSelectAllTabs();
                hideWorkflowActions();
                inventoryContainer.addClassName("active");
                presenter.inventorySelected();
            }
        });
        
        reports.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                unSelectAllTabs();
                hideWorkflowActions();
                reportsContainer.addClassName("active");
                presenter.reportsSelected();
            }
        });
    }

    private void showWorkflowActions() {
        workflowRunning.removeClassName("hide");
        workflowRepository.removeClassName("hide");
        workflowHistory.removeClassName("hide");
    }
    
    private void hideWorkflowActions() {
        workflowRunning.addClassName("hide");
        workflowRepository.addClassName("hide");
        workflowHistory.addClassName("hide");
    }
    
    private void unSelectAllTabs() {
        for(LIElement container : containers) {
            container.removeClassName("active");
        }
    }   
}
