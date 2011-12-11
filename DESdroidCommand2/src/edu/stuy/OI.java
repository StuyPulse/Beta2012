/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy;

import edu.stuy.commands.PrintLine;
import edu.stuy.commands.grabber.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    
    private static OI instance = null;
    
    private Joystick gamepad;
    
    private JoystickButton GAMEPAD_BUTTON_1;
    private JoystickButton GAMEPAD_BUTTON_2;
    private JoystickButton GAMEPAD_BUTTON_3;
    private JoystickButton GAMEPAD_BUTTON_4;
    private JoystickButton GAMEPAD_BUTTON_5;
    
    private OI() {
        gamepad = new Joystick(1);

	GAMEPAD_BUTTON_1 = new JoystickButton(gamepad, 1);
	GAMEPAD_BUTTON_2 = new JoystickButton(gamepad, 2);
	GAMEPAD_BUTTON_3 = new JoystickButton(gamepad, 3);
	GAMEPAD_BUTTON_4 = new JoystickButton(gamepad, 4);
	GAMEPAD_BUTTON_5 = new JoystickButton(gamepad, 5);

	GAMEPAD_BUTTON_1.whileHeld(new GrabberIn());
	GAMEPAD_BUTTON_2.whileHeld(new GrabberOut());
	GAMEPAD_BUTTON_3.whileHeld(new GrabberUp());
	GAMEPAD_BUTTON_4.whileHeld(new GrabberDown());

        GAMEPAD_BUTTON_5.whenPressed(new PrintLine("Button pressed"));
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

