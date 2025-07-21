package com.sporcle.utils;

public class ColorConverterUtils {
    public static String rgbaToHex(String rgba) {
        String cleaned = rgba.trim().replace("rgba(", "").replace(")", "");
        String[] channels = cleaned.split(",");
        if (channels.length != 4) {
            throw new IllegalArgumentException("Incorrect format of RGBA");
        }

        int r = Integer.parseInt(channels[0].trim());
        int g = Integer.parseInt(channels[1].trim());
        int b = Integer.parseInt(channels[2].trim());
        float a = Float.parseFloat(channels[3].trim());

        r = clamp(r, 0, 255);
        g = clamp(g, 0, 255);
        b = clamp(b, 0, 255);
        a = clampAlpha(a);

        String hexR = String.format("%02X", r);
        String hexG = String.format("%02X", g);
        String hexB = String.format("%02X", b);
        String hexA = String.format("%02X", Math.round(a * 255));

        return "#" + hexR + hexG + hexB + hexA;
    }

    private static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    private static float clampAlpha(float alpha) {
        return Math.max(0f, Math.min(1f, alpha));
    }
}
