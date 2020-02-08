/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.*;
import frc.robot.Constants;


public class DrHang extends SubsystemBase {
  /**
   * 
   * Creates a new DrHang.
   */
  /*WPI_TalonSRX hangTalon;
  WPI_TalonSRX elevatorTalon;
  WPI_TalonSRX TiltTalon;
  Faults fault;*/


  public DrHang() {
    /*hangTalon = new WPI_TalonSRX(Constants.HANG_TALON);
    hangTalon.configPeakCurrentLimit(5);
    hangTalon.configPeakCurrentDuration(100);
    hangTalon.configContinuousCurrentLimit(5);

    elevatorTalon = new WPI_TalonSRX(Constants.ELEVATOR_TALON);

    tiltTalon = new WPI_TalonSRX(Constants.Tilt_Talon);
    fault = new Faults();*/



  }

  /*public void setArmPower(double power) {
    hangTalon.set(ControlMode.PercentOutput, power);
  }

  public void setElevatorPower(double power) {
      elevatorTalon.set(ControlMode.PercentOutput, power);
  }

  public void setTiltPower(double power) {
    tiltTalon.set(ControlMode.PercentOutput, power);
  }*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
