package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Active intake", group = "slurp")
public class ActiveIntake extends LinearOpMode {
    private CRServo active;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        active = hardwareMap.get(CRServo.class, "activeIn");

        waitForStart();
        runtime.reset();

        while (opModeIsActive())
        {
            if (gamepad1.a)
            {
                active.setDirection(CRServo.Direction.FORWARD);
                active.setPower(1.0);
            }
            else if (gamepad1.b)
            {
                active.setDirection(CRServo.Direction.REVERSE);
                active.setPower(1.0);
            }
            else
            {
                active.setDirection(CRServo.Direction.FORWARD);
                active.setPower(0);
            }

        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("active intake", "slurp");
        telemetry.update();
    }
}
