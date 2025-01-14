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
@Autonomous(name = "AutonTest", group = "Test1")
public class AutonTest extends LinearOpMode{



    Action myTraj1, myTraj2, myTraj3, myTraj4, pushThings;
    public static double xpos, ypos;
    TrajectoryActionBuilder trajSpline1;
    TrajectoryActionBuilder trajToBucket;
    private Servo shoulderLeft1, shoulderRight1;
    public static double xPosVec = -34, yPosVec = 48;
    public static double xPosStart = -48, yPosStart = 65;
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

        Vector2d myVector = new Vector2d(xPosVec,yPosVec);
        Vector2d pos = new Vector2d(-36, 60);
        Vector2d second = new Vector2d(-55, 63);
        Pose2d myPose = new Pose2d(xPosStart, yPosStart, Math.toRadians(90));
        myPose = new Pose2d(-24, 72+7.5, Math.toRadians(270));
        MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
        shoulderLeft1 = hardwareMap.get(Servo.class, "shit2");
        shoulderLeft1.setPosition(0.05);
        shoulderRight1 = hardwareMap.get(Servo.class, "shit1");
        shoulderRight1.setPosition(0.95);
        wrist = hardwareMap.get(Servo.class, "wrist");
        wrist.setPosition(0.52);
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        openGrabber.setPosition(0.1);
        turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
        turnGrabber.setPosition(0.8);
        slideythingy1 = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //IF PROBLEM CHANGE TO RUN_TO_POSITION
        slideythingy1.setDirection(DcMotor.Direction.REVERSE);
        slideythingy1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



//        myTraj1 = drive.actionBuilder(new Pose2d(-80, 35, Math.toRadians(90)))
//                .waitSeconds(0.5)
//                .strafeToLinearHeading(new Vector2d(-40, 57), Math.toRadians(90))
//                .build();
        myTraj1 = drive.actionBuilder(myPose)
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(9, 24+7.5), Math.toRadians(270))
                .build();

        myTraj2 = drive.actionBuilder(new Pose2d(-54, 7, Math.toRadians(90)))
                .waitSeconds(0.2)
                .strafeToLinearHeading(new Vector2d(-64, 35), Math.toRadians(90))
                .build();

        myTraj3 = drive.actionBuilder(new Pose2d(-80, 35, Math.toRadians(90)))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(-40, 7), Math.toRadians(180))
                .build();

        myTraj4 = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(-54, 7), Math.toRadians(90))
                .build();
        pushThings = drive.actionBuilder(new Pose2d(-64, 35, Math.toRadians(90)))
                .waitSeconds(0.1)
                .strafeToLinearHeading(new Vector2d(-33, 30), Math.toRadians(90))
                .waitSeconds(0.07)
                .strafeToLinearHeading(new Vector2d(-33, 64), Math.toRadians(90))
                .waitSeconds(0.07)
                .strafeToLinearHeading(new Vector2d(-20, 58), Math.toRadians(90))
                .waitSeconds(0.07)
                .strafeToLinearHeading(new Vector2d(-20, 10), Math.toRadians(90))
                .waitSeconds(0.07)
                .strafeToLinearHeading(new Vector2d(-14, 58), Math.toRadians(90))
                //.waitSeconds(0.07)
                //.strafeToLinearHeading(new Vector2d(-14, 58), Math.toRadians(90))
                .waitSeconds(0.07)
                .strafeToLinearHeading(new Vector2d(-14, 10), Math.toRadians(90))
                .build();



        trajToBucket = drive.actionBuilder(new Pose2d(-48, 55, Math.toRadians(90)))
                .strafeTo(second);
        /*trajSpline1 = drive.actionBuilder(new Pose2d(xPosStart, yPosStart, Math.toRadians(90)))
                .waitSeconds(1)
                .splineTo(new Vector2d(-34, 48), Math.toRadians(90))
                .waitSeconds(1)
                .splineTo(new Vector2d(-34, 24), Math.toRadians(90))

                .splineTo(new Vector2d(-56, 48), Math.toRadians(90))
                .splineTo(new Vector2d(-56, 24), Math.toRadians(90));*/

        waitForStart();
        openGrabber.setPosition(0.1);
        sleep(500);

        //shoulderLeft1.setPosition(0.2);
        //shoulderRight1.setPosition(0.8);

        wrist.setPosition(1);

        turnGrabber.setPosition(0.8);

        //Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(myTraj4));
        Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(myTraj1));

        //sleep(200);

        /*if (slideythingy1.getCurrentPosition() < 800)
        {
            while (slideythingy1.getCurrentPosition() < 800)
            {
                slideythingy1.setPower(1);
            }
            slideythingy1.setPower(0);
        }*/

sleep(5000);
        Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(myTraj2));
        sleep(500);
        wrist.setPosition(0.45);
        sleep(500);


        /*if (slideythingy1.getCurrentPosition() > 500)
        {
            while (slideythingy1.getCurrentPosition() > 500)
            {
                slideythingy1.setPower(-1);
            }

            slideythingy1.setPower(0);

        }*/
        openGrabber.setPosition(0.5);
        sleep(500);
        //shoulderLeft1.setPosition(0.15);
        //shoulderRight1.setPosition(0.85);
        //sleep(500);

        Actions.runBlocking(new com.acmerobotics.roadrunner.SequentialAction(pushThings));

        //wrist.setPosition(1.0);``
        //openGrabber.setPosition(0.0);
        //shit1.setPosition(0.5);
        //shit2.setPosition(0.5);

        //sleep(1000);
        if(isStopRequested()){
            return;
        }
        //shit1.setPosition(0.5);
        //shit2.setPosition(0.5);

        //sleep(1000);

        /*shit1.setPosition(0.5);
        shit2.setPosition(0.5);
        sleep(500);
        openGrabber.setPosition(0.2);
        turnGrabber.setPosition(0.35);
        sleep(1000);
        shit1.setPosition(0.23);
        shit2.setPosition(0.77);
        openGrabber.setPosition(0.0);
        sleep(500);
        shit1.setPosition(0.7);
        shit2.setPosition(0.3);*/
        //Actions.runBlocking(
        //new SequentialAction(trajToBucket)
        //);
        //shit1.setPosition(0.7);
        //shit2.setPosition(0.3);
        //sleep(500);






        //Servo movement forever


    }
}
