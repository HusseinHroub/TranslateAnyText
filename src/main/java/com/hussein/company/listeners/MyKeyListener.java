package com.hussein.company.listeners;

import com.hussein.company.utilties.KeyPressUtils;
import com.hussein.company.utilties.TranslateOnChrome;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MyKeyListener implements NativeKeyListener {

    private static final String CONTROL_STRING = "Ctrl";

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (CONTROL_STRING.equals(NativeKeyEvent.getKeyText(e.getKeyCode()))) {
            if (KeyPressUtils.isDoublePressed(e.getKeyCode())) {
                TranslateOnChrome.translate(getSelectedText());
            }
        } else {
            //short term solution TODO enhance...
            KeyPressUtils.clearMapContent();
        }
    }

    private String getSelectedText() {
        try {
            performCopyAction();
            Thread.sleep(20); //added to give enough time for the copy action to be finished.
            return getTextFromClipboard();
        } catch (AWTException | UnsupportedFlavorException | IOException | InterruptedException e) {
            System.out.println("yup error happened idk what why.");
        }
        return null;
    }

    private String getTextFromClipboard() throws UnsupportedFlavorException, IOException {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) c.getData(DataFlavor.stringFlavor);
    }

    private void performCopyAction() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }
}
