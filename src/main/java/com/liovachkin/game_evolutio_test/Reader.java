package com.liovachkin.game_evolutio_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Copyright (c) 30.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class Reader {
    public List<TexasHoldem> load() {
        return convert(read());
    }

    private List<String> read() {
        Scanner s = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (s.hasNext()) {
            input.add(s.nextLine());
        }
        return input;
    }

    private List<TexasHoldem> convert(List<String> input) {
        return input.stream()
            .map(TexasHoldem::new)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sor = "";
        System.out.println("start input...");
        while (sc.hasNextLine()) {
            sor = sc.nextLine();
        }
        System.out.println("finish input");
        System.out.println(sor);
        System.out.println("finish program");
    }
}
