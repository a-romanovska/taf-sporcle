package com.sporcle.utils;

import com.sporcle.enums.Symbol;

public class ColorConverterUtils {
    private static final int RRGGBB_LENGTH = 6;
    private static final int RGB_LENGTH = 3;
    private static final int RGBA_LENGTH = RGB_LENGTH + 1;
    private static final int RGB_CHANNEL_MIN = 0;
    private static final int RGB_CHANNEL_MAX = 255;
    private static final float ALPHA_CHANNEL_MIN = 0f;
    private static final float ALPHA_CHANNEL_MAX = 1f;
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

    public static String rgbaToHex(String rgba) {
        String rgbaWithoutBrackets = rgba.trim().replace("rgba(", "").replace(")", "");
        String[] channelsAsStrings = rgbaWithoutBrackets.split(Symbol.COMMA.getSymbol());
        if (channelsAsStrings.length != RGBA_LENGTH) {
            throw new IllegalArgumentException("Incorrect format of RGBA");
        }

        int r = Integer.parseInt(channelsAsStrings[0].trim());
        int g = Integer.parseInt(channelsAsStrings[1].trim());
        int b = Integer.parseInt(channelsAsStrings[2].trim());
        float a = Float.parseFloat(channelsAsStrings[3].trim());

        r = clampChannel(r);
        g = clampChannel(g);
        b = clampChannel(b);
        a = clampAlpha(a);

        String hexR = String.format("%02X", r);
        String hexG = String.format("%02X", g);
        String hexB = String.format("%02X", b);
        String hexA = String.format("%02X", Math.round(a * RGB_CHANNEL_MAX));

        return Symbol.HASH.getSymbol() + hexR + hexG + hexB + hexA;
    }

    private static int clampChannel(int channel) {
        return Math.max(ColorConverterUtils.RGB_CHANNEL_MIN, Math.min(ColorConverterUtils.RGB_CHANNEL_MAX, channel));
    }

    private static float clampAlpha(float alpha) {
        return Math.max(ALPHA_CHANNEL_MIN, Math.min(ALPHA_CHANNEL_MAX, alpha));
    }
}
