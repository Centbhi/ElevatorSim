package com.gjbmloslos.elevatorsim.constants;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class UIConfigs {
    public static int floorHeight = 200;
    public static Insets floorWrapperMargin = new Insets(25,25,25,25);
    public static Insets floorMargin = new Insets(50,0,0,0);
    public static Border floorBorder = new Border(
            new BorderStroke(
                    Color.DARKGRAY,
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    new BorderWidths(20,10,20,10)
            ));
    public static Insets elevatorMargins = new Insets(0,5,0,5);
    public static int elevatorWidth = 55;
    public static Background shaftColor = Background.fill(Color.web("#F1FAEE"));
    public static Background floorColor = Background.fill(Color.web("#457B9D"));
    public static Background floorWrapperColor = Background.fill(Color.DARKGRAY);
}
