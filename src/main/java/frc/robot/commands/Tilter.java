/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;


public class Tilter extends CommandBase {
  /**
   * Creates a new Tilter.
   */
  private Box m_Box;
  private JoystickButton loadButton;
  private JoystickButton dumpButton;

  public Tilter(Box box, JoystickButton load, JoystickButton dump) {
    m_Box=box;
    loadButton=load;
    dumpButton=dump;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean button = loadButton.get();
    boolean button2 = dumpButton.get();
    if(button==true){
    m_Box.boxLoad();
    System.out.print("Load");
    }
    else if(button2==true){
      m_Box.boxDump();
      System.out.print("Roll Out");

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
