package com.efectiveit.prototype.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class OperationsSelectedEvent extends GwtEvent<OperationsSelectedEventHandler> {
	public static Type<OperationsSelectedEventHandler> TYPE = new Type<OperationsSelectedEventHandler>();
	
	public OperationsSelectedEvent() {
    }
	
    
    @Override
	public Type<OperationsSelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OperationsSelectedEventHandler handler) {
		handler.onOperationsSelected(this);
	}

    
}
