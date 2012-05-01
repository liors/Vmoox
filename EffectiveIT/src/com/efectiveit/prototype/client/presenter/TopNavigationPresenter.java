package com.efectiveit.prototype.client.presenter;

import com.efectiveit.prototype.client.event.DatacenterSelectedEvent;
import com.efectiveit.prototype.client.event.DatacenterSelectedEventHandler;
import com.efectiveit.prototype.client.event.InventorySelectedEvent;
import com.efectiveit.prototype.client.event.OperationsSelectedEvent;
import com.efectiveit.prototype.client.event.OperationsSelectedEventHandler;
import com.efectiveit.prototype.client.view.TopNavigationView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Widget;

public class TopNavigationPresenter {
    private Display view;
    private SimpleEventBus eventBus;
    
    public interface Display {
        void removeFromParent();
        Widget asWidget();
        void bind();
        void setPresenter(TopNavigationPresenter presenter);
    }
    
    public TopNavigationPresenter(SimpleEventBus eventBus, TopNavigationView view) {
        this.eventBus = eventBus;
        this.view = view;
    }

    public void bind() {
        view.bind();
        view.setPresenter(this);
    }

    public void onOperationSelected() {
        eventBus.fireEvent(new OperationsSelectedEvent());
        eventBus.fireEvent(new InventorySelectedEvent());
    }

    public void onDatacenterSelected() {
        eventBus.fireEvent(new DatacenterSelectedEvent());        
    }
}
