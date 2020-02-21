/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.Encoder;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrHang;


public class Hanger extends CommandBase {
  /**
   * Creates a new Hanger.
   */
  //private final 
  private DrHang hanger;
//  private Joystick dpad = new Joystick(0);
//  private int dpadValue = dpad.getPOV();
  private Joystick m_joystick;
  private double elevatorSpeed = 1.0;
   public Hanger(DrHang hang, Joystick nonDriveJoystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hanger);
    m_joystick = nonDriveJoystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int dpadValue = m_joystick.getPOV();
    if(dpadValue==0)
    {
      hanger.setElevatorPower(1.0);

    }
    else if (dpadValue ==180){
      hanger.setElevatorPower(-1.0);
    }
    else{
      hanger.setElevatorPower(0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
