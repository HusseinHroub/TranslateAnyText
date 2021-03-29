package com.hussein.company;

import com.hussein.company.listeners.MyKeyListener;
import com.hussein.company.utilties.DriverCleanupUtil;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainRunner {
    private static MyKeyListener myKeyListener = new MyKeyListener();

    public static void main(String[] args) throws IOException {
        DriverCleanupUtil.killRunningChromeDrivers();
        removeLoggingMessages();
        registerNativeHook();
        GlobalScreen.addNativeKeyListener(myKeyListener);
        listenForUserInput();
        System.out.println("Listening..");

    }

    private static void listenForUserInput() {
        new Thread(() -> {
            while (true) {
                System.out.print(">");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();
                quitSystemIfQuitCommand(input);
            }
        }).start();

    }

    private static void quitSystemIfQuitCommand(String input) {
        if ("quit".equalsIgnoreCase(input)) {
            System.out.println("Starting exiting process");
            cleanUp();
            System.exit(0);
        }
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

    private static void cleanUp() {
        try {
            myKeyListener.cleanUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
