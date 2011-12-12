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
 
    Gyro george;


    Victor acquirer;
   
    public RobotTemplate() {
        george = new Gyro(2,1);
        acquirer = new Victor(1,9);
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
}