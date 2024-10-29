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

@TeleOp(name = "teleopServo", group = "servo")
public class TeleopServo extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor left1;
    private DcMotor left2;
    private DcMotor right1;
    private DcMotor right2;
    private Servo arm;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        left1  = hardwareMap.get(DcMotor.class, "leftFront");
        left2  = hardwareMap.get(DcMotor.class, "leftBack");
        right1 = hardwareMap.get(DcMotor.class, "rightFront");
        right2 = hardwareMap.get(DcMotor.class, "rightBack");
        arm = hardwareMap.get(Servo.class, "slideLAngle");
        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        left1.setDirection(DcMotor.Direction.FORWARD);
        left2.setDirection(DcMotor.Direction.FORWARD);
        right1.setDirection(DcMotor.Direction.REVERSE);
        right2.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            if (gamepad1.a) {
                arm.setPosition(0.12);
            }
            else if (gamepad1.b) {
                arm.setPosition(1);
            }
            else{
                arm.setPosition(0.0);
            }
            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            // leftPower  = -gamepad1.left_stick_y ;
            // rightPower = -gamepad1.right_stick_y ;

            // Send calculated power to wheels
            left1.setPower(leftPower);
            left2.setPower(leftPower);
            right1.setPower(rightPower);
            right2.setPower(rightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
