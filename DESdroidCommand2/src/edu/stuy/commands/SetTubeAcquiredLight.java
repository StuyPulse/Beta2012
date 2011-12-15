/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy.commands;

import edu.stuy.subsystems.Grabber;
import edu.stuy.subsystems.TubeAcquiredLight;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author bradmiller
 */
public class SetTubeAcquiredLight extends Command {
    TubeAcquiredLight light;

    public SetTubeAcquiredLight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        light = TubeAcquiredLight.getInstance();
        requires(light);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        light.set(Grabber.getInstance().isTubeAcquired());
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
