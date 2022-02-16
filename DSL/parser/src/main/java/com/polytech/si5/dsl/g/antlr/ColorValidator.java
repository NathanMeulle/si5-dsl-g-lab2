package com.polytech.si5.dsl.g.antlr;

public class ColorValidator {
    public static final int HEXA_SIZE= 7;
    public static boolean isHexa(String color){
        return color.length() == HEXA_SIZE;
    }
}
