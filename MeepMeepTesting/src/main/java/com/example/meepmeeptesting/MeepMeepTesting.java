package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(80, 70, Math.toRadians(90), Math.toRadians(90), 12)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(24, -65, Math.toRadians(90)))
                        //.waitSeconds(0.1)
                        .lineToLinearHeading(new Pose2d(10, -32, Math.toRadians(90)))
                        .waitSeconds(0.5)
                        .lineToLinearHeading(new Pose2d(38, -35, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(38, -13, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(48, -13, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(48, -54, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(48, -13, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(63, -13, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(63, -54, Math.toRadians(90)))
                        //.lineToLinearHeading(new Pose2d(63, -13, Math.toRadians(90)))
                        //.lineToLinearHeading(new Pose2d(62, -13, Math.toRadians(90)))
                        //.lineToLinearHeading(new Pose2d(62, -54, Math.toRadians(90)))
                        .waitSeconds(0.05)
                        .lineToLinearHeading(new Pose2d(48, -57, Math.toRadians(270)))
                        .waitSeconds(0.8)
                        .lineToLinearHeading(new Pose2d(10, -32, Math.toRadians(90)))//10
                        .waitSeconds(0.5)
                        .lineToLinearHeading(new Pose2d(48, -57, Math.toRadians(270)))
                        .waitSeconds(0.8)
                        .lineToLinearHeading(new Pose2d(10, -32, Math.toRadians(90)))
                        .waitSeconds(0.5)
                        .lineToLinearHeading(new Pose2d(48, -57, Math.toRadians(270)))
                        .waitSeconds(0.8)
                        .lineToLinearHeading(new Pose2d(10, -32, Math.toRadians(90)))
                        .waitSeconds(0.5)
                        .lineToLinearHeading(new Pose2d(35, -32, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(25, -5, Math.toRadians(90)))
                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}