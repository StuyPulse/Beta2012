/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class DESdroidBetaHardware extends IterativeRobot {

    RobotDrive rd;
    Joystick gamepad;
    Relay david;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        gamepad = new Joystick(1);

        david = new Relay(1);
        david.setDirection(Relay.Direction.kForward);
        
        rd = new RobotDrive(7, 8, 9, 10);
        
        

        rd.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        rd.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
//        rd.mecanumDrive_Cartesian(gamepad.getRawAxis(1), gamepad.getRawAxis(2), gamepad.getRawAxis(3), 0);
        rd.mecanumDrive_Cartesian(gamepad.getRawAxis(5), -gamepad.getRawAxis(6), 0, 0); // Button drive
        
        if (gamepad.getRawButton(2)) {
            david.set(Relay.Value.kOn);
        }
        else {
            david.set(Relay.Value.kOff);
        }
    }
}
