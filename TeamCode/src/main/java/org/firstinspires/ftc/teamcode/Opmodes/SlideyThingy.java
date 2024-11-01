package org.firstinspires.ftc.teamcode.Opmodes;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.GeneralHardwareMap;
import org.firstinspires.ftc.teamcode.MecanumDrive;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@TeleOp(name = "LinearSlide", group = "slide")
public class SlideyThingy extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor slideythingy1;
    private Servo openGrabber;
    private Servo turnGrabber;
    private Servo wrist;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        slideythingy1  = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy1.setDirection(DcMotor.Direction.FORWARD);
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
        wrist = hardwareMap.get(Servo.class, "wrist");

        waitForStart();
        runtime.reset();

        while(opModeIsActive())
        {
            double slidePower1 = 0.5;
            double stop = 0.0;


            if (gamepad1.x)
            {
                slideythingy1.setDirection(DcMotorSimple.Direction.FORWARD);
                slideythingy1.setPower(slidePower1);
            }
            else if (gamepad1.y)
            {
                slideythingy1.setDirection(DcMotorSimple.Direction.REVERSE);
                slideythingy1.setPower(slidePower1);
            }
            else
            {
                slideythingy1.setPower(stop);
            }

            if (gamepad1.b)
            {
                openGrabber.setPosition(0.6);
            }
            if (gamepad1.dpad_up)
            {
                turnGrabber.setPosition(0.6);
            }
            if (gamepad1.dpad_down)
            {
                wrist.setPosition(0.1);
            }
            if (gamepad1.a)
            {
                openGrabber.setPosition(0.0);
                turnGrabber.setPosition(0.0);
                //wrist.setPosition(0.0);
            }

        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Slide", "extend");
        telemetry.update();
    }
}
