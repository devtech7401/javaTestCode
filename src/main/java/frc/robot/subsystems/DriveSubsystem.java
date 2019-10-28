/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  //Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX LeftMaster = new WPI_TalonSRX (RobotMap.LeftMaster);
  public WPI_TalonSRX LeftSlave = new WPI_TalonSRX (RobotMap.LeftSlave);
  public WPI_TalonSRX RightMaster = new WPI_TalonSRX (RobotMap.RightMaster);
  public WPI_TalonSRX RightSlave = new WPI_TalonSRX (RobotMap.RightSlave);


  public DifferentialDrive drive = new DifferentialDrive (LeftMaster, RightMaster);

  public DriveSubsystem() {

      LeftSlave.follow(LeftMaster);
      RightSlave.follow(RightMaster);
  }

  public void ManualDrive(double move, double turn) {
   if(move > .5) move = .5;
   
    drive.arcadedrive(move, turn);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
  }
}
