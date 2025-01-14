package com.example.meepmeeptesting2;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting2 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                //REB
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(24, -60, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(-46, -45, Math.toRadians(45)))
                        .turn(Math.toRadians(45))
                        .forward(5)
                        .back(5)
                        .turn(Math.toRadians(-45))
                        .turn(Math.toRadians(45))
                        .strafeLeft(12)
                        .forward(5)
                        .lineToLinearHeading(new Pose2d(-46, -45, Math.toRadians(45)))
                        .turn(Math.toRadians(45))
                        .strafeLeft(12)
                        .forward(5)
                        .turn(Math.toRadians(40))
                        .lineToLinearHeading(new Pose2d(-46, -45, Math.toRadians(45)))
                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}