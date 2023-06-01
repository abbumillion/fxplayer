package com.example.demo.controllers;

import views.View;

public abstract class Controller {
    private View view;
    public Controller(View view)
    {
        this.view = view;
    }

    public abstract void register();
    public abstract void start();
}
