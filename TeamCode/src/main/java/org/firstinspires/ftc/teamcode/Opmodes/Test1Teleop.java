package org.firstinspires.ftc.teamcode.Opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@TeleOp(name = "Test1Teleop", group = "test1")
public class Test1Teleop extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor slideythingy1;
    private Servo openGrabber;
    private Servo turnGrabber;
    private Servo wrist;
    private Servo shoulderLeft;
    private Servo shoulderRight;
    private DcMotor left1;
    private DcMotor left2;
    private DcMotor right1;
    private DcMotor right2;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        slideythingy1  = hardwareMap.get(DcMotor.class, "slide1");
        slideythingy1.setDirection(DcMotor.Direction.REVERSE);
        slideythingy1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideythingy1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        openGrabber = hardwareMap.get(Servo.class, "openGrabber");
        turnGrabber = hardwareMap.get(Servo.class, "turnGrabber");
        wrist = hardwareMap.get(Servo.class, "wrist");
        shoulderLeft = hardwareMap.get(Servo.class, "shit2");
        shoulderRight= hardwareMap.get(Servo.class, "shit1");
        left1  = hardwareMap.get(DcMotor.class, "leftFront");
        left2  = hardwareMap.get(DcMotor.class, "leftBack");
        right1 = hardwareMap.get(DcMotor.class, "rightFront");
        right2 = hardwareMap.get(DcMotor.class, "rightBack");

        waitForStart();
        runtime.reset();

        while (opModeIsActive())
        {
            double slidePower1 = 0.5;
            double stop = 0.0;
            double leftPower;
            double rightPower;
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            double grabTurn = gamepad2.right_trigger;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;


            if (gamepad1.dpad_up && slideythingy1.getCurrentPosition() < 3400)
            {
                slideythingy1.setPower(slidePower1);
            }
            else if (gamepad1.dpad_down && slideythingy1.getCurrentPosition() > 0)
            {
                slideythingy1.setPower(-slidePower1);
            }
            else
            {
                slideythingy1.setPower(stop);
            }

            if (gamepad1.x)
            {
                shoulderRight.setPosition(0.7);
                shoulderLeft.setPosition(0.3);
            }
            else if (gamepad1.y)
            {
                shoulderRight.setPosition(0.2);
                shoulderLeft.setPosition(0.8);
            }

            if (gamepad2.left_bumper)
            {
                openGrabber.setPosition(0.4);
            }
            else
            {
                openGrabber.setPosition(0.0);
            }


            if (gamepad2.b)
            {
                wrist.setPosition(0.5);

            }
            else if (gamepad2.a)
            {
                wrist.setPosition(0.0);
            }


            left1.setPower(leftPower);
            left2.setPower(leftPower);
            right1.setPower(rightPower);
            right2.setPower(rightPower);
            turnGrabber.setPosition(grabTurn);


            telemetry.addData("Slide", "extend");
            telemetry.addData("Slide", slideythingy1.getCurrentPosition());
            telemetry.addData("Grabber up/down at position:", " " + wrist.getPosition());
            telemetry.addData("Grabber turned at position:", " " + turnGrabber.getPosition());
            telemetry.addData("Grabber open at position:", " " + openGrabber.getPosition());
            telemetry.update();
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());

        telemetry.update();

    }
}
