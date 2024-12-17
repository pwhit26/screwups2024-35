package org.firstinspires.ftc.teamcode.Opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous(name = "AutonTest", group = "Test1")
public class flippedAuton extends LinearOpMode {
    Action myTraj1, myTraj2, myTraj3, myTraj4;
    public static double xpos, ypos;
    TrajectoryActionBuilder trajToBucket;
    private Servo shoulderLeft1, shoulderRight1;
    public static double xPosVec = -34, yPosVec = 48;
    public static double xPosStart = -64, yPosStart = 5;
    private Servo wrist;
    private Servo openGrabber;
    private Servo turnGrabber;
    private DcMotor slideythingy1;


    //Servo slideLAngle;
    //static final double arm_home = 0.0;
    //static final double arm_min = 0.0;
    //static final double arm_max = 0.5;
   /* private DcMotor leftFront   = null;
    private DcMotor rightBack  = null;
    private DcMotor rightFront   = null;
    private DcMotor leftBack  = null;

    private ElapsedTime runtime = new ElapsedTime();
    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // No External Gearing.
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /(WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;*/


    @Override
    public void runOpMode() throws InterruptedException {

        Vector2d myVector = new Vector2d(xPosVec, yPosVec);
        Vector2d pos = new Vector2d(-36, 60);
        Vector2d second = new Vector2d(-55, 63);
        Pose2d myPose = new Pose2d(xPosStart, yPosStart, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
        shoulderLeft1 = hardwareMap.get(Servo.class, "shit2");
        shoulderLeft1.setPosition(0.05);
        shoulderRight1 = hardwareMap.get(Servo.class, "shit1");
        shoulderRight1.setPosition(0.95);
        wrist = hardwareMap.get(Servo.class, "wrist");
        wrist.setPosition(0.52);
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        openGrabber.setPosition(0);
        turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
        turnGrabber.setPosition(0.8);
        slideythingy1 = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //IF PROBLEM CHANGE TO RUN_TO_POSITION
        slideythingy1.setDirection(DcMotor.Direction.REVERSE);
        slideythingy1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        myTraj1 = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-30, 55), Math.toRadians(90))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(-30, 10), Math.toRadians(90))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(-30, 55), Math.toRadians(90))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(-25, 55), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(-25, 10), Math.toRadians(90))
                .build();

        myTraj2 = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-80, 37), Math.toRadians(90))
                .build();

        myTraj3 = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(-80, 20), Math.toRadians(90))
                .turn(Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(-30, 12), Math.toRadians(90))
                .build();
        myTraj4 = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(0.1)
                .build();

        waitForStart();
        openGrabber.setPosition(0);
        sleep(500);

        shoulderLeft1.setPosition(0.2);
        shoulderRight1.setPosition(0.8);
        wrist.setPosition(1);

        turnGrabber.setPosition(0.8);

        if (slideythingy1.getCurrentPosition() < 800) {
            while (slideythingy1.getCurrentPosition() < 800) {
                slideythingy1.setPower(1);
            }
            slideythingy1.setPower(0);
        }


        Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(myTraj2));
        sleep(500);
        wrist.setPosition(0.45);
        sleep(500);


        if (slideythingy1.getCurrentPosition() > 500) {
            while (slideythingy1.getCurrentPosition() > 500) {
                slideythingy1.setPower(-1);
            }

            slideythingy1.setPower(0);

        }
        openGrabber.setPosition(0.5);
        shoulderLeft1.setPosition(0.15);
        shoulderRight1.setPosition(0.85);

        if (isStopRequested()) {
            return;
        }
    }
}