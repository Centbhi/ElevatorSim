package com.gjbmloslos.elevatorsim.constants;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class UIConfigs {
    public static int floorHeight = 200;
    public static int elevatorWidth = 55;
    public static int elevatorHeight = 100;

    public static Insets WrapperMarginPadding = new Insets(25,25,25,25);

    public static Insets floorMargin = new Insets(50,0,0,0);
    public static Insets shaftMargins = new Insets(50,20,0,20);

    public static Background shaftColor = Background.fill(Color.web("#F1FAEE"));
    public static Background floorColor = Background.fill(Color.web("#457B9D"));
    public static Background floorWrapperColor = Background.fill(Color.DARKGRAY);
    public static Background studentElevColor = Background.fill(Color.web("1d3557"));
    public static Background employeeElevColor = Background.fill(Color.web("e63946"));

}
