/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy.commands.grabber;

import edu.stuy.subsystems.Grabber;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author bradmiller
 */
public class GrabberUp extends Command {
    Grabber grabber;

    public GrabberUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        grabber = Grabber.getInstance();
        requires(grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        grabber.setMotors(-1, -1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
