/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author bradmiller
 */
public class PrintLine extends Command {
    String str;
    boolean hasPrinted = false;

    public PrintLine(String s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        str = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        if (!hasPrinted) {
        System.out.println(str);
//        hasPrinted = true;
//        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        /*
         * TODO: Try different ways of running PrintLine (code is commented):
         * 1. isFinished() always returns true
         * 2. Set instance variable boolean to true after println is run once,
         *    isFinished() returns boolean. Check to see if this would sometimes
         *    make duplicate prints, and sometimes not print at all.
         * 3. Same as 2, but check value of boolean in execute() to determine
         *    whether or not to print.
         */
        return true;
//        return hasPrinted;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
