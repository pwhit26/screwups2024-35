package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class OppMode extends LinearOpMode { ;
    private Servo fakeservoTest;

    @Override
    public void runOpMode() throws InterruptedException {
        fakeservoTest = hardwareMap.get(Servo.class, "slideLAngle");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            if(gamepad1.y) {
                // move to 0 degrees.
                fakeservoTest.setPosition(0);
            } else if (gamepad1.b) {
                // move to 90 degrees.
                fakeservoTest.setPosition(0.5);
            } else if (gamepad1.a) {
                // move to 180 degrees.
                fakeservoTest.setPosition(1);
            }
            telemetry.addData("Servo Position", fakeservoTest.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
