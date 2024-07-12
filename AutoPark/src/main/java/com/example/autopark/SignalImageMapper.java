package com.example.autopark;

import java.util.HashMap;
import java.util.Map;

public class SignalImageMapper {
    private static final Map<Integer, String> imageMap = new HashMap<>();
    static {
        imageMap.put(0b1111, "file:images/Lada_F_0.jpg");
        imageMap.put(0b0000, "file:images/Lada_F_15.jpg");
        imageMap.put(0b1110, "file:images/Lada_F_1.jpg");
        imageMap.put(0b1101, "file:images/Lada_F_2.jpg");
        imageMap.put(0b1100, "file:images/Lada_F_3.jpg");
        imageMap.put(0b1011, "file:images/Lada_F_4.jpg");
        imageMap.put(0b1010, "file:images/Lada_F_5.jpg");
        imageMap.put(0b1001, "file:images/Lada_F_6.jpg");
        imageMap.put(0b1000, "file:images/Lada_F_7.jpg");
        imageMap.put(0b0111, "file:images/Lada_F_8.jpg");
        imageMap.put(0b0110, "file:images/Lada_F_9.jpg");
        imageMap.put(0b0101, "file:images/Lada_F_10.jpg");
        imageMap.put(0b0100, "file:images/Lada_F_11.jpg");
        imageMap.put(0b0011, "file:images/Lada_F_12.jpg");
        imageMap.put(0b0010, "file:images/Lada_F_13.jpg");
        imageMap.put(0b0001, "file:images/Lada_F_14.jpg");
    }

    private static final Map<Integer, String> imageMap1 = new HashMap<>();
    static {
        imageMap1.put(0b1111, "file:images/Lada_B_0.png");
        imageMap1.put(0b0000, "file:images/Lada_B_15.png");
        imageMap1.put(0b0111, "file:images/Lada_B_1.png");
        imageMap1.put(0b1011, "file:images/Lada_B_2.png");
        imageMap1.put(0b0011, "file:images/Lada_B_3.png");
        imageMap1.put(0b1101, "file:images/Lada_B_4.png");
        imageMap1.put(0b0101, "file:images/Lada_B_5.png");
        imageMap1.put(0b1001, "file:images/Lada_B_6.png");
        imageMap1.put(0b0001, "file:images/Lada_B_7.png");
        imageMap1.put(0b1110, "file:images/Lada_B_8.png");
        imageMap1.put(0b0110, "file:images/Lada_B_9.png");
        imageMap1.put(0b1010, "file:images/Lada_B_10.png");
        imageMap1.put(0b0010, "file:images/Lada_B_11.png");
        imageMap1.put(0b1100, "file:images/Lada_B_12.png");
        imageMap1.put(0b0100, "file:images/Lada_B_13.png");
        imageMap1.put(0b1000, "file:images/Lada_B_14.png");
    }
    public static String getImagePath(int signalValue) {
        return imageMap.getOrDefault(signalValue, "");
    }
    public static String getImagePath1(int signalValue) {
        return imageMap1.getOrDefault(signalValue, "");
    }
}