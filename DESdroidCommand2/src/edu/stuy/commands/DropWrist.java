/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy.commands;

import edu.stuy.subsystems.Wrist;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author bradmiller
 */
public class DropWrist extends Command {
    Wrist wrist;
    boolean done = false;

    public DropWrist() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        wrist = Wrist.getInstance();
        requires(wrist);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        wrist.set(1);
        done = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
