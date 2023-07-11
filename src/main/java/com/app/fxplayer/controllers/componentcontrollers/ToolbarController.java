package com.app.fxplayer.controllers.componentcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.ToolBarView;

/**
 * tool bar view controller
 */
public class ToolbarController extends Controller {
    // tool-bar view instance
    private final ToolBarView toolBarView;
    public ToolbarController(View view) {
        super(view);
        toolBarView = (ToolBarView) view;
    }

    @Override
    public void init() {
        toolBarView.getFullScreenButton().setOnAction(actionEvent -> toolBarView.setFullScreen());
        toolBarView.getSearchTextField().textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.isEmpty())
            {
                // search text field content
                //
                System.out.println(t1);
            }
        });
    }
}
