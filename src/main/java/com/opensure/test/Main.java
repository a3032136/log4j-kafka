package com.opensure.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by axu on 2015/2/9.
 */
public class Main {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger("kafkaLog");
        log.info("I am ready.");
    }
}
