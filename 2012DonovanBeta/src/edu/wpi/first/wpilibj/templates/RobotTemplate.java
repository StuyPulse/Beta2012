/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
      Joystick lstick;
    Joystick rstick;
    Joystick shootStick;
    Joystick gamepad;
    Gyro george;


    Victor acquirer;
   
    public RobotTemplate() {
        lstick = new Joystick(1); //usb port
        rstick = new Joystick(2); //usb port
        shootStick = new Joystick(3); //usb portRIVE_3_CHANNEL, DRIVE_4_CHANNEL); //digital channelss
        george = new Gyro(1,1);
        gamepad = new Joystick(4);
        acquirer = new Victor(2,9);
        System.out.println("contsructed Donovan");
    }
    public void operatorControl() {
        getWatchdog().setEnabled(false);
        while (isOperatorControl() && isEnabled()) {
            Timer.delay(.01);
            
            System.out.println("hello?  In operator control.");
         
        }
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
        acquirer.set(.2);
        Timer red = new Timer();
        
        
        while(isAutonomous()){
            System.out.println(george.getAngle());
        }
    }

    public void doNoHarm() {
    }

    public void obeyOrders() {
    }}