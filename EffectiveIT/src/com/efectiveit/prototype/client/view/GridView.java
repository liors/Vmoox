package com.efectiveit.prototype.client.view;

import com.efectiveit.prototype.client.presenter.GridPresenter.Display;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GridView extends Composite implements Display {

    private static GridViewUiBinder uiBinder = GWT.create(GridViewUiBinder.class);

    interface GridViewUiBinder extends UiBinder<Widget, GridView> {
    }

    public GridView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField TableElement operationsGrid;
    @UiField TableElement databasesGrid;
    
    
    @Override
    public void bind() {
        operationsGrid.setId("operations");
        databasesGrid.setId("databases");
    }
    

    @Override
    protected void onAttach() {
        super.onAttach();
        showOperationGrid();
    }
    
    @Override
    public void showOperationGrid() {
        operationsGrid.removeClassName("hide");
        databasesGrid.addClassName("hide");
        bindGridImpl("#operations", "#databases_wrapper");
    }

    @Override
    public void showDatacenterGrid() {
        operationsGrid.addClassName("hide");
        databasesGrid.removeClassName("hide");
        bindGridImpl("#databases", "#operations_wrapper");
    }

    private native void bindGridImpl(String grid, String wrapper) /*-{
        $wnd.$(grid).dataTable().fnDestroy();
        $wnd.$(wrapper).find(".row").each(function() { $wnd.$(this).remove() });
		$wnd.$(grid).dataTable(
						{
							"sDom" : "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
							"sPaginationType" : "bootstrap",
							"bFilter": false,
							"bLengthChange": false
						});
    }-*/;
}
