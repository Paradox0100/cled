package frc.robot.commands.auto;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import org.northernforce.commands.NFRSwerveDriveStop;
import org.northernforce.commands.NFRSwerveModuleSetState;
import org.northernforce.subsystems.drive.NFRSwerveDrive;

import com.pathplanner.lib.controllers.PPHolonomicDriveController;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.NFRSwerveDriveFollowPath;
import frc.robot.utils.AutonomousRoutine;

public class S2T extends SequentialCommandGroup{
    protected static final PathPlannerPath[] paths = new PathPlannerPath[] {
        PathPlannerPath.fromPathFile("S2.T1_start"),
        PathPlannerPath.fromPathFile("S2.T1_end"),
        PathPlannerPath.fromPathFile("S2.T2_start"),
        PathPlannerPath.fromPathFile("S2.T2_end"),
        PathPlannerPath.fromPathFile("S2.T3_start"),
        PathPlannerPath.fromPathFile("S2.T3_end"),
        PathPlannerPath.fromPathFile("S2.T4_start"),
        PathPlannerPath.fromPathFile("S2.T4_end")
    };
    public S2T(NFRSwerveDrive drive, NFRSwerveModuleSetState[] setStateCommands, Supplier<Pose2d> poseSupplier,
        PPHolonomicDriveController controller, BooleanSupplier shouldFlipPath, boolean ignoreCommands)
    {
        addCommands(
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[0], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[1], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[2], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[3], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[4], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[5], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[6], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveFollowPath(drive, setStateCommands, paths[7], poseSupplier, controller,
                () -> Rotation2d.fromDegrees(0), 0.1, shouldFlipPath, ignoreCommands),
            new NFRSwerveDriveStop(drive, setStateCommands, true)
        );

    }
    /**
     * Gets the AutonomousRoutine struct for S1CSV1
     * @param drive the drive subsystem
     * @param setStateCommands the commands to run each module
     * @param poseSupplier the supplier for pose estimation
     * @param controller the controller for following the path
     * @param shouldFlipPath whether to flip the routine based on alliance
     * @return an AutonomousRoutine for S1CSV1
     */
    public static AutonomousRoutine getRoutine(NFRSwerveDrive drive, NFRSwerveModuleSetState[] setStateCommands,
        Supplier<Pose2d> poseSupplier, PPHolonomicDriveController controller, BooleanSupplier shouldFlipPath, boolean ignoreCommands)
    {
        return new AutonomousRoutine(S2T.class.getSimpleName(),
            () -> shouldFlipPath.getAsBoolean() ? paths[0].flipPath().getPreviewStartingHolonomicPose() : paths[0].getPreviewStartingHolonomicPose(),
            new S2T(drive, setStateCommands, poseSupplier, controller, shouldFlipPath, ignoreCommands));
    }
}
