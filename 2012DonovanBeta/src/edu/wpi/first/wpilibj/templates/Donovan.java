/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Donovan extends SimpleRobot implements Ports {

//    boolean lastTop;
    Joystick lstick;
    Joystick rstick;
    Joystick shootStick;
    RobotDrive dt;
//    Acquirer roller;
//    Kicker kicker;
//    Hanger hanger;
    Gyro gyro;
//    DonTrackerDashboard trackerDashboard;
//    DonCircleTracker tracker;
//    DonovanOI oi;
//    Autonomous auton;


    public Donovan() {
        lstick = new Joystick(LSTICK_PORT); //usb port
        rstick = new Joystick(RSTICK_PORT); //usb port
        shootStick = new Joystick(SHOOTSTICK_PORT); //usb port
        gyro = new Gyro(GYRO_CHANNEL);
        gyro.setSensitivity(-0.007); //this is also done in DonCircleTracker
        dt = new RobotDrive(DRIVE_1_CHANNEL, DRIVE_2_CHANNEL, DRIVE_3_CHANNEL, DRIVE_4_CHANNEL); //digital channelss

    }
    
    public void operatorControl() {
        getWatchdog().setEnabled(false);

//        lastTop = false;
        while (isOperatorControl() && isEnabled()) {
            Timer.delay(.01);
            dt.tankDrive(lstick, rstick);          
        }
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
    }

    public void doNoHarm() {
    }

    public void obeyOrders() {
    }
}
