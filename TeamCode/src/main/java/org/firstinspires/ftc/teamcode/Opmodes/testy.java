package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class testy extends LinearOpMode {
    private Servo one;
    private Servo two;
    //private Servo three;
    @Override
    public void runOpMode() throws InterruptedException {
        one = hardwareMap.get(Servo.class, "turnGrabber");
        two = hardwareMap.get(Servo.class, "wrist");
        //three = hardwareMap.get(Servo.class, "openGrabber");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {

            if (gamepad1.y) {
                // move to 0 degrees.
                one.setPosition(0.0);
                two.setPosition(0.6);
                //three.setPosition(0.0);
            }
            else if (gamepad1.x) {
                // move to 90 degrees.
                one.setPosition(0.35);
                two.setPosition(0.6);
                //three.setPosition(0.2);
            }
            telemetry.addData("Servo Position", one.getPosition());
            telemetry.addData("Servo Position", two.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
