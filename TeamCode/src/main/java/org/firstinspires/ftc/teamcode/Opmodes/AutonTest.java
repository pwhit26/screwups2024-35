package org.firstinspires.ftc.teamcode.Opmodes;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.MecanumKinematics;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TimeTrajectory;
import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.GeneralHardwareMap;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "AutonTest", group = "Test1")
public class AutonTest extends LinearOpMode{



    Action myTraj1;
    Action trajSpline1;
    Action trajToBucket;
    Servo shit1;
    Servo shit2;
    private Servo wrist;
    private Servo openGrabber;
    private Servo turnGrabber;






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
        Vector2d myVector = new Vector2d(-48,55);
        Vector2d second = new Vector2d(-55, 63);
        Pose2d myPose = new Pose2d(0, 72, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
        shit2 = hardwareMap.get(Servo.class, "shit2");
        shit1 = hardwareMap.get(Servo.class, "shit1");
        wrist = hardwareMap.get(Servo.class, "wrist");
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");


        myTraj1 = drive.actionBuilder(new Pose2d(0, 72, Math.toRadians(90)))
                .strafeTo(myVector)
                .build();
        trajToBucket = drive.actionBuilder(new Pose2d(-48, 55, Math.toRadians(90)))
                .strafeTo(second)
                .build();
        trajSpline1 = drive.actionBuilder(new Pose2d(0, 72, Math.toRadians(90)))
                .splineTo(new Vector2d(-48, 55), Math.toRadians(90))
                .build();



        /*leftFront  = hardwareMap.get(DcMotor.class, "leftFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftBack  = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        //slideLAngle = hardwareMap.get(Servo.class, "slideLAngle");
        //Pose2d myPose = new Pose2d(0, -50, Math.toRadians(90));
        //MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
        //Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d(0, -50, Math.toRadians(90))).forward(5);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/


        // Send telemetry message to signify robot waiting;


            waitForStart();
            wrist.setPosition(1.0);
            openGrabber.setPosition(0.0);
            shit1.setPosition(0.5);
            shit2.setPosition(0.5);

        sleep(1000);
        if(isStopRequested()){
            return;
        }
        shit1.setPosition(0.5);
        shit2.setPosition(0.5);
        Actions.runBlocking(
                new SequentialAction(myTraj1)
        );

        shit1.setPosition(0.5);
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
        shit2.setPosition(0.3);
        Actions.runBlocking(
                new SequentialAction(trajToBucket)
        );
        shit1.setPosition(0.7);
        shit2.setPosition(0.3);
        sleep(500);






        //Servo movement forever


    }
}
