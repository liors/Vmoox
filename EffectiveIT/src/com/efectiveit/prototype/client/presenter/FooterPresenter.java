package com.efectiveit.prototype.client.presenter;

import com.efectiveit.prototype.client.view.Containers;
import com.efectiveit.prototype.client.view.FooterView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class FooterPresenter {
    private Display view;
    private SimpleEventBus eventBus;
    
    public interface Display {
        void removeFromParent();
        Widget asWidget();
        void bind();
    }
    
    public FooterPresenter(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void bind() {
        HasWidgets container = RootPanel.get(Containers.FOOTER);
        container.clear();
        view = new FooterView();
        container.add(view.asWidget());
        view.bind();        
    }

}
