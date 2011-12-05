/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Arm extends Subsystem implements Constants{
    private static Arm instance = null;

    Victor armMotor;
    AnalogChannel potentiometer;
    Servo wrist;

    //Drawbridge
    static final double DRAWBRIDGE_POT_MIN          = 2.4;

    //Arm potentiometer values
    static final double POT_SIDE_BOTTOM             = 3.75;
    static final double POT_SIDE_MIDDLE             = 3.12;
    static final double POT_SIDE_TOP                = 2.38;
    static final double POT_MIDDLE_BOTTOM           = 3.67;
    static final double POT_MIDDLE_MIDDLE           = 2.99;
    static final double POT_MIDDLE_TOP              = 2.28;
    static final double POT_FEEDER_LEVEL            = 3.63;
    static final double POT_GROUND_LEVEL            = 4.37;

    public static Arm getInstance() {
        if(instance == null) {
            instance = new Arm();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
        }
        return instance;
    }

    // Initialize your subsystem here
    private Arm() {
        armMotor = new Victor(ARM_MOTOR_CHANNEL);
        potentiometer = new AnalogChannel(ARM_POT_CHANNEL);
        wrist = new Servo(WRIST_SERVO);
    }

     public void rotate(double stickVal) {
        if (stickVal >= 0.5) {
            armMotor.set(1);
        }
        else if (stickVal <= -0.5) {
            armMotor.set(-1);
        }
        else {
            armMotor.set(0);
        }
    }

    /**
     * Returns position of arm potentiometer.
     */
     public double getPosition() {
       return potentiometer.getVoltage();
    }
}

