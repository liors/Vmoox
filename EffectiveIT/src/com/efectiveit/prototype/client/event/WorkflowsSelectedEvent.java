package com.efectiveit.prototype.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class WorkflowsSelectedEvent extends GwtEvent<WorkflowsSelectedEventHandler> {
	public static Type<WorkflowsSelectedEventHandler> TYPE = new Type<WorkflowsSelectedEventHandler>();
	
	public WorkflowsSelectedEvent() {
    }
	
    
    @Override
	public Type<WorkflowsSelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(WorkflowsSelectedEventHandler handler) {
		handler.onWorkflowsSelected(this);
	}

    
}
