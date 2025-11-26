abstract class Circuit {
    public abstract double getResistance();
}

class Resistor {
    private double resistance;

    public Resistor(double resistance) {
        this.resistance = resistance;
    }

    public double getResistance() {
        return this.resistance;
    }
}

class Serial extends Circuit {
    private Resistor[] resistors; //array de resistores

    public Serial(Resistor[] resistors) {
        this.resistors = resistors;
    }

    public double getResistance() {

        double totalTeste = 0;

        for (Resistor resistor : resistors) {
            totalTeste += resistor.getResistance();
        }
        return totalTeste;
    }
}

class Parallel extends Circuit {
    private Resistor[] resistors;

    public Parallel(Resistor[] resistors) {
        this.resistors = resistors;
    }

    public double getResistance() {
        double totalInverseResistance = 0;
        for (Resistor resistor : resistors) {
            totalInverseResistance += 1 / resistor.getResistance();
        }
        return 1 / totalInverseResistance;
    }
}

public class Main {
    public static void main(String[] args) {
        Resistor r1 = new Resistor(10); // Cria os resistores
        Resistor r2 = new Resistor(20);
        Resistor r3 = new Resistor(30);

        // Circuito serial
        Resistor[] serialResistors = {r1, r2, r3};
        Serial serialCircuit = new Serial(serialResistors);
        System.out.println("Resistencia do circuito serial: " + serialCircuit.getResistance() + " ohms");

        // Circuito paralelo
        Resistor[] parallelResistors = {r1, r2, r3};
        Parallel parallelCircuit = new Parallel(parallelResistors);
        System.out.println("Resistencia do circuito paralelo: " + parallelCircuit.getResistance() + " ohms");
    }
}
