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
@TeleOp(name = "Colors Sensed", group = "Sensor")
public class colorsSensed extends LinearOpMode {

    // Hardware map object
    GeneralHardwareMap gHMap = new GeneralHardwareMap(this);
    private ColorSensor colorSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the hardware map and color sensor
        gHMap.init("T");
        colorSensor = gHMap.colorWHAT;

        // Display initialization status
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // HSV array to store color sensor values
        float hsvValues[] = {0F, 0F, 0F};
        final float values[] = hsvValues;

        // Access the layout to change background color
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);

        // LED control variables
        boolean bPrevState = false;
        boolean bLedOn = true;
        colorSensor.enableLed(bLedOn); // Turn on LED initially

        waitForStart(); // Wait for the game to start

        // Main loop
        while (opModeIsActive()) {

            // Toggle LED with gamepad1.x button
            boolean bCurrState = gamepad1.x;
            if (bCurrState && (bCurrState != bPrevState)) {
                bLedOn = !bLedOn;
                colorSensor.enableLed(bLedOn);
            }
            bPrevState = bCurrState;

            // Convert RGB values to HSV values
            Color.RGBToHSV(colorSensor.red() * 8, colorSensor.green() * 8, colorSensor.blue() * 8, hsvValues);

            // Telemetry data display
            telemetry.addData("LED", bLedOn ? "On" : "Off");
            telemetry.addData("Clear", colorSensor.alpha());
            telemetry.addData("Red  ", colorSensor.red());
            telemetry.addData("Green", colorSensor.green());
            telemetry.addData("Blue ", colorSensor.blue());
            telemetry.addData("Hue", hsvValues[0]);
            telemetry.update();

            // Change background color based on detected hue
            relativeLayout.post(() -> relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values)));
        }

        // Reset the background color to white when done
        relativeLayout.post(() -> relativeLayout.setBackgroundColor(Color.WHITE));
    }
}
