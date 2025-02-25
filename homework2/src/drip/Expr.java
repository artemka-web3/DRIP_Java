package drip;

public sealed interface Expr {
    double evaluate();
    public record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }
    public record Negate(Expr expr) implements Expr {
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }
    public record Exponent(Expr left_expr, double exponent) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(left_expr.evaluate(), exponent);
        }
    }
    public record Addition(Expr left_expr, Expr right_expr) implements Expr {
        @Override
        public double evaluate() {
            return left_expr.evaluate() + right_expr.evaluate();
        }
    }
    public record Multiplication(Expr left_expr, Expr right_expr) implements Expr {
        @Override
        public double evaluate() {
            return left_expr.evaluate() * right_expr.evaluate();
        }
    }
}
