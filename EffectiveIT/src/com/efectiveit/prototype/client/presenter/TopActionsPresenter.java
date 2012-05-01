package com.efectiveit.prototype.client.presenter;

import com.efectiveit.prototype.client.event.DatacenterSelectedEvent;
import com.efectiveit.prototype.client.event.DatacenterSelectedEventHandler;
import com.efectiveit.prototype.client.event.OperationsSelectedEvent;
import com.efectiveit.prototype.client.event.OperationsSelectedEventHandler;
import com.efectiveit.prototype.client.view.TopActionsView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Widget;

public class TopActionsPresenter {
    private Display view;
    private SimpleEventBus eventBus;
    
    public interface Display {
        void removeFromParent();
        Widget asWidget();
        void bind();
        void showOperationActions();
        void showDatacenterActions();
    }
    
    public TopActionsPresenter(SimpleEventBus eventBus, TopActionsView view) {
        this.eventBus = eventBus;
        this.view = view;
        registerEventBusHandlers();
    }

    private void registerEventBusHandlers() {
        eventBus.addHandler(OperationsSelectedEvent.TYPE, new OperationsSelectedEventHandler() {
            @Override
            public void onOperationsSelected(OperationsSelectedEvent event) {
                view.showOperationActions();
            }
        });
        
        eventBus.addHandler(DatacenterSelectedEvent.TYPE, new DatacenterSelectedEventHandler() {
            @Override
            public void onDatacenterSelected(DatacenterSelectedEvent event) {
                view.showDatacenterActions();
            }
        });
    }

    public void bind() {
        view.bind();        
    }
}

