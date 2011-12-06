/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.stuy;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Donovan extends SimpleRobot implements Ports, ThreeLaws {

    boolean lastTop;
    Joystick lstick;
    Joystick rstick;
    Joystick shootStick;
    DonovanDriveTrain dt;
    Acquirer roller;
    Kicker kicker;
    Hanger hanger;
    Gyro gyro;
    DonTrackerDashboard trackerDashboard;
    DonCircleTracker tracker;
    DonovanOI oi;
    Autonomous auton;


    public Donovan() {
        lstick = new Joystick(LSTICK_PORT); //usb port
        rstick = new Joystick(RSTICK_PORT); //usb port
        shootStick = new Joystick(SHOOTSTICK_PORT); //usb port
        gyro = new Gyro(GYRO_CHANNEL);
        gyro.setSensitivity(-0.007); //this is also done in DonCircleTracker
        dt = new DonovanDriveTrain(DRIVE_1_CHANNEL, DRIVE_2_CHANNEL, DRIVE_3_CHANNEL, DRIVE_4_CHANNEL, this); //digital channelss
        roller = new Acquirer(ACQUIRER_CHANNEL, this); //digital channel
        kicker = new Kicker(KICKMOTOR_CHANNEL, this); //digital channel
        hanger = new Hanger(WINCH_CHANNEL, A_FRAME_CHANNEL);
        




        auton = new Autonomous(this);



//        dt.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
//        dt.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
//        dt.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
//        dt.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

        /*
         * Default to low, so that we're in a consistent state
         */

        if (dt.shifterLeft.get() == 1) {
            dt.shifterLeft.set(0);
            dt.shifterRight.set(0);
        }


    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        getWatchdog().setEnabled(false);
        //getWatchdog().setExpiration(15);
        if (isAutonomous() && isEnabled()) {
            dt.setLow();
            kicker.cock();

            //auton.runSettingNum(2);
            // getWatchdog().feed();
            //System.out.println(oi.getAutonSwitch());

        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        getWatchdog().setEnabled(false);

        lastTop = false;
        kicker.cock();
        int c = 0;
        while (isOperatorControl() && isEnabled()) {
            //System.out.println("left encoder: " + dt.getLeftEnc() + " right encoder: " + dt.getRightEnc());
            Timer.delay(.01);




            dt.arcadeDrive(lstick);
            //tracker.doCamera();


            /************ Driver Controls **************/
            //dt.tankDrive(lstick, rstick);

            /*
            if(c%100 == 0){
            System.out.println("leftstick: " + lstick.getRawAxis(1));
            System.out.println("rightstick: " + rstick.getRawAxis(1));
            }
            c++;
             */

            if (lstick.getTrigger()) {
                dt.setLow(); // to low gear
            }
            if (rstick.getTrigger()) {
                dt.setHigh(); //to high gear
            }




            /************ Shooter Controls **************/
            //Acquirer listed under Panel Controls
            if (shootStick.getRawButton(4)) {

                hanger.startWinch();
            } else if (shootStick.getRawButton(5)) {

                hanger.reverseWinch();
            } else {

                hanger.stopWinch();
            }

            if (shootStick.getTrigger()) {
                kicker.shoot();
            } else if (kicker.limSwitchBroken) {
                kicker.stop();
            }


            if (shootStick.getRawButton(2)) {
                hanger.deployAFrame();
            }


            if (shootStick.getRawButton(10)) { //|| shootStick.getRawButton(11)){
                //System.out.println("switching to manual control");
                kicker.limSwitchBroken = true; //switch to manual control
                kicker.stop();
            }

            if (shootStick.getRawButton(11)) { //|| shootStick.getRawButton(11)){
                //System.out.println("switching back to auto control");
                kicker.limSwitchBroken = false; //switch to manual control
            }


            /************ Panel Controls **************/
            //System.out.println("Binary switch: " + oi.getAutonSwitch());
           /* if (oi.getA_Frame()) {
                //System.out.println("Get a frame!");
                hanger.deployAFrame();
            }

            if (oi.getWench()) {
                //System.out.println("Get a wench!");
                hanger.startWinch();
            } else {

                hanger.stopWinch();
            }

            if (oi.getKick()) {
                //System.out.println("get a kick!");
                kicker.shoot();
            } else if (kicker.limSwitchBroken) {
                kicker.stop();
            }

            if (oi.getCock()) {
                //System.out.println("get a cock!");
                kicker.cock();
            }*/

            if (lstick.getRawButton(3)) {
                //System.out.println("jstk aquire fwd");
                roller.start();
            } else {
                roller.stop();
            }
        }
    }

    public void doNoHarm() {
    }

    public void obeyOrders() {
    }
}
