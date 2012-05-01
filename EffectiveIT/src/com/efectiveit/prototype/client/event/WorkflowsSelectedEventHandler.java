package com.efectiveit.prototype.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface WorkflowsSelectedEventHandler extends EventHandler {
  void onWorkflowsSelected(WorkflowsSelectedEvent event);
}
