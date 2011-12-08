/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    
    private static OI instance = null;
    
    private Joystick gamepad;
    
    private OI() {
        gamepad = new Joystick(1);
    }
    
    public static OI getInstance() {
    if (instance == null) 
            instance = new OI();
        return instance;
    }
    
    public double getLeftX() {
        return gamepad.getRawAxis(2);
    }
    
    public double getRightX() {
        return gamepad.getRawAxis(4);
    }
    
    public double getLeftY() {
        return gamepad.getRawAxis(1);
    }
    
    public double getRightY() {
        return gamepad.getRawAxis(5);
    }
    
    public Joystick getGamepad() {
        return gamepad;
    }
}

