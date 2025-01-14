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
import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.acmerobotics.roadrunner.ParallelAction;

import org.firstinspires.ftc.teamcode.GeneralHardwareMap;
import org.firstinspires.ftc.teamcode.MecanumDrive;
@Config
@Autonomous(name = "SmallTest", group = "Test1")
public class SmallTest extends LinearOpMode{
    Action test1;
    public static double xpos, ypos;

    private Servo shoulderLeft1, shoulderRight1;
    public static double xPosVec = -34, yPosVec = 48;
    public static double xPosStart = 24, yPosStart = -65;
    private Servo wrist;
    private Servo openGrabber;
    private Servo turnGrabber;
    private DcMotor slideythingy1;

    @Override
    public void runOpMode() throws InterruptedException {
        shoulderLeft1 = hardwareMap.get(Servo.class, "shit2");
        shoulderLeft1.setPosition(0.05);
        shoulderRight1 = hardwareMap.get(Servo.class, "shit1");
        shoulderRight1.setPosition(0.95);
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        openGrabber.setPosition(0.1);
        Pose2d myPose = new Pose2d(xPosStart, yPosStart, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
        test1=drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(10, -32), Math.toRadians(90))
                .build();



        waitForStart();
        openGrabber.setPosition(0.1);
        sleep(500);
        Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(test1));

    }
}
