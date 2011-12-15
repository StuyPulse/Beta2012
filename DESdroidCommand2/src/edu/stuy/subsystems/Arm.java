/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy.subsystems;

import edu.stuy.OI;
import edu.stuy.commands.ArmControlWithGamepad;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    private static Arm instance = null;
    
    private Victor armMotor;
    private AnalogChannel pot;

    public static Arm getInstance() {
        if(instance == null) {
            instance = new Arm();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
            instance.setDefaultCommand(new ArmControlWithGamepad());
        }
        return instance;
    }

    // Initialize your subsystem here
    private Arm() {
        armMotor = new Victor(3);
        pot = new AnalogChannel(1);
    }
    
    public void set(double speed) {
        armMotor.set(speed);
    }
    
    public void controlArm() {
        armMotor.set(OI.getInstance().getRightY());
    }
    
    public double getPosition() {
        return pot.getVoltage();
    }
}

