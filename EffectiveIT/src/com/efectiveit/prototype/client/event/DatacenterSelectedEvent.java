package com.efectiveit.prototype.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class DatacenterSelectedEvent extends GwtEvent<DatacenterSelectedEventHandler> {
	public static Type<DatacenterSelectedEventHandler> TYPE = new Type<DatacenterSelectedEventHandler>();
	
	public DatacenterSelectedEvent() {
    }
	
    
    @Override
	public Type<DatacenterSelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DatacenterSelectedEventHandler handler) {
		handler.onDatacenterSelected(this);
	}

    
}
