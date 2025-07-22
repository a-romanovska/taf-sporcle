package com.sporcle.utils;

import com.sporcle.enums.Symbol;

public class ColorConverterUtils {
    public static final int RGB_CHANNELS_NUMBER = 4;
    public static final int RGB_CHANNEL_MIN = 0;
    public static final int RGB_CHANNEL_MAX = 255;
    public static final float ALPHA_CHANNEL_MIN = 0f;
    public static final float ALPHA_CHANNEL_MAX = 1f;

    public static String rgbaToHex(String rgba) {
        String rgbaWithoutBrackets = rgba.trim().replace("rgba(", "").replace(")", "");
        String[] channelsAsStrings = rgbaWithoutBrackets.split(Symbol.COMMA.getSymbol());
        if (channelsAsStrings.length != RGB_CHANNELS_NUMBER) {
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
