/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;

public class DrHang extends SubsystemBase {
  /**
   * 
   * Creates a new DrHang.
   */
  WPI_TalonSRX hangTalon;
  DigitalInput limitSwitch1;
  DigitalInput limitSwitch2;
  //WPI_TalonSRX elevatorTalon;
  //WPI_TalonSRX TiltTalon;
  //Faults fault;


  public DrHang() {
    hangTalon = new WPI_TalonSRX(Constants.DriveTrain.HANG_TALON);
    hangTalon.configPeakCurrentLimit(5);
    hangTalon.configPeakCurrentDuration(100);
    hangTalon.configContinuousCurrentLimit(5);

    limitSwitch1 = new DigitalInput(1);
    limitSwitch2 = new DigitalInput(2);

    //fault = new Faults();
  }

  public void setElevatorPower(double power) {
      hangTalon.set(ControlMode.PercentOutput, power);
  }

  public boolean isLimitSwitch1On() {
    return limitSwitch1.get();
  }

  public boolean isLimitSwitch2On() {
    return limitSwitch2.get();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
