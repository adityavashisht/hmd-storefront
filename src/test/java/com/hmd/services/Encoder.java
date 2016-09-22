package com.hmd.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by vashishta on 9/22/16.
 */
public class Encoder {

    public static void main(String [] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("admin"));
    }
}
