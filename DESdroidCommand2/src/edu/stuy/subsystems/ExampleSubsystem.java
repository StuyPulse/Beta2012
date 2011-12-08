/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {
    private static ExampleSubsystem instance = null;

    public static ExampleSubsystem getInstance() {
        if(instance == null) {
            instance = new ExampleSubsystem();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
        }
        return instance;
    }

    // Initialize your subsystem here
    private ExampleSubsystem() {
    }
}

