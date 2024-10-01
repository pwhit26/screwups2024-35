package org.firstinspires.ftc.teamcode.Opmodes;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.GeneralHardwareMap;


@Config
@TeleOp(name = "ColorTest", group = "Sensor")
public class MattMotor extends LinearOpMode {


    GeneralHardwareMap gHMap = new GeneralHardwareMap(this);


    ColorSensor colorSensor;    // Hardware Device Object


    @Override
    public void runOpMode() throws InterruptedException {
        gHMap.initRANDOMOTOR("slideMotor");


        // wait for the start button to be pressed.
        waitForStart();

        // while the OpMode is active, loop and read the RGB data.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive()) {

            // check the status of the x button on either gamepad.
            if (gamepad1.dpad_up) {
                gHMap.slurp.setPower(0.1);
            }
            else if (gamepad1.dpad_down) {
                gHMap.slurp.setPower(0.1);
            }
            else{
                gHMap.slurp.setPower(0);
            }


        }
    }
}

