//@author: Melissa Chen
//@date: 2025 June 20
//@purpose: Lab 4; stating physics methods and equations

package labs.example.physics;

import java.lang.Math;

public class Physics {
    final static double GRAVITY = 9.81; // m/s^2

    // Distance: x = vt
    public double getDistance(double velocity, double time) {
        return velocity * time;
    }

    // Velocity: v = x/t
    public double getVelocity(double distance, double time) {
        return distance / time;
    }

    // Momentum: ρ = mv
    public double getMomentum(double mass, double velocity) {
        return mass * velocity;
    }

    // Force: F = ma
    public double getForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    // Work: W = fd
    public double getWork(double force, double distance) {
        return force * distance;
    }

    // Kinetic Energy: KE = 1/2 mv²
    public double getKineticEnergy(double mass, double velocity) {
        return 0.5 * mass * Math.pow(velocity, 2);
    }

    // Potential Energy: PE = mgh
    public double getPotentialEnergy(double mass, double height) {
        return mass * GRAVITY * height;
    }

    // Displacement: s = ut + 1/2 at²
    public double getDisplacement(double initialVelocity, double time, double acceleration) {
        return (initialVelocity * time) + (0.5 * acceleration * Math.pow(time, 2));
    }

    // Velocity without time: v = √(u² + 2as)
    public double getVelocityWithoutTime(double initialVelocity, double acceleration, double displacement) {
        return Math.sqrt(Math.pow(initialVelocity, 2) + (2 * acceleration * displacement));
    }

    // Displacement with average velocity: s = ((u + v)/2)t
    public double getDisplacementAvgVelocity(double initialVelocity, double finalVelocity, double time) {
        return ((initialVelocity + finalVelocity) / 2) * time;
    }

    // Time from stopped position: t = √(2s/a)
    public double getTimeFromStoppedPosition(double displacement, double acceleration) {
        return Math.sqrt((2 * displacement) / acceleration);
    }

    // Average velocity in uniform motion: v = s/t
    public double getAvgVelocityInUniformMotion(double displacement, double time) {
        return displacement / time;
    }

    // Vertical velocity: v_y = v_0y - gt
    public double getVerticalVelocity(double initialVerticalVelocity, double time) {
        return initialVerticalVelocity - (GRAVITY * time);
    }

    // Velocity vector of missile: v = √(v_x² + v_y²)
    public double getVelocityVectorOfMissile(double velocityX, double velocityY) {
        return Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
    }
}