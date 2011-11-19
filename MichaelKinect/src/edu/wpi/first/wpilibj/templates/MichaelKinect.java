/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Watchdog;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class MichaelKinect extends SimpleRobot {
    KinectStick left;
    KinectStick right;
    RobotDrive dt;
    Victor leftv;
    Victor rightv;
    public MichaelKinect() {
        left = new KinectStick(1);
        right = new KinectStick(2);
        leftv = new Victor(1);
        rightv = new Victor(2);
        dt = new RobotDrive(leftv, rightv);
    }
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        Watchdog.getInstance().setEnabled(false);
        while (isOperatorControl() && isEnabled()) {
            dt.tankDrive(-left.getY(), -right.getY());
        }

    }
}
