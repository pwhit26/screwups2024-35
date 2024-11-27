package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.GeneralHardwareMap;

@TeleOp(name = "freakset")
public class freakset extends LinearOpMode {
    private DcMotor slideythingy;
    public void runOpMode() throws InterruptedException {
        slideythingy = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
