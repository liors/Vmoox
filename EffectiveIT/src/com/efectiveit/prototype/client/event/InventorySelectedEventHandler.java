package com.efectiveit.prototype.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface InventorySelectedEventHandler extends EventHandler {
  void onInventorySelected(InventorySelectedEvent event);
}
