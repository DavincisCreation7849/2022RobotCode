/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;  //there is no button stuff in here
import frc.robot.subsystems.*;


public class Tilter extends CommandBase {
  /**
   * Creates a new Tilter class.
   */
  private Box m_Box;
  private boolean m_load;
  

  public Tilter(Box box, boolean load) {
    System.out.println("tilt box constructor");
    m_Box=box;
    m_load = load;

  
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("tilt box init");
    if (m_load){
      m_Box.boxLoad();

    }
    else{
      m_Box.boxDump();
    }


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("tilt box execute");

    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println("tilt box done");

    return true;
  }
}
