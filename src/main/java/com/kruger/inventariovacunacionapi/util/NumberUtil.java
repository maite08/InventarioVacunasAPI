/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kruger.inventariovacunacionapi.util;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
/**
 *
 * @author MaiteMejia
 */
public class NumberUtil {
    public static Integer getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomNumberCharInRange(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }
}
