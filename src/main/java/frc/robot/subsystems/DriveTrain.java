/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  WPI_VictorSPX driveRight, driveRightFollower, driveLeft, driveLeftFollower;
  SpeedControllerGroup rightGroup, leftGroup;
  DifferentialDrive driveMotors;
  DoubleSolenoid solenoid;

  public DriveTrain() {
    driveRight=new WPI_VictorSPX(Constants.DriveTrain.driveRightVictorChannel);
    driveRightFollower=new WPI_VictorSPX(Constants.DriveTrain.driveRightFoloowerVictorChannel);
    driveLeft=new WPI_VictorSPX(Constants.DriveTrain.driveLeftVictorChannel);
    driveLeftFollower=new WPI_VictorSPX(Constants.DriveTrain.driveLeftFollowerVictorChannel);
    rightGroup = new SpeedControllerGroup(driveRight, driveRightFollower);
    leftGroup= new SpeedControllerGroup(driveLeft, driveLeftFollower);
    driveMotors = new DifferentialDrive(rightGroup, leftGroup);
    solenoid = new DoubleSolenoid(0,1);
    //driveRightFollower.follow(driveRight);
    //driveLeftFollower.follow(driveLeft);

  }

  public void driveMotors(double leftSpeed, double rightSpeed){
    driveRight.set(ControlMode.PercentOutput, rightSpeed);
    driveLeft.set(ControlMode.PercentOutput, leftSpeed);
    driveRightFollower.set(ControlMode.PercentOutput, rightSpeed);
    driveLeftFollower.set(ControlMode.PercentOutput, leftSpeed);
  }
  
  public void arcadeDrive(double rot, double power){
    driveMotors.arcadeDrive(power, rot);
  }

  public void doubleSolenoidActuate(Value state){
    solenoid.set(state);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
