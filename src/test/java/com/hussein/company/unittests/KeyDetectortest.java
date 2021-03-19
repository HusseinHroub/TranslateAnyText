package com.hussein.company.unittests;

import com.hussein.company.utilties.KeyPressUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class KeyDetectortest {

    @Test
    public void testDoubleClick() throws InterruptedException {
        int keyCode = 2;
        assertFalse(KeyPressUtils.isDoublePressed(keyCode));
        assertTrue(KeyPressUtils.isDoublePressed(keyCode));
        assertTrue(KeyPressUtils.isDoublePressed(keyCode));
        assertTrue(KeyPressUtils.isDoublePressed(keyCode));
        Thread.sleep(300);
        System.out.println("sleeping");
        assertFalse(KeyPressUtils.isDoublePressed(keyCode));
    }
}
