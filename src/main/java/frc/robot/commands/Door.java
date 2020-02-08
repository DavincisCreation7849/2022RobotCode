/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Box;

public class Door extends CommandBase {
  /**
   * Creates a new Door.
   */
  private Box m_Box;
  private JoystickButton m_Joystick;
  private JoystickButton closeButton;


  public Door(Box box, JoystickButton joystick, JoystickButton close) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_Box=box;
    m_Joystick=joystick;
    closeButton=close;
    addRequirements(box);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean button = m_Joystick.get();
    boolean button2 = closeButton.get();
    if(button==true)
    {
      m_Box.doorOpen(m_Box.checkDoor());
    }
      else if(button2==true){
       m_Box.doorClose(m_Box.checkDoor()); 
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
