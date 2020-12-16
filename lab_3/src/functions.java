import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class functions {

    private static double m;

    public static int DynamicSignal(List<Integer> numbers) {
        int smin = numbers.stream().min(Comparator.comparingInt(o -> o)).get();
        int smax = numbers.stream().max(Comparator.comparingInt(o -> o)).get();
        return smax - smin;
    }

    public static int EnergySignal(List<Integer> numbers) {
        int energy = numbers.stream().reduce(0, (a, b) -> a + b * b);
        return energy;
    }

    public static double PowerSignal(List<Integer> numbers) {
         double power = (double) numbers.stream().reduce(0, (a, b) -> a + b * b) / numbers.size();
         return power;
 }

    public static double AverageSignal(List<Integer> numbers) {
         double ms = (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();
                functions.m = ms;
         return ms;
 }

    public static double DispersionSignal(List<Integer> numbers) {
        functions.AverageSignal(numbers);
        double ds = numbers.stream().mapToDouble(v -> v).reduce(0,functions::add) /numbers.size();
        return ds;
 }

    private static double add(double a, double b) {
        return a + (b - m) * (b - m);
 }

    public static List<Double> AutocorrelationDiscreteSignal(List<Integer> numbers) {
         List<Double> autocorrelation = new ArrayList<>();
         double tmp;
         for (int t = 0; t <= 10; t++) {
         tmp = 0;
         for (int i = 0; i < numbers.size() - t - 1; i++) {
         tmp += (numbers.get(i + t) - m) * (numbers.get(i) - m);
         }
         autocorrelation.add(tmp / numbers.size() - t);
         }
         return autocorrelation;
 }

    public static double CorrelationInterval(List<Integer> numbers, List<Double> autocorrelation) {
         double tkor;
         double rxxj = 0;
         double rxx0 = 0;
         for (Double aDouble : autocorrelation) {
         rxxj += aDouble;
         }
         for (int i = 0, t = 0; i < numbers.size() - t - 1; i++) {
         rxx0 += (numbers.get(i + t) - m) * (numbers.get(i) - m);
         }
                tkor = rxxj / rxx0;
         return tkor;
         }
}
