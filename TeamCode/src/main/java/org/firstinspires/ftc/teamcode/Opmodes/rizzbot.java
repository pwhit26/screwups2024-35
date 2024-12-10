package org.firstinspires.ftc.teamcode.Opmodes;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MecanumDrive;
@TeleOp(name = "rizzbot", group = "Teleop")
public class rizzbot extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor slideythingy1;
    private Servo openGrabber;
    private Servo turnGrabber;
    private boolean y2Pressable;
    private boolean yLast;
    private Servo wrist;
    private boolean a2Pressable;
    private boolean aLast;
    private Servo shoulderLeft1, shoulderRight1;
    private DcMotor left1;
    private DcMotor left2;
    private DcMotor right1;
    private DcMotor right2;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        slideythingy1 = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //IF PROBLEM CHANGE TO RUN_TO_POSITION
        slideythingy1.setDirection(DcMotor.Direction.REVERSE);
        slideythingy1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        openGrabber.setPosition(0.0);
        turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
        turnGrabber.setPosition(0.8);
        wrist = hardwareMap.get(Servo.class, "wrist");
        wrist.setPosition(0.52);
        shoulderLeft1 = hardwareMap.get(Servo.class, "shit2");
        shoulderLeft1.setPosition(0.05);
        shoulderRight1 = hardwareMap.get(Servo.class, "shit1");
        shoulderRight1.setPosition(0.95);
        left1 = hardwareMap.get(DcMotor.class, "leftFront");
        left2 = hardwareMap.get(DcMotor.class, "leftBack");
        right1 = hardwareMap.get(DcMotor.class, "rightFront");
        right2 = hardwareMap.get(DcMotor.class, "rightBack");
        y2Pressable = false;
        a2Pressable = false;
        yLast = false;
        aLast = false;

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double slidePower1 = 1.0;
            double stop = 0.0;
            double leftPower;
            double rightPower;
            /*double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
            left1.setPower(leftPower);
            left2.setPower(leftPower);
            right1.setPower(rightPower);
            right2.setPower(rightPower);*/
            //DRIVE
            drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(
                            -gamepad1.right_stick_y,
                            -gamepad1.right_stick_x
                    ),
                    -gamepad1.left_stick_x
            ));

            drive.updatePoseEstimate();

            //SLIDE
            if (gamepad2.dpad_up && slideythingy1.getCurrentPosition() < 2695) {
                slideythingy1.setPower(slidePower1);
            } else if (gamepad2.dpad_down && slideythingy1.getCurrentPosition() > 0) {
                slideythingy1.setPower(-slidePower1);
            } else {
                slideythingy1.setPower(stop);
            }

            //SHOULDER

            if (gamepad1.x && !gamepad1.b && !gamepad1.a && !gamepad1.y)
            {
                shoulderLeft1.setPosition(0.05);
                shoulderRight1.setPosition(0.95);
            }
            else if (gamepad1.b && !gamepad1.x && !gamepad1.a && !gamepad1.y)
            {
                shoulderLeft1.setPosition(0.07);
                shoulderRight1.setPosition(0.93);
            }
            else if (gamepad1.a && !gamepad1.b && !gamepad1.x && !gamepad1.y)
            {
                shoulderLeft1.setPosition(0.35);
                shoulderRight1.setPosition(0.65);

            }
            else if (gamepad1.y && !gamepad1.b && !gamepad1.a && !gamepad1.x)
            {
                shoulderLeft1.setPosition(0.02);
                shoulderRight1.setPosition(0.98);
            }

            if (gamepad1.right_trigger < 0.15) {
                shoulderLeft1.setPosition(shoulderLeft1.getPosition() - 0.05 * gamepad1.right_trigger);
                shoulderRight1.setPosition(shoulderRight1.getPosition() + 0.05 * gamepad1.right_trigger);
            } else if (gamepad1.right_trigger > 0.15) {
                shoulderLeft1.setPosition(shoulderLeft1.getPosition() - 0.05 * gamepad1.right_trigger);
                shoulderRight1.setPosition(shoulderRight1.getPosition() + 0.05 * gamepad1.right_trigger);
            }

            //OPEN GRABBER
            if (gamepad2.b)
            {
                openGrabber.setPosition(0.25);
            }
            else {
                openGrabber.setPosition(0.0);
            }

            //TURN GRABBER
            if (gamepad2.y && !yLast) {
                y2Pressable = !y2Pressable;
            }

            if (y2Pressable) {
                turnGrabber.setPosition(0.0);
            }
            else {
                turnGrabber.setPosition(0.8);
            }

            yLast = gamepad2.y;

            //WRIST
            if (gamepad2.a && !aLast) {
                a2Pressable = !a2Pressable;
            }

            if (a2Pressable) {
                wrist.setPosition(1.0);
            }
            else {
                wrist.setPosition(0.52);
            }

            aLast = gamepad2.a;

            telemetry.addData("Slide", "extend");
            telemetry.addData("Slide", slideythingy1.getCurrentPosition());
            telemetry.addData("shoulder", " " + shoulderLeft1.getPosition());
            telemetry.addData("Grabber up/down at position:", " " + wrist.getPosition());
            telemetry.addData("Grabber turned at position:", " " + turnGrabber.getPosition());
            telemetry.addData("Grabber open at position:", " " + openGrabber.getPosition());
            telemetry.addData("x", drive.pose.position.x);
            telemetry.addData("y", drive.pose.position.y);
            telemetry.addData("heading (deg)", Math.toDegrees(drive.pose.heading.toDouble()));
            telemetry.update();
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());

        telemetry.update();

    }
}
