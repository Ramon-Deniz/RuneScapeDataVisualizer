/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatTracker;

/**
 *
 * @author miguel
 */
public class XPCalculator {

    public static int XPToNextLevel(int currentXP, int level) {
        int difference = 0;
        for (int i = 1; i < level; i++) {
            difference += i + 300 * Math.pow(2, i / 7.0);
        }
        return difference / 4 - currentXP;
    }

    public static int XPTo99(int currentXP) {
        return XPToNextLevel(currentXP, 99);
    }

}
