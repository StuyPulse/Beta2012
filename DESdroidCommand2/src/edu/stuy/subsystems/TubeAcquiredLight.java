/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy.subsystems;

import edu.stuy.commands.SetTubeAcquiredLight;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TubeAcquiredLight extends Subsystem {
    private static TubeAcquiredLight instance = null;
    
    private Relay light;

    public static TubeAcquiredLight getInstance() {
        if(instance == null) {
            instance = new TubeAcquiredLight();

            // Set default command here, like this:
            // instance.setDefaultCommand(new CommandIWantToRun());
            instance.setDefaultCommand(new SetTubeAcquiredLight());
        }
        return instance;
    }

    // Initialize your subsystem here
    private TubeAcquiredLight() {
        light = new Relay(1);
        light.setDirection(Relay.Direction.kForward);
    }
    
    public void set(boolean on) {
        light.set(on ? Relay.Value.kOn : Relay.Value.kOff);
    }
}

