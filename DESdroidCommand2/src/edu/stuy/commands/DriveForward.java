/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy.commands;

import edu.stuy.OI;
import edu.stuy.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author bradmiller
 */
public class DriveForward extends Command {
    Chassis chassis;
    private double timeout;

    public DriveForward(double timeout) {
        this.timeout = timeout;
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        chassis = Chassis.getInstance();
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        chassis.mecanumDrive_Cartesian(0, 0.25, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
