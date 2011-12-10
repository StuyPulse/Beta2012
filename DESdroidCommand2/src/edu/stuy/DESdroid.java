/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.stuy;


import edu.stuy.commands.DropWrist;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.stuy.commands.ExampleCommand;
import edu.stuy.subsystems.Arm;
import edu.stuy.subsystems.Chassis;
import edu.stuy.subsystems.ExampleSubsystem;
import edu.stuy.subsystems.Grabber;
import edu.stuy.subsystems.TubeAcquiredLight;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class DESdroid extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();

        // create the instance of the operator interface class
        // this will associate all the buttons with the appropriate commands
        OI.getInstance();

        // initialize all subsystems here. The result of getInstance() is
        // intentionally ignored.
        ExampleSubsystem.getInstance();
        Chassis.getInstance();
        Arm.getInstance();
        Grabber.getInstance();
        TubeAcquiredLight.getInstance();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        new DropWrist().start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
