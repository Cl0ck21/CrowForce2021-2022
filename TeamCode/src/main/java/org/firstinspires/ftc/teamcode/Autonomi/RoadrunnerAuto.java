package org.firstinspires.ftc.teamcode.Autonomi;

import com.SCHSRobotics.HAL9001.system.robot.BaseAutonomous;
import com.SCHSRobotics.HAL9001.system.robot.MainRobot;
import com.SCHSRobotics.HAL9001.system.robot.roadrunner_util.CoordinateMode;
import com.SCHSRobotics.HAL9001.system.robot.roadrunner_util.HALTrajectory;
import com.SCHSRobotics.HAL9001.util.math.geometry.Point2D;
import com.SCHSRobotics.HAL9001.util.math.units.HALAngleUnit;
import com.SCHSRobotics.HAL9001.util.math.units.HALDistanceUnit;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Baguette;
import org.firstinspires.ftc.teamcode.Subsystem.WeirdSpinnerHalWorkaround;

@Autonomous(name = "Roadrunner", group = "comp")
public class RoadrunnerAuto extends BaseAutonomous {
    public @MainRobot
    Baguette robot;



    @Override
    public void main() {
        HALTrajectory forwardRoute = new HALTrajectory(robot.mDrive.trajectoryBuilder(new Pose2d(0,0, 0), HALDistanceUnit.INCHES, HALAngleUnit.DEGREES).
                lineTo(new Point2D(0,48)).
                build().toRoadrunner(),
                CoordinateMode.HAL);
        HALTrajectory returnRoute = new HALTrajectory(robot.mDrive.trajectoryBuilder(forwardRoute.end(), 0).
                lineTo(new Point2D(0,0)).
                build().
                toRoadrunner(),
                CoordinateMode.HAL);

        //robot.mDrive.followTrajectory(forwardRoute);
        //waitTime(1000);
        //robot.mDrive.turnPID(PI);
        // waitTime(1000);
        //robot.mDrive.turnPID(PI);
        //waitTime(1000);
        //robot.mDrive.turnPID(PI);
        //waitTime(1000);
        //robot.mDrive.followTrajectory(returnRoute);

        HALTrajectory rightMarker = new HALTrajectory(robot.mDrive.trajectoryBuilder(returnRoute.end(), 0).

                lineTo(new Point2D(-30,48)).
                build().
                toRoadrunner(),
                CoordinateMode.HAL);

        robot.mDrive.followTrajectory(forwardRoute);
        robot.mDrive.followTrajectory(returnRoute);
        robot.mDrive.followTrajectory(rightMarker);



    }
}
