/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Michael1 extends IterativeRobot {
    
    KinectStick leftK;
    KinectStick rightK;
    RobotDrive drive;
    Victor leftV, rightV;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        
        leftK = new KinectStick(1);
        rightK = new KinectStick(2);
        
        
        leftV = new Victor(1);
        rightV = new Victor(2);
        
        drive = new RobotDrive(rightV, leftV);
        

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
        System.out.println("left: " + -leftK.getY() + "\tright: " + -rightK.getY());
        //drive.tankDrive(-leftK.getY(), -rightK.getY());
    }
    
}
