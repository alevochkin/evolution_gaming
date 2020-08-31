package com.liovachkin.evolutio_gaming_test;

import java.util.List;
import java.util.Scanner;

/**
 * Copyright (c) 31.08.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class App {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.load().forEach(texasHoldem -> System.out.println(texasHoldem.results()) );
    }
}
