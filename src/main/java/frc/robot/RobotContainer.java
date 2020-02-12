/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.Door;
import frc.robot.commands.DoorOpen;
import frc.robot.commands.DoorClose;
import frc.robot.commands.Drive;
import frc.robot.commands.Tilter;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.driveLineAuto;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
//  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrain m_drivetrain = new DriveTrain();
  
  public Box m_box = new Box();

  public Joystick driveJoystick = new Joystick(0);

  public JoystickButton button_solenoid = new JoystickButton(driveJoystick, 1);

  public JoystickButton button_solenoid2 = new JoystickButton(driveJoystick, 2);

  public JoystickButton button_solenoid3 = new JoystickButton(driveJoystick, 3);

  public JoystickButton button_solenoid4 = new JoystickButton(driveJoystick, 4);

  private final driveLineAuto driveAuto = new driveLineAuto(m_drivetrain);

  private final Drive m_Drive = new Drive(m_drivetrain, driveJoystick);

  private final Door m_Door= new Door(m_box, button_solenoid, button_solenoid2);

  private final Tilter m_Tilter= new Tilter(m_box, button_solenoid3, button_solenoid4);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_drivetrain.setDefaultCommand(m_Drive);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    button_solenoid.whenPressed(new DoorOpen(m_box));
    button_solenoid2.whenPressed(new DoorClose(m_box));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveAuto;
  }
}
