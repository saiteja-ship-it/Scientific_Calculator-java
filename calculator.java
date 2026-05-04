package sci_calsi;

import java.util.Scanner;

enum Operation {
    ADD("+"), SUB("-"), MUL("*"), DIV("/"),
    SIN("SIN"), COS("COS"), TAN("TAN");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operation fromSymbol(String symbol) {
        for (Operation op : Operation.values()) {
            if (op.symbol.equalsIgnoreCase(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operation symbol: " + symbol);
    }
}

public class calculator {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter initial number:");
        double a = s.nextDouble();

        while (true) {
            System.out.println("Enter operation (+, -, *, /, SIN, COS, TAN) or EXIT:");
            String b = s.next();
            if (b.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                Operation o = Operation.fromSymbol(b);

                switch (o) {
                    case ADD:
                        System.out.println("Enter number:");
                        a = a + s.nextDouble();
                        break;
                    case SUB:
                        System.out.println("Enter number:");
                        a = a - s.nextDouble();
                        break;
                    case MUL:
                        System.out.println("Enter number:");
                        a = a * s.nextDouble();
                        break;
                    case DIV:
                        System.out.println("Enter number:");
                        double c = s.nextDouble();
                        if (c != 0) {
                            a = a / c;
                        } else {
                            System.out.println("Denominator should not be zero.");
                            continue;
                        }
                        break;
                    case SIN:
                        System.out.println("Enter angle in degrees:");
                        a = Math.sin(Math.toRadians(s.nextDouble()));
                        break;
                    case COS:
                        System.out.println("Enter angle in degrees:");
                        a = Math.cos(Math.toRadians(s.nextDouble()));
                        break;
                    case TAN:
                        System.out.println("Enter angle in degrees:");
                        a = Math.tan(Math.toRadians(s.nextDouble()));
                        break;
                }

                System.out.println("Result: " + a);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
