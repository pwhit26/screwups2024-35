package org.firstinspires.ftc.teamcode.Opmodes;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name = "checkColor", group = "Sensor")
public class checkColor extends LinearOpMode {

    private ColorSensor colorSensor;

    @Override
    public void runOpMode() {
        // Initialize the color sensor from hardware map
        colorSensor = hardwareMap.get(ColorSensor.class, "colorWHAT");

        // Display initialization status
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Variable to track LED state and initialize it as ON
        boolean ledOn = true;
        colorSensor.enableLed(ledOn);

        waitForStart();

        // Main loop
        while (opModeIsActive()) {

            // Toggle LED on pressing the "X" button
            if (gamepad1.x) {
                ledOn = !ledOn;
                colorSensor.enableLed(ledOn);
                sleep(200); // Small delay to prevent multiple toggles
            }

            // Create an array to store HSV values
            float hsvValues[] = {0F, 0F, 0F};

            // Convert RGB to HSV and scale up values for better color detection
            Color.RGBToHSV(
                    (int) (colorSensor.red() * 8),
                    (int) (colorSensor.green() * 8),
                    (int) (colorSensor.blue() * 8),
                    hsvValues
            );

            // Display RGB, Alpha, and HSV values on telemetry
            telemetry.addData("LED", ledOn ? "On" : "Off");
            telemetry.addData("Red  ", colorSensor.red());
            telemetry.addData("Green", colorSensor.green());
            telemetry.addData("Blue ", colorSensor.blue());
            telemetry.addData("Alpha", colorSensor.alpha());
            telemetry.addData("Hue", hsvValues[0]);
            telemetry.update();
        }
    }
}
