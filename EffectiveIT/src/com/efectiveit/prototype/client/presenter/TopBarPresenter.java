package com.efectiveit.prototype.client.presenter;

import com.efectiveit.prototype.client.view.Containers;
import com.efectiveit.prototype.client.view.TopBarView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class TopBarPresenter {

    private Display view;
    private SimpleEventBus eventBus;
    public TopBarPresenter(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
    }
    
    public interface Display {
        void removeFromParent();
        Widget asWidget();
        void bind();
    }
    
    public void bind() {
        HasWidgets container = RootPanel.get(Containers.TOP);
        container.clear();
        view = new TopBarView();
        container.add(view.asWidget());
        view.bind();        
    }
}
