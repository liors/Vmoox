package com.efectiveit.prototype.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ReportsSelectedEvent extends GwtEvent<ReportsSelectedEventHandler> {
	public static Type<ReportsSelectedEventHandler> TYPE = new Type<ReportsSelectedEventHandler>();
	
	public ReportsSelectedEvent() {
    }
	
    
    @Override
	public Type<ReportsSelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReportsSelectedEventHandler handler) {
		handler.onReportsSelected(this);
	}

    
}
