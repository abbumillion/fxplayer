package com.example.demo.controllers;


import com.example.demo.views.View;

public abstract class Controller {
    private View view;
    public Controller(View view)
    {
        this.view = view;
    }
    // event registration behavior for every controller
    public abstract void register();
    // controller initialization behavior
    public abstract void start();
}
