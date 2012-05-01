package com.efectiveit.prototype.client.presenter;

import com.efectiveit.prototype.client.event.DatacenterSelectedEvent;
import com.efectiveit.prototype.client.event.DatacenterSelectedEventHandler;
import com.efectiveit.prototype.client.event.InventorySelectedEvent;
import com.efectiveit.prototype.client.event.InventorySelectedEventHandler;
import com.efectiveit.prototype.client.event.OperationsSelectedEvent;
import com.efectiveit.prototype.client.event.OperationsSelectedEventHandler;
import com.efectiveit.prototype.client.event.ReportsSelectedEvent;
import com.efectiveit.prototype.client.event.ReportsSelectedEventHandler;
import com.efectiveit.prototype.client.event.WorkflowsSelectedEvent;
import com.efectiveit.prototype.client.event.WorkflowsSelectedEventHandler;
import com.efectiveit.prototype.client.view.BreadcrumbView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Widget;

public class BreadcrumbPresenter {
    private Display view;
    private SimpleEventBus eventBus;
    
    public interface Display {
        void removeFromParent();
        Widget asWidget();
        void bind();
        void setParentText(String text);
        void setChildText(String text);
    }
    
    public BreadcrumbPresenter(SimpleEventBus eventBus, BreadcrumbView view) {
        this.eventBus = eventBus;
        this.view = view;
        registerEventBusHandlers();
    }

    private void registerEventBusHandlers() {
        eventBus.addHandler(OperationsSelectedEvent.TYPE, new OperationsSelectedEventHandler() {
            @Override
            public void onOperationsSelected(OperationsSelectedEvent event) {
                view.setParentText("Operations");
            }
        });
        
        eventBus.addHandler(DatacenterSelectedEvent.TYPE, new DatacenterSelectedEventHandler() {
            @Override
            public void onDatacenterSelected(DatacenterSelectedEvent event) {
                view.setParentText("Datacenter");
                view.setChildText("Databases");
            }
        });
        
        eventBus.addHandler(InventorySelectedEvent.TYPE, new InventorySelectedEventHandler() {
            @Override
            public void onInventorySelected(InventorySelectedEvent event) {
                view.setChildText("Inventory");
            }
        });
        
        eventBus.addHandler(WorkflowsSelectedEvent.TYPE, new WorkflowsSelectedEventHandler() {
            @Override
            public void onWorkflowsSelected(WorkflowsSelectedEvent event) {
                view.setChildText("Workflow");
            }
        });
        
        eventBus.addHandler(ReportsSelectedEvent.TYPE, new ReportsSelectedEventHandler() {
            
            public void onReportsSelected(ReportsSelectedEvent event) {
                view.setChildText("Reports");
            }
        });
    }

    public void bind() {
        view.bind();        
    }
}
