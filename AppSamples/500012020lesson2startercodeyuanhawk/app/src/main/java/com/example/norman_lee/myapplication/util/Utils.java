package com.example.norman_lee.myapplication.util;

public class Utils {

    public static Input checkInvalidInputs(String value) {
        try {
            double val = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Input.NFE;
        } catch (IllegalArgumentException e) {
            return Input.IAE;
        }
        return Input.VALID;
    }

    public enum Input { VALID, IAE, NFE }
}
