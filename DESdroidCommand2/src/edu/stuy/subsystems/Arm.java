/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy.subsystems;

import edu.stuy.OI;
import edu.stuy.commands.ControlArm;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    private static Arm instance = null;
    
    private Victor armMotor;
    private Victor upperRollerMotor;
    private Victor lowerRollerMotor;

    public static Arm getInstance() {
        if(instance == null) {
            instance = new Arm();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
            instance.setDefaultCommand(new ControlArm());
        }
        return instance;
    }

    // Initialize your subsystem here
    private Arm() {
        armMotor = new Victor(3);
    }
    
    public void controlArm() {
        armMotor.set(OI.getInstance().getRightY());
    }
}

