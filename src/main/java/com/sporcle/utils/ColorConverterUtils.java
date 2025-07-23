package com.sporcle.utils;

import com.sporcle.enums.Symbol;

public class ColorConverterUtils {
    private static final int RRGGBB_LENGTH = 6;
    private static final int RGB_LENGTH = 3;
    private static final int HEXADECIMAL = 16;
    private static final float OPAQUE = 1f;

    public static String hexToRgba(String hex) {
        String hexWithoutHash = hex.replace(Symbol.HASH.getSymbol(), Symbol.EMPTY.getSymbol()).trim();

        int r, g, b;

        if (hexWithoutHash.length() == RGB_LENGTH) {
            r = Integer.parseInt(hexWithoutHash.substring(0, 1) + hexWithoutHash.substring(0, 1), HEXADECIMAL);
            g = Integer.parseInt(hexWithoutHash.substring(1, 2) + hexWithoutHash.substring(1, 2), HEXADECIMAL);
            b = Integer.parseInt(hexWithoutHash.substring(2, 3) + hexWithoutHash.substring(2, 3), HEXADECIMAL);
        } else if (hexWithoutHash.length() == RRGGBB_LENGTH) {
            r = Integer.parseInt(hexWithoutHash.substring(0, 2), HEXADECIMAL);
            g = Integer.parseInt(hexWithoutHash.substring(2, 4), HEXADECIMAL);
            b = Integer.parseInt(hexWithoutHash.substring(4, 6), HEXADECIMAL);
        } else {
            throw new IllegalArgumentException("Incorrect format of HEX");
        }

        return String.format("rgba(%d, %d, %d, %.0f)", r, g, b, OPAQUE);
    }
}
