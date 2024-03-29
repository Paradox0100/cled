package frc.robot.constants;

import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.subsystems.Xavier.XavierConfiguration;

public class CrabbyConstants {
    public static class Drive {
        public static final Translation2d[] offsets = new Translation2d[] {
            new Translation2d(0.225425, 0.307975),
            new Translation2d(0.225425, -0.307975),
            new Translation2d(-0.225425, 0.307975),
            new Translation2d(-0.225425, -0.307975)
        };
    }
    public static class IntakeConstants
    {
        public static final double intakeSpeed = 1;
        public static final double intakePurgeSpeed = -1;
    }
    public static class XavierConstants
    {
        public static final XavierConfiguration config = new XavierConfiguration("xavier", "note_detection");
    }
}
