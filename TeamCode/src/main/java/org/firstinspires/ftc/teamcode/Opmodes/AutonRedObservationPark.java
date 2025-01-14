package org.firstinspires.ftc.teamcode.Opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.MecanumKinematics;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TimeTrajectory;
import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.TrajectoryBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import java.util.Locale;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRColor;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRRangeSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.acmerobotics.roadrunner.ParallelAction;

import org.firstinspires.ftc.teamcode.GeneralHardwareMap;
import org.firstinspires.ftc.teamcode.MecanumDrive;
@Config
@Autonomous(name = "AutonRedObservationPark", group = "Test1")
public class AutonRedObservationPark extends LinearOpMode {

        Action S1, pushThings, turn1, S2, back1, S3, S4, back2,back3;
        public static double xpos, ypos;
        private Servo shoulderLeft1, shoulderRight1;
        public static double xPosVec = -34, yPosVec = 48;
        public static double xPosStart = 24, yPosStart = -65;
        private Servo wrist;
        private Servo openGrabber;
        private Servo turnGrabber;
        private DcMotor slideythingy1;
        private DistanceSensor detect;
        private double mult = 310.800311;


    public void clip()
    {
        shoulderLeft1.setPosition(0.175);
        shoulderRight1.setPosition(0.825);
        wrist.setPosition(0.85);
        turnGrabber.setPosition(0.8);
        if (slideythingy1.getCurrentPosition() < 500)
        {
            while (slideythingy1.getCurrentPosition() < 500)
            {
                slideythingy1.setPower(1);
            }

            slideythingy1.setPower(0);

        }
        sleep(300);
        wrist.setPosition(0.45);
        sleep(300);
        if (slideythingy1.getCurrentPosition() > 370)
        {
            while (slideythingy1.getCurrentPosition() > 370)
            {
                slideythingy1.setPower(-1);
            }

            slideythingy1.setPower(0);

        }
        openGrabber.setPosition(0.55);
        sleep(100);
        if (slideythingy1.getCurrentPosition() > 10)
        {
            while (slideythingy1.getCurrentPosition() > 10)
            {
                slideythingy1.setPower(-1);
            }

            slideythingy1.setPower(0);

        }
        shoulderLeft1.setPosition(0.075);
        shoulderRight1.setPosition(0.925);
        turnGrabber.setPosition(0.8);
    }

    public void grabSpec()
    {
        shoulderLeft1.setPosition(0.0515);
        shoulderRight1.setPosition(0.9485);
        wrist.setPosition(1);
        turnGrabber.setPosition(0.8);
        openGrabber.setPosition(0.5);
        sleep(500);
        if (slideythingy1.getCurrentPosition() < mult*(detect.getDistance(DistanceUnit.INCH)-3.5))
        {
            while (slideythingy1.getCurrentPosition() < mult*(detect.getDistance(DistanceUnit.INCH)-3.5))
            {
                slideythingy1.setPower(1);
            }

            slideythingy1.setPower(0);

        }
        //sleep(500);
        turnGrabber.setPosition(0.8);
        openGrabber.setPosition(0.1);
        sleep(200);
        shoulderLeft1.setPosition(0.175);
        shoulderRight1.setPosition(0.825);
        turnGrabber.setPosition(0.8);
        //telemetry.addData("Distance (cm): ", detect.getDistance(DistanceUnit.INCH));

    }

