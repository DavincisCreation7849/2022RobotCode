/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
 
public class Box extends SubsystemBase {
  /**
   * Creates a new Box.
   */
  DoubleSolenoid solenoidDoor;
  DoubleSolenoid solenoidBox;

  public Box() {
    solenoidDoor = new DoubleSolenoid(6,0,1); //Foward --> 0 , Reverse --> 1
    solenoidBox = new DoubleSolenoid(6,2,3); //Foward --> 2 , Reverse --> 3

  }

  public void doubleSolenoidActuate(Value state){
    solenoidBox.set(state); 
    solenoidDoor.set(state); //RMW
  }

  public void doorOpen(){  //open door method
   
    solenoidDoor.set(Value.kForward);
  }


  public void doorClose(){  //close door method
    
    solenoidDoor.set(Value.kReverse);
  }
  
  public void boxLoad(){  //load balls method
    solenoidBox.set(Value.kForward);

  }

  public void boxDump(){  //dump balls method
    solenoidBox.set(Value.kReverse);
  }

  public Value checkDoor(){  //get status of door solenoid
    return solenoidDoor.get();
  }
  public Value checkBox(){  //get status of box solenoid
    return solenoidBox.get();

  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
