package com.example.demo;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.vaadin.client.connectors.grid.GridConnector;
import com.vaadin.client.ui.button.ButtonConnector;
import com.vaadin.client.ui.combobox.ComboBoxConnector;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.client.ui.customcomponent.CustomComponentConnector;
import com.vaadin.client.ui.datefield.InlineDateFieldConnector;
import com.vaadin.client.ui.datefield.PopupDateFieldConnector;
import com.vaadin.client.ui.label.LabelConnector;
import com.vaadin.client.ui.orderedlayout.HorizontalLayoutConnector;
import com.vaadin.client.ui.orderedlayout.VerticalLayoutConnector;
import com.vaadin.client.ui.panel.PanelConnector;
import com.vaadin.client.ui.passwordfield.PasswordFieldConnector;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.client.ui.ui.UIConnector;
import com.vaadin.client.ui.window.WindowConnector;
import com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory;
import com.vaadin.shared.ui.Connect.LoadStyle;

import java.util.HashSet;
import java.util.Set;


public class OptimizedConnectorBundleLoaderFactory extends ConnectorBundleLoaderFactory {

    private final Set<String> eagerConnectors = new HashSet<String>();
    {
        eagerConnectors.add(PasswordFieldConnector.class.getName());
        eagerConnectors.add(VerticalLayoutConnector.class.getName());
        eagerConnectors.add(HorizontalLayoutConnector.class.getName());
        eagerConnectors.add(ButtonConnector.class.getName());
        eagerConnectors.add(UIConnector.class.getName());
        eagerConnectors.add(CssLayoutConnector.class.getName());
        eagerConnectors.add(TextFieldConnector.class.getName());
        eagerConnectors.add(PanelConnector.class.getName());
        eagerConnectors.add(LabelConnector.class.getName());
        eagerConnectors.add(ComboBoxConnector.class.getName());
        eagerConnectors.add(CustomComponentConnector.class.getName());
        eagerConnectors.add(WindowConnector.class.getName());
        eagerConnectors.add(InlineDateFieldConnector.class.getName());
        eagerConnectors.add(PopupDateFieldConnector.class.getName());
        eagerConnectors.add(GridConnector.class.getName());
    }

    @Override
    protected LoadStyle getLoadStyle(final JClassType connectorType) {
        if (eagerConnectors.contains(connectorType.getQualifiedBinaryName())) {
            return LoadStyle.EAGER;
        } else {
            // Loads all other connectors immediately after the initial view has
            // been rendered
            return LoadStyle.DEFERRED;
        }
    }
}
