package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;


@Config
@Autonomous(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")


public class TestingAutonomousClass extends LinearOpMode {

    @Override//this is where set up is done
    public void runOpMode() throws InterruptedException{
        // instantiate your MecanumDrive at a particular pose.
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, Math.toRadians(0)));
        Servo clawHAngle;
        Servo clawVAngle;
        Servo slideLAngle;
        Servo slideRAngle;
        Servo clawL;
        Servo clawR;
        Servo plane;
        final double slideLAngle_HOME = 0.0;
        final double slideLAngle_MIN_RANGE = 0.0;
        final double slideLAngle_MAX_RANGE = 0.5;
        //OpMode opMode;

        int visionOutputPosition = 1;

        Action trajectoryAction1;
        Action trajectoryAction2;
        Action trajectoryAction3;
        Action trajectoryActionCloseOut;

        trajectoryAction1 = drive.actionBuilder(drive.pose)
                .lineToX(24)
                .turn(Math.PI)
                .lineToX(-24)
                .turn(Math.PI)
                .lineToX(0)
                .build();

        /*
        trajectoryAction2 = drive.actionBuilder(drive.pose)
                .lineToY(37)
                .setTangent(Math.toRadians(0))
                .lineToX(18)
                .waitSeconds(3)
                .setTangent(Math.toRadians(0))
                .lineToXSplineHeading(46, Math.toRadians(180))
                .waitSeconds(3)
                .build();


        trajectoryAction3 = drive.actionBuilder(drive.pose)
                .lineToXSplineHeading(20, Math.toRadians(30))
                .setTangent(Math.toRadians(0))
                //.lineToYSplineHeading(33, Math.toRadians(1))
                .waitSeconds(1)
                //.setTangent(Math.toRadians(90))
                //.lineToY(48)
                //.setTangent(Math.toRadians(0))
                .lineToXSplineHeading(32, 0)
                .setTangent(Math.toRadians(0))
                .strafeTo(new Vector2d(44.5, 30))
                .setTangent(Math.toRadians(0))
                //.turn(Math.toRadians(180))
                .lineToX(47.5)
                .setTangent(Math.toRadians(0))
                .waitSeconds(1)
                .turn(Math.toRadians(90))
                //.setTangent(Math.toRadians(0))
                .lineToYConstantHeading(-20)
                .setTangent(Math.toRadians(0))
                .setTangent(Math.toRadians(180))
                .setTangent(Math.toRadians(0))
                .strafeTo(new Vector2d(-20,20))

                .build();*/







        waitForStart();
        //slideLAngle = hardwareMap.servo.get("slideLAngle");
        //slideLAngle.setPosition(slideLAngle_HOME);
        //slideLAngle.setPosition(slideLAngle_MAX_RANGE);




        if (isStopRequested()) return;



        Actions.runBlocking(
                new SequentialAction(
                        trajectoryAction1

                )
        );
        trajectoryAction3 = drive.actionBuilder(drive.pose)
                .lineToX(20)
                .waitSeconds(17)
                .setTangent(Math.toRadians(0))
                .strafeTo( new Vector2d(20, 20))
                .waitSeconds(2)
                .splineTo( new Vector2d(40,40), Math.toRadians(90))
                .build();

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryAction3

                )
        );
    }
}

