/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;  //for getPOV(), getRawAxis(), getRawButton()
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;  //gets value of Joystick button, takes parameter GenericHID joystick
import edu.wpi.first.wpilibj.XboxController;  //getY, getX, etc.
import frc.robot.subsystems.*;  //all subsystems
import frc.robot.commands.*;  //all commands
//import frc.robot.commands.DoorClose;
//import frc.robot.commands.Drive;
//import frc.robot.commands.Tilter;
//import frc.robot.commands.ExampleCommand;
//import frc.robot.commands.DriveLineAuto;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;  //??



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
//  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrain m_drivetrain = new DriveTrain();  //makes a new DriveTrain object called m_drivetrain

  private final DrHang hangSubsystem = new DrHang();
  
  public Box m_box = new Box();  //makes a new Box object called m_box

  public Joystick driveJoystick = new Joystick(1);  //makes a new Joystick object called driveJoystick, port 1

  public Joystick nonDriveJoystick = new Joystick(0);  //makes a new Joystick object called nonDriveJoystick, port 0



  public JoystickButton button_solenoid = new JoystickButton(nonDriveJoystick, 1);  //makes a new JoystickButton object called button_solenoid, taking 2 parameters, joystick and buttonNumber

  public JoystickButton button_solenoid2 = new JoystickButton(nonDriveJoystick, 2);  //same

  public JoystickButton button_solenoid3 = new JoystickButton(nonDriveJoystick, 3);

  public JoystickButton button_solenoid4 = new JoystickButton(nonDriveJoystick, 4);

  private final driveLineAuto driveAuto = new driveLineAuto(m_drivetrain);  //makes a new DriveLineAuto object called driveAuto and passes m_drivetrain object to it

  private final Drive m_Drive = new Drive(m_drivetrain, driveJoystick);  //makes a new Drive object called m_Drive, takes parameters m_drivetrain object and driveJoystick object

  private final DrHang m_LimitSwitch = new DrHang();  //makes a new DrHang object called m_Limitswitch

  private final Hanger m_Switch = new Hanger(m_LimitSwitch,nonDriveJoystick);  //makes a new Hanger object called m_Switch, takes 2 parameters, m_LimitSwitchand object and NondriveJoystick

  private final Hanger m_Hanger = new Hanger(hangSubsystem, nonDriveJoystick);



  //private final Door m_Door= new Door(m_box, button_solenoid, button_solenoid2);

  //private final Tilter m_Tilter= new Tilter(m_box, button_solenoid3, button_solenoid4);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {  //constructor method
    // Configure the button bindings
    configureButtonBindings();  //calls configureButtonBindings method below
    m_LimitSwitch.setDefaultCommand(m_Switch);  //??  I don't see an m_LimitSwitch
    m_drivetrain.setDefaultCommand(m_Drive);  //??  I don't see an m_drivetraiin
    hangSubsystem.setDefaultCommand(m_Hanger);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    button_solenoid.whenPressed(new DoorOpen(m_box));  //when pressed, makes a new DoorOpen command object, using the Box subsystem object m_box
    button_solenoid2.whenPressed(new DoorClose(m_box));
    button_solenoid3.whenPressed(new Tilter(m_box, true ));  //why are these implemented differently?  Maybe implement in the same way for consistency?
    button_solenoid4.whenPressed(new Tilter(m_box, false));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveAuto;  //driveAuto will run
  }

  public void endGame(boolean state) {
    m_Hanger.endGame(state);
  }
}
