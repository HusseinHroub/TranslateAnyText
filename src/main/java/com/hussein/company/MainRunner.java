package com.hussein.company;

import com.hussein.company.listeners.MyKeyListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainRunner {
    public static void main(String[] args) {
        removeLoggingMessages();
        registerNativeHook();
        GlobalScreen.addNativeKeyListener(new MyKeyListener());
        System.out.println("Listening..");

    }

    private static void registerNativeHook() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
    }

    private static void removeLoggingMessages() {
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }

}
