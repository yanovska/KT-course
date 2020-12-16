import java.io.IOException;
import java.util.List;
public class Lab_3 {
    public static void main(String[] args) throws IOException {
            List<Integer> file17 = files.readDataFromFile(args[0]);
            int dynamic = functions.DynamicSignal(file17);
            int energy = functions.EnergySignal(file17);
            double power =functions.PowerSignal(file17);
            double average =functions.AverageSignal(file17);
            double dispersion =functions.DispersionSignal(file17);
            List<Double> autocorrelation =functions.AutocorrelationDiscreteSignal(file17);
            double correlationInterval =functions.CorrelationInterval(file17, autocorrelation);
            System.out.println("Динамический диапазон сигнала: " + dynamic);
            System.out.println("Енергия сигнала: " + energy);
            System.out.println("Средняя мощность сигнала: " + power);
            System.out.println("Среднее значение отсчетов сигнала: " + average);
            System.out.println("дисперсия значений отсчетов сигнала: " + dispersion);
            System.out.println("Функция автокореляции дискретного сигнала в интервале 0...10 : " );
            for (int i = 0; i < autocorrelation.size(); i++) {
                System.out.println( i + ". " + autocorrelation.get(i));
            }
            System.out.println("Интервал кореляции: " + correlationInterval);
    }

}


