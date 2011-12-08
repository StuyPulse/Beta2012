/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy.subsystems;

import edu.stuy.commands.ControlGrabber;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    private static Grabber instance = null;
    
    Victor upperRollerMotor;
    Victor lowerRollerMotor;

    public static Grabber getInstance() {
        if(instance == null) {
            instance = new Grabber();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
            instance.setDefaultCommand(new ControlGrabber());
        }
        return instance;
    }

    // Initialize your subsystem here
    private Grabber() {
        upperRollerMotor = new Victor(4);
        lowerRollerMotor = new Victor(1);
    }
    
    public void grabberIn() {
        upperRollerMotor.set(-1);
        upperRollerMotor.set(1);
    }
    
    public void grabberOut() {
        upperRollerMotor.set(1);
        upperRollerMotor.set(-1);
    }
    
    public void grabberUp() {
        upperRollerMotor.set(-1);
        upperRollerMotor.set(-1);
    }
    
    public void grabberDown() {
        upperRollerMotor.set(1);
        upperRollerMotor.set(1);
    }
}

