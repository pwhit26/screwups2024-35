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

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        slideythingy1  = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy1.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while(opModeIsActive())
        {
            double slidePower = 0.5;
            double stop = 0.0;


            if (gamepad1.x)
            {
                slideythingy1.setDirection(DcMotorSimple.Direction.FORWARD);
                slideythingy1.setPower(slidePower);
            }
            else if (gamepad1.y)
            {
                slideythingy1.setDirection(DcMotorSimple.Direction.REVERSE);
                slideythingy1.setPower(slidePower);
            }
            else
            {
                slideythingy1.setPower(stop);
            }
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Slide", "extend");
        telemetry.update();
    }
}
