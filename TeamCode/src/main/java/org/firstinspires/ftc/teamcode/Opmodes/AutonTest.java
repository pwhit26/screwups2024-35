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



    Action myTraj;
    Servo shit1;
    Servo shit2;






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
        Vector2d myVector = new Vector2d(20, 0);
        Pose2d myPose = new Pose2d(10, -5, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, myPose);
        shit2 = hardwareMap.get(Servo.class, "shit2");
        shit1 = hardwareMap.get(Servo.class, "shit1");

        myTraj = drive.actionBuilder(new Pose2d(0, -5, Math.toRadians(90)))
                .strafeTo(myVector)
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
        shit1.setPosition(0.25);
        shit2.setPosition(0.75);
        sleep(2000);
        if(isStopRequested()){
            return;
        }
        Actions.runBlocking(
                new SequentialAction(myTraj)
        );




        //Servo movement forever


    }
}
