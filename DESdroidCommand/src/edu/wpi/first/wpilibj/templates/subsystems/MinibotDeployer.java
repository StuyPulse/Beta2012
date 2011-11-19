/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MinibotDeployer extends Subsystem {
    private static MinibotDeployer instance = null;

    public static MinibotDeployer getInstance() {
        if(instance == null) {
            instance = new MinibotDeployer();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
        }
        return instance;
    }

    // Initialize your subsystem here
    private MinibotDeployer() {
    }
}

