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
        private Servo wrist;
        private Servo shoulderLeft1, shoulderRight1;
        private DcMotor left1;
        private DcMotor left2;
        private DcMotor right1;
        private DcMotor right2;
        private boolean turnGrab = true;
        private boolean wristBool = true;


        @Override
        public void runOpMode() throws InterruptedException {
            telemetry.addData("Status", "Initialized");
            telemetry.update();
            slideythingy1 = hardwareMap.get(DcMotor.class, "slide1");
            slideythingy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //IF PROBLEM CHANGE TO RUN_TO_POSITION
            slideythingy1.setDirection(DcMotor.Direction.REVERSE);
            slideythingy1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            slideythingy1.setTargetPosition(0);
            openGrabber = hardwareMap.get(Servo.class, "openGrabber");
            openGrabber.setPosition(0.0);
            turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
            openGrabber.setPosition(0.35);
            wrist = hardwareMap.get(Servo.class, "wrist");
            wrist.setPosition(0.6);
            shoulderLeft1 = hardwareMap.get(Servo.class, "shit2");
            shoulderLeft1.setPosition(0.3);
            shoulderRight1 = hardwareMap.get(Servo.class, "shit1");
            shoulderRight1.setPosition(0.7);
            left1 = hardwareMap.get(DcMotor.class, "leftFront");
            left2 = hardwareMap.get(DcMotor.class, "leftBack");
            right1 = hardwareMap.get(DcMotor.class, "rightFront");
            right2 = hardwareMap.get(DcMotor.class, "rightBack");

            MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

            waitForStart();
            runtime.reset();

            while (opModeIsActive()) {
                double slidePower1 = 0.8;
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

                drive.setDrivePowers(new PoseVelocity2d(
                        new Vector2d(
                                -gamepad1.right_stick_y,
                                -gamepad1.right_stick_x
                        ),
                        -gamepad1.left_stick_x
                ));

                drive.updatePoseEstimate();

                if (gamepad2.b) {
                    openGrabber.setPosition(0.2);

                } else {
                    openGrabber.setPosition(0.0);
                }


                if (gamepad2.dpad_up && slideythingy1.getCurrentPosition() < 3400) {
                    slideythingy1.setPower(slidePower1);
                } else if (gamepad2.dpad_down && slideythingy1.getCurrentPosition() > 0) {
                    slideythingy1.setPower(-slidePower1);
                } else {
                    slideythingy1.setPower(stop);
                }

                if (gamepad1.x && !gamepad1.b && !gamepad1.a && !gamepad1.y)
                {
                    shoulderLeft1.setPosition(0.25);
                    shoulderRight1.setPosition(0.75);
                }
                else if (gamepad1.b && !gamepad1.x && !gamepad1.a && !gamepad1.y)
                {
                    shoulderLeft1.setPosition(0.3);
                    shoulderRight1.setPosition(0.7);
                }
                else if (gamepad1.a && !gamepad1.b && !gamepad1.x && !gamepad1.y)
                {
                    shoulderLeft1.setPosition(0.7);
                    shoulderRight1.setPosition(0.3);

                }
                else if (gamepad1.y && !gamepad1.b && !gamepad1.a && !gamepad1.x)
                {
                    shoulderLeft1.setPosition(0.23);
                    shoulderRight1.setPosition(0.77);
                }

                if (gamepad1.right_trigger < 0.15) {
                    shoulderLeft1.setPosition(shoulderLeft1.getPosition() - 0.05 * gamepad1.right_trigger);
                    shoulderRight1.setPosition(shoulderRight1.getPosition() + 0.05 * gamepad1.right_trigger);
                } else if (gamepad1.right_trigger > 0.15) {
                    shoulderLeft1.setPosition(shoulderLeft1.getPosition() - 0.05 * gamepad1.right_trigger);
                    shoulderRight1.setPosition(shoulderRight1.getPosition() + 0.05 * gamepad1.right_trigger);
                }
                /*else {
                    shoulderLeft1.setPosition(shoulderLeft1.getPosition());
                    shoulderRight.setPosition(shoulderRight.getPosition());
                }*/


                if (gamepad2.y) {
                    turnGrab = !turnGrab;
                    if (turnGrab) {
                        turnGrabber.setPosition(0.0);
                    } else if (turnGrab == false) {
                        turnGrabber.setPosition(0.35);
                    }

                }
                if (gamepad2.a) {
                    wristBool = !wristBool;
                    if (wristBool) {
                        wrist.setPosition(1.0);
                    } else if (wristBool == false) {
                        wrist.setPosition(0.6);
                        //wrist.set
                    }


                }
            /*if (gamepad1.a)
            {
                openGrabber.setPosition(0.0);
                turnGrabber.setPosition(0.95);
                wrist.setPosition(0.05);
            }*/


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
