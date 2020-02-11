/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Box;

public class Door extends CommandBase {
  /**
   * Creates a new Door.
   */
  private Box m_Box;
  private JoystickButton openButton;
  private JoystickButton closeButton;


  public Door(Box box, JoystickButton open, JoystickButton close) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_Box=box;
    openButton=open;
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
    System.out.print("BUTTON COMMAND!");
    boolean button = openButton.get();
    boolean button2 = closeButton.get();
    if(button==true)
    {
      m_Box.doorOpen();
      System.out.print("OPEN SESAME!");
    }
      else if(button2==true){
       m_Box.doorClose(); 
       System.out.print("YOU SHALL NOT PASS!");
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
