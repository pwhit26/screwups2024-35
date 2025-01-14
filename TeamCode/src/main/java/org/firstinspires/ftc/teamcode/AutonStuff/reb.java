package org.firstinspires.ftc.teamcode.AutonStuff;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous
@Config
public class reb extends LinearOpMode {
    double slidePower1 = 2.0;
    double stop = 0.0;
    public static double xPosStart = 24, yPosStart = -60;
    Action toBucket, forward, back;
    private Servo shoulderLeft1, shoulderRight1;
    private Servo wrist;
    private Servo openGrabber;
    private Servo turnGrabber;
    private DcMotor slideythingy1;

    public void bdrop()
    {
        shoulderLeft1.setPosition(0.3);
        shoulderRight1.setPosition(0.7);
        if (slideythingy1.getCurrentPosition() < 2695) {
            slideythingy1.setPower(slidePower1);
        }
        else {
            slideythingy1.setPower(stop);
        }
        turnGrabber.setPosition(0.0);
        openGrabber.setPosition(0.45);
        sleep(500);
        openGrabber.setPosition(0.11);
        turnGrabber.setPosition(0.0);
        if (slideythingy1.getCurrentPosition() > 0) {
            slideythingy1.setPower(-slidePower1);
        }
        else {
            slideythingy1.setPower(stop);
        }
        shoulderLeft1.setPosition(0.05);
        shoulderRight1.setPosition(0.95);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d myPose = new Pose2d(xPosStart, yPosStart, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
        shoulderLeft1 = hardwareMap.get(Servo.class, "shit2");
        shoulderRight1 = hardwareMap.get(Servo.class, "shit1");
        shoulderLeft1.setPosition(0.05);
        shoulderRight1.setPosition(0.95);
        wrist = hardwareMap.get(Servo.class, "wrist");
        wrist.setPosition(0.52);
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
        openGrabber.setPosition(0.11);
        turnGrabber.setPosition(0.8);
        slideythingy1 = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //IF PROBLEM CHANGE TO RUN_TO_POSITION
        slideythingy1.setDirection(DcMotor.Direction.REVERSE);
        slideythingy1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        toBucket = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-46, -45), Math.toRadians(45))
                .build();
        forward = drive.actionBuilder(new Pose2d(-46, -45, Math.toRadians(45)))
                .turn(Math.toRadians(45))
                .strafeToConstantHeading(new Vector2d(-46, -40))
                .build();
        back = drive.actionBuilder(new Pose2d(-46, -45, Math.toRadians(45)))
    }
}