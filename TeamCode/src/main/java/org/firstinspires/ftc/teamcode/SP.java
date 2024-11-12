package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;

public class SP {
    public double trackOffset = MecanumDrive.PARAMS.trackWidthTicks*MecanumDrive.PARAMS.inPerTick;
    public static double widthOffset = 8; //recalibrate for new bots (half width)
    public static double lengthOffset = 9; //recalibrate for new bots (half length)

    public static double tile = 24;
    //adjust these 3 for special attachments
    public static double placementRange = lengthOffset + 6;
    public static double intakeRange = lengthOffset + 10;
    public static double diagonalIntakeRange =  Math.sqrt(0.5*Math.pow(intakeRange, 2));

    public static double SpikeWallX, SpikeWallY, SpikeWallHeading;
    public static double SpikeMidX, SpikeMidY, SpikeMidHeading;
    public static double SpikeSubX, SpikeSubY, SpikeSubHeading;
    public static double ObsZoneStartX, ObsZoneStartY, ObsZoneStartHeading;
    public static double NetZoneStartX, NetZoneStartY, NetZoneStartHeading;
    public static double SpecimenNetX, SpecimenNetY, SpecimenNetHeading;
    public static double SpecimenObsX, SpecimenObsY, SpecimenObsHeading;
    public static double NetFromSpikeX, NetFromSpikeY, NetFromSpikeHeading;
    public static double NetFromObsX, NetFromObsY, NetFromObsHeading;
    public static double NetDiagonalX, NetDiagonalY, NetDiagonalHeading;
    public static double SpecimenPickupX, SpecimenPickupY, SpecimenPickupHeading;
    public static double SamplePickupX, SamplePickupY, SamplePickupHeading;
    public static Pose2d origin = new Pose2d(0,0,0);
    public static Pose2d ObsZoneStart, NetZoneStart, StartZone;
    public static Pose2d SpecimenNet, SpecimenObs;
    public static Pose2d NetFromSpike, NetDiagonal;
    public static Pose2d SpikeWall, SpikeMid, SpikeSub;
    public static Pose2d SpecimenPickup, SamplePickup;
    public static Vector2d ObsZoneStartV, NetZoneStartV, StartZoneV;
    public static Vector2d SpecimenObsV, SpecimenNetV;
    public static Vector2d NetFromSpikeV, NetDiagonalV;
    public static Vector2d SpikeWallV, SpikeMidV, SpikeSubV;
    public static Vector2d SpecimenPickupV, SamplePickupV;
    public double ColorOp = 1;
    public double ColorOp2 = 0;
    public double SideOp = 1;
    public void initializeStandardPoints(String color, String quad){
        if(quad.equals("Net")){
            SideOp = -1;
        }
        if(color.equals("Blue")){
            ColorOp = -1;
            ColorOp2 = 180;
        }
        ObsZoneStartX = (24-lengthOffset)*ColorOp;
        ObsZoneStartY = (-72+widthOffset)*ColorOp;
        ObsZoneStartHeading = Math.toRadians(90)*ColorOp;
        ObsZoneStart = new Pose2d(ObsZoneStartX, ObsZoneStartY, ObsZoneStartHeading);
        ObsZoneStartV = new Vector2d(ObsZoneStartX, ObsZoneStartY);
        NetZoneStartX = (-48+lengthOffset)*ColorOp;
        NetZoneStartY = (-72+widthOffset)*ColorOp;
        NetZoneStartHeading = Math.toRadians(90)*ColorOp;
        NetZoneStart = new Pose2d(NetZoneStartX, NetZoneStartY, NetZoneStartHeading);
        SpecimenNetX = (-12)*ColorOp;
        SpecimenNetY = (-24-placementRange)*ColorOp;
        SpecimenNetHeading = Math.toRadians(270)*ColorOp;
        SpecimenNet = new Pose2d(SpecimenNetX, SpecimenNetY, SpecimenNetHeading);
        SpecimenNetV = new Vector2d(SpecimenNetX, SpecimenNetY);
        SpecimenObsX = 12* ColorOp;
        SpecimenObsY = (-24-placementRange)*ColorOp;
        SpecimenObsHeading = Math.toRadians(270)*ColorOp;
        SpecimenObs = new Pose2d(SpecimenObsX, SpecimenObsY, SpecimenObsHeading);
        SpecimenObsV = new Vector2d(SpecimenObsX, SpecimenObsY);
        NetFromSpikeX = (-72+widthOffset)*ColorOp;
        NetFromSpikeY = (-48)*ColorOp;
        NetFromSpikeHeading = Math.toRadians(90)*ColorOp;
        NetFromSpike = new Pose2d(NetFromSpikeX, NetFromSpikeY, NetFromSpikeHeading);
        NetFromSpikeV = new Vector2d(NetFromSpikeX, NetFromSpikeY);
        NetDiagonalX = (-57)*ColorOp;
        NetDiagonalY = (-57)*ColorOp;
        NetDiagonalHeading = Math.toRadians(45);
        NetDiagonal = new Pose2d(NetDiagonalX, NetDiagonalY, NetDiagonalHeading);
        NetDiagonalV = new Vector2d(NetDiagonalX, NetDiagonalY);
        SpikeWallX = (72)*ColorOp*SideOp;
        SpikeWallY = (-25-intakeRange)*ColorOp;
        SpikeWall = new Pose2d(SpikeWallX, SpikeWallY, Math.toRadians(0));
        SpikeWallV = new Vector2d(SpikeWallX, SpikeWallY);
        SpikeMidX = (60)*ColorOp*SideOp;
        SpikeMidY = (-25-intakeRange)*ColorOp;
        SpikeMid = new Pose2d(SpikeMidX, SpikeMidY, Math.toRadians(0));
        SpikeMidV = new Vector2d(SpikeMidX, SpikeMidY);
        SpikeSubX = 48*ColorOp*SideOp;
        SpikeSubY = (-25-intakeRange)*ColorOp;
        SpikeSub = new Pose2d(SpikeSubX, SpikeSubY, Math.toRadians(0));
        SpikeSubV = new Vector2d(SpikeSubX, SpikeSubY);
        SpecimenPickupX = (48-diagonalIntakeRange)*ColorOp;
        SpecimenPickupY = (-66+diagonalIntakeRange)*ColorOp;
        SpecimenPickupHeading = Math.toRadians(315);
        SpecimenPickup = new Pose2d(SpecimenPickupX, SpecimenPickupY, SpecimenPickupHeading);
        SpecimenPickupV = new Vector2d(SpecimenPickupX, SpecimenPickupY);

        SamplePickupX = (-24)*ColorOp;
        SamplePickupY = (-2-widthOffset)*ColorOp;
        SamplePickupHeading = Math.toRadians(ColorOp2);
        SamplePickup = new Pose2d(SamplePickupX, SamplePickupY, SamplePickupHeading);
        SamplePickupV = new Vector2d(SamplePickupX, SamplePickupY);
        if(quad.equals("Net")){
            StartZone = NetZoneStart;
        }
        else if(quad.equals("Obs")){
            StartZone = ObsZoneStart;
        }




    }


}