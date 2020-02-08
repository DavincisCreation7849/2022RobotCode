/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final class DriveTrain{
        public static final int driveRightVictorChannel = 4;
        public static final int driveRightFoloowerVictorChannel= 3;
        public static final int driveLeftVictorChannel = 2;
        public static final int driveLeftFollowerVictorChannel= 1;
        public static final int solenoidBox = 5;
        //public static final int HANG_TALON = 5;
        //public static final int TILT_TALON = 6;
        //public static final int ELEVATOR_TALON = 7;
    }
    

    public final class controllerButtons{
        public static final int DRIVER_CONTROLLER_X = 1;
        public static final int DRIVER_CONTROLLER_A = 2;
        public static final int DRIVER_CONTROLLER_B = 3; 
        public static final int DRIVER_CONTROLLER_Y = 4; 
        public static final int DRIVER_CONTROLLER_LB = 5;
        public static final int DRIVER_CONTROLLER_RB = 6;
        public static final int DRIVER_CONTROLLER_LEFTTRIGGER = 7;
        public static final int DRIVER_CONTROLLER_RIGHTTRIGGER = 8;
        public static final int DRIVER_CONTROLLER_BACK = 9;
        public static final int DRIVER_CONTROLLER_START = 10;
        public static final int DRIVER_CONTROLLER_LEFTTRIGGERCLICK = 11;
        public static final int DRIVER_CONTROLLER_RIGHTTRIGGERCLICK = 12;
            
    }
    
}   