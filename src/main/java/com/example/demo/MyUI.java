package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@SpringUI
@Theme("demo")
@Widgetset("com.example.demo.MyWidgetSet")
public class MyUI extends UI {

    private HorizontalLayout layout = new HorizontalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        layout.addComponent(new Button("Button 1"));

        layout.addComponent(new Button("Button 2"));

        layout.addComponent(new Button("Button 3"));


        setContent(layout);

    }
}
