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
public class DriveSystem extends Subsystem implements Constants{
    
    private static DriveSystem instance = null;
    private DriveTrain drive;

    public static DriveSystem getInstance(VictorSpeed m_frontLeftMotor, VictorSpeed m_rearLeftMotor,
            VictorSpeed m_frontRightMotor, VictorSpeed m_rearRightMotor) {
        if(instance == null) {
            instance = new DriveSystem(m_frontLeftMotor,m_rearLeftMotor,
            m_frontRightMotor,  m_rearRightMotor);

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
        }
        return instance;
    }

    // Initialize your subsystem here
    private DriveSystem(VictorSpeed frontLeftMotor, VictorSpeed rearLeftMotor,
            VictorSpeed frontRightMotor, VictorSpeed rearRightMotor) {
        drive = new DriveTrain(frontLeftMotor, rearLeftMotor,
            frontRightMotor,  rearRightMotor);
    }
}

