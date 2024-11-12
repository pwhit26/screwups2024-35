package org.firstinspires.ftc.teamcode.AutonStuff;

//ROADRUNNER SPECIFIC IMPORTS
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.SP;

@Autonomous
@Config
public class babysFirstAuton extends LinearOpMode {

    public double head = Math.toRadians(90);
    @Override
    public void runOpMode() throws InterruptedException {
        SP stdPos = new SP();
        stdPos.initializeStandardPoints("Blue","Net");

    }
}