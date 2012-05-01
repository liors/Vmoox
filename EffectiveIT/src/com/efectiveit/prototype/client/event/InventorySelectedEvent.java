package com.efectiveit.prototype.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class InventorySelectedEvent extends GwtEvent<InventorySelectedEventHandler> {
	public static Type<InventorySelectedEventHandler> TYPE = new Type<InventorySelectedEventHandler>();
	
	public InventorySelectedEvent() {
    }
	
    
    @Override
	public Type<InventorySelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(InventorySelectedEventHandler handler) {
		handler.onInventorySelected(this);
	}

    
}
