package com.efectiveit.prototype.client.presenter;

import com.efectiveit.prototype.client.event.DatacenterSelectedEvent;
import com.efectiveit.prototype.client.event.DatacenterSelectedEventHandler;
import com.efectiveit.prototype.client.event.InventorySelectedEvent;
import com.efectiveit.prototype.client.event.OperationsSelectedEvent;
import com.efectiveit.prototype.client.event.OperationsSelectedEventHandler;
import com.efectiveit.prototype.client.event.ReportsSelectedEvent;
import com.efectiveit.prototype.client.event.WorkflowsSelectedEvent;
import com.efectiveit.prototype.client.view.LeftNavigationView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Widget;

public class LeftNavigationPresenter {
private Display view;
private SimpleEventBus eventBus;
    
    public interface Display {
        void removeFromParent();
        Widget asWidget();
        void bind();
        void showOperationTabs();
        void showDatacenterTabs();
        void setPresenter(LeftNavigationPresenter leftNavigationPresenter);
    }
    
    public LeftNavigationPresenter(SimpleEventBus eventBus, LeftNavigationView view) {
        this.eventBus = eventBus; 
        this.view = view;
        registerEventBusHandlers();
    }

    private void registerEventBusHandlers() {
        eventBus.addHandler(OperationsSelectedEvent.TYPE, new OperationsSelectedEventHandler() {
            @Override
            public void onOperationsSelected(OperationsSelectedEvent event) {
                view.showOperationTabs();
            }
        });
        
        eventBus.addHandler(DatacenterSelectedEvent.TYPE, new DatacenterSelectedEventHandler() {
            @Override
            public void onDatacenterSelected(DatacenterSelectedEvent event) {
                view.showDatacenterTabs();
            }
        });
    }

    public void bind() {
        view.bind(); 
        view.setPresenter(this);
    }

    public void workflowSelected() {
        eventBus.fireEvent(new WorkflowsSelectedEvent());
    }

    public void inventorySelected() {
        eventBus.fireEvent(new InventorySelectedEvent());
    }

    public void reportsSelected() {
        eventBus.fireEvent(new ReportsSelectedEvent());
    }
}
