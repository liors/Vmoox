package com.efectiveit.prototype.client.view;

import com.efectiveit.prototype.client.presenter.TopActionsPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TopActionsView extends Composite implements Display{

    private static TopActionsViewUiBinder uiBinder = GWT.create(TopActionsViewUiBinder.class);

    interface TopActionsViewUiBinder extends UiBinder<Widget, TopActionsView> {
    }
    
    public interface TopActionsViewStyle extends CssResource {
        String hide();
    }

    @UiField TopActionsViewStyle style;
    @UiField DivElement datacenterContainer;
    @UiField DivElement operationsContainer;
    
    public TopActionsView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @Override
    public void showOperationActions() {
        operationsContainer.removeClassName(style.hide());
        datacenterContainer.addClassName(style.hide());
    }

    @Override
    public void showDatacenterActions() {
        operationsContainer.addClassName(style.hide());
        datacenterContainer.removeClassName(style.hide());        
    }

    @Override
    public void bind() {
        // TODO Auto-generated method stub
        
    }
}
