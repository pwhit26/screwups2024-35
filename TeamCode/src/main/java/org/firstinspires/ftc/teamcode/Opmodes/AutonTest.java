package org.firstinspires.ftc.teamcode.Opmodes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.GeneralHardwareMap;

@Autonomous
public class AutonTest extends LinearOpMode{
    Servo slideLAngle;
    static final double arm_home = 0.0;
    static final double arm_min = 0.0;
    static final double arm_max = 0.5;


    @Override
    public void runOpMode() throws InterruptedException {
        slideLAngle = hardwareMap.get(Servo.class, "slideLAngle");
        while (opModeInInit()) {

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Servo movement");

            waitForStart();
        }
        //Servo movement forever
        while (opModeIsActive())
        {
            slideLAngle.setPosition(arm_home);
            sleep(1000);
            slideLAngle.setPosition(arm_max);
            sleep(1000);
            slideLAngle.setPosition(arm_home);
            telemetry.addData("Status", "moved");
            telemetry.update();
        }

    }
}
