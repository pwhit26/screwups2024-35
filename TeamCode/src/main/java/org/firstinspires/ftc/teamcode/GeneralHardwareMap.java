package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Predicate;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;


import java.util.ArrayList;
import java.util.Arrays;
@Config
public class GeneralHardwareMap {

    //h


        //Define runtime
        public ElapsedTime runtime = new ElapsedTime();

        //Define opMode

        public OpMode opMode;


        //Define all hardware
        public VoltageSensor batteryVoltageSensor;
        public DcMotor frontLeft, frontRight, backLeft, backRight, slide;
        public DcMotor slurp;
        //public Servo arm;
        public final static double slideLAngle_HOME = 0.0;
        public final static double slideLAngle_MIN_RANGE = 0.0;
        public final static double slideLAngle_MAX_RANGE = 0.5;
        //public Servo clawHAngle, clawVAngle, slideRAngle, clawL, clawR, plane;
        public WebcamName bonoboCam;
        public Servo slideLAngle;
        public HuskyLens huskyLens;
        public DistanceSensor distanceSensor;
        public ColorSensor colorSensorCenter;
        public ColorSensor colorSensorLeft;
        public ColorSensor colorSensorRight;
        public BNO055IMU gyro;//Can we do it?

        public boolean halfSpeedToggle = true;
        public boolean aLast = false;


        public boolean drivingReverse = false;
        public boolean yLast = false;



        public double yMovement;
        public double xMovement;
        public double rotation;
        public double drivePower;
        public double slidePower;
        public static double pos;
        public Telemetry telemetry;
        public static double stackNum = 0;


        public GeneralHardwareMap(OpMode opMode) {
            this.opMode = opMode;
        }

        public GeneralHardwareMap(LinearOpMode opMode) {this.opMode = opMode;}

        public void initRANDOMOTOR(String motorName) {
            slurp = this.opMode.hardwareMap.dcMotor.get(motorName);
            slurp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        }

        public void initServo(String servoName) {
            slideLAngle = this.opMode.hardwareMap.servo.get(servoName);
        }
        /*
        public double getColor() {
            int red = colorSensor.red();
            int blue = colorSensor.blue();
            int green = colorSensor.green();
            if(red > 200 && green > 200 && blue < 100){return 1;}//Yellow
            if(red > 200 && green < 100 && blue < 100){return 2;}//Red
            if(red < 100 && green < 100 && blue > 200){return 3;}//Blue
            //if(red < 100 && green < 100 && blue > 200){return 1;}MAKE A GREY
            else{return 0;}

        }
        */



        public void init(String opModeType) {

            //Always intialize these
            huskyLens = this.opMode.hardwareMap.get(HuskyLens.class, "huskylens");
            distanceSensor = this.opMode.hardwareMap.get(DistanceSensor.class, "distanceSensor");
            colorSensorCenter = this.opMode.hardwareMap.get(ColorSensor.class, "colorSensorCenter");
            colorSensorLeft = this.opMode.hardwareMap.get(ColorSensor.class, "colorSensorRight");
            colorSensorRight = this.opMode.hardwareMap.get(ColorSensor.class, "colorSensorLeft");

            VoltageSensor batteryVoltageSensor = this.opMode.hardwareMap.voltageSensor.iterator().next();

            pos = 0.8;
            //Initialize motors only if in teleOp
            if(opModeType.equals("TELEOP")) {
                //slideLAngle = this.opMode.hardwareMap.servo.get("slideLAngle");
                //slideLAngle.setPosition(slideLAngle_HOME);
                //slideLAngle.setPosition(slideLAngle_MAX_RANGE);

                frontLeft = this.opMode.hardwareMap.dcMotor.get("frontLeft");
                frontLeft.setDirection(DcMotor.Direction.REVERSE);
                frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

                frontRight = this.opMode.hardwareMap.dcMotor.get("frontRight");
                frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

                backLeft = this.opMode.hardwareMap.dcMotor.get("backLeft");
                backLeft.setDirection(DcMotor.Direction.REVERSE);
                backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

                backRight = this.opMode.hardwareMap.dcMotor.get("backRight");
                backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            }





            //telemetry.addData("Battery Voltage: ", batteryVoltageSensor.getVoltage());
            //telemetry.update();
        }

        public double averageLastContents(ArrayList<Double> arr, int LOOKBACK){
            int len = arr.size();
            int count = Math.min(len, LOOKBACK);
            double sum = 0;
            for(int i = len - count; i < len; i++){
                sum += arr.get(i);
            }
            return sum/count;
        }


    /*
    public void initForApril(){
        WebcamName bonoboCam = hardwareMap.get(WebcamName.class, "Webcam 1");
    }

     */



    }