        @Override
        public void runOpMode () throws InterruptedException {

            shoulderLeft1 = hardwareMap.get(Servo.class, "shit2");
            shoulderLeft1.setPosition(0.05);
            shoulderRight1 = hardwareMap.get(Servo.class, "shit1");
            shoulderRight1.setPosition(0.95);
            openGrabber = hardwareMap.get(Servo.class, "openGrabber");
            openGrabber.setPosition(0.1);
            wrist = hardwareMap.get(Servo.class, "wrist");
            wrist.setPosition(0.52);
            turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
            turnGrabber.setPosition(0.8);
            detect = hardwareMap.get(DistanceSensor.class, "detect");
            slideythingy1 = hardwareMap.get(DcMotor.class, "slide1");
            slideythingy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //IF PROBLEM CHANGE TO RUN_TO_POSITION
            slideythingy1.setDirection(DcMotor.Direction.REVERSE);
            slideythingy1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Pose2d myPose = new Pose2d(xPosStart, yPosStart, Math.toRadians(90));
            MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
            S1 = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                    .waitSeconds(0.1)
                    .strafeToLinearHeading(new Vector2d(10, -33.75), Math.toRadians(90))
                    .build();
            pushThings = drive.actionBuilder(new Pose2d(10, -33.75, Math.toRadians(90)))
                    .strafeToLinearHeading(new Vector2d(39, -38), Math.toRadians(90))
                    .strafeToLinearHeading(new Vector2d(39, -13), Math.toRadians(90))
                    .strafeToLinearHeading(new Vector2d(50, -13), Math.toRadians(90))
                    .strafeToLinearHeading(new Vector2d(50, -54), Math.toRadians(90))
                    .strafeToLinearHeading(new Vector2d(50, -13), Math.toRadians(90))
                    .strafeToLinearHeading(new Vector2d(63, -13), Math.toRadians(90))
                    .strafeToLinearHeading(new Vector2d(63, -54), Math.toRadians(90))
                    .build();
            turn1 = drive.actionBuilder(new Pose2d(63, -54, Math.toRadians(90)))
                    //.turn(Math.toRadians(180))
                    .strafeToLinearHeading(new Vector2d(41, -54), Math.toRadians(270))
                    .build();
            S2 = drive.actionBuilder(new Pose2d(41, -54,  Math.toRadians(270)))
                            .strafeToLinearHeading(new Vector2d(9, -33.5), Math.toRadians(90))
                            .build();
            back1 = drive.actionBuilder(new Pose2d(9, -33.5, Math.toRadians(90)))
                            .strafeToLinearHeading(new Vector2d(40, -55), Math.toRadians(270))
                            .build();
            S3 = drive.actionBuilder(new Pose2d(40, -55, Math.toRadians(270)))
                            .strafeToLinearHeading(new Vector2d(8, -33.5), Math.toRadians(90))
                            .build();
            S4 = drive.actionBuilder(new Pose2d(40, -56, Math.toRadians(270)))
                    .strafeToLinearHeading(new Vector2d(7, -33.5), Math.toRadians(90))
                    .build();
            back2 = drive.actionBuilder(new Pose2d(8, -33.5, Math.toRadians(90)))
                    .strafeToLinearHeading(new Vector2d(40, -56), Math.toRadians(270))
                    .build();
            back3 = drive.actionBuilder(new Pose2d(7, -33.5, Math.toRadians(90)))
                    .strafeToLinearHeading(new Vector2d(40, -60), Math.toRadians(270))
                    .build();


            waitForStart();
            openGrabber.setPosition(0.1);
            wrist.setPosition(0.9);
            turnGrabber.setPosition(0.8);
            //sleep(100);
            shoulderLeft1.setPosition(0.175);
            shoulderRight1.setPosition(0.825);
            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(S1));


            clip();
            sleep(200);
            turnGrabber.setPosition(0.8);
            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(pushThings));
            sleep(300);
            turnGrabber.setPosition(0.8);
            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(turn1));

            grabSpec();

            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(S2));
            turnGrabber.setPosition(0.8);

            clip();

            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(back1));
            sleep(100);
            turnGrabber.setPosition(0.8);
            grabSpec();
            sleep(100);

            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(S3));
            sleep(100);
            turnGrabber.setPosition(0.8);
            clip();
            sleep(100);

            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(back2));
            sleep(100);
            turnGrabber.setPosition(0.8);
            grabSpec();
            sleep(100);

            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(S4));
            sleep(100);
            turnGrabber.setPosition(0.8);
            clip();
            sleep(100);
            turnGrabber.setPosition(0.8);
            Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(back3));
            turnGrabber.setPosition(0.8);






        }
    }