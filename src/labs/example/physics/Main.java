//@author: Melissa Chen
//@date: 2025 June 20
//@purpose: Lab 4; calling and printing each method

package labs.example.physics;

public class Main {
    public static void main(String[] args) {
        Physics physics = new Physics();

        // Test each method and print results with units
        System.out.println("Distance: " + physics.getDistance(60, 2) + " miles");
        System.out.println("Velocity: " + physics.getVelocity(120, 2) + " mph");
        System.out.println("Momentum: " + physics.getMomentum(5, 10) + " kg m/s");
        System.out.println("Force: " + physics.getForce(5, 9.81) + " kg m/s^2");
        System.out.println("Work: " + physics.getWork(10, 5) + " NM or Joules");
        System.out.println("Kinetic Energy: " + physics.getKineticEnergy(5, 10) + " NM or Joule");
        System.out.println("Potential Energy: " + physics.getPotentialEnergy(5, 10) + " NM or Joule");
        System.out.println("Displacement: " + physics.getDisplacement(10, 5, 2) + " miles");
        System.out.println("Velocity without time: " + physics.getVelocityWithoutTime(10, 2, 50) + " mph");
        System.out.println("Displacement with average velocity: " + 
            physics.getDisplacementAvgVelocity(10, 20, 5) + " miles/feet/inches");
        System.out.println("Time from stopped position: " + 
            physics.getTimeFromStoppedPosition(100, 9.81) + " seconds");
        System.out.println("Average velocity in uniform motion: " + 
            physics.getAvgVelocityInUniformMotion(100, 10) + " mph");
        System.out.println("Vertical velocity: " + 
            physics.getVerticalVelocity(50, 3) + " mph");
        System.out.println("Velocity vector of missile: " + 
            physics.getVelocityVectorOfMissile(30, 40) + " mph");
    }
}