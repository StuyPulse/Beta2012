/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy.subsystems;

import edu.stuy.OI;
import edu.stuy.commands.DriveWithGamepad;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    private static Chassis instance = null;
    
    private RobotDrive drive;

    public static Chassis getInstance() {
        if(instance == null) {
            instance = new Chassis();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
            instance.setDefaultCommand(new DriveWithGamepad());
        }
        return instance;
    }

    // Initialize your subsystem here
    private Chassis() {
        drive = new RobotDrive(7, 8, 9, 10);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    }
    
    public void mecanumDrive_Cartesian(double x, double y, double rotation) {
        drive.mecanumDrive_Cartesian(x, y, rotation, 0);
    }
    
    public void driveWithGamepad() {
        drive.mecanumDrive_Cartesian(OI.getInstance().getLeftX(), -OI.getInstance().getLeftY(), OI.getInstance().getRightX(), 0);
    }
}

