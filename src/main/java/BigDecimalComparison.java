import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigDecimalComparison {

	public static void main(String[] args) {
		Random random = new Random(1473876L);
		double lambdaTime = 0;
		double forTime = 0;
		for (int i = 0; i < 100; i++) {
			double[] time = experiment(random);
			lambdaTime += time[0];
			forTime += time[1];
		}
		System.out.println("Total lambda time = " + lambdaTime);
		System.out.println("Total for time = " + forTime);

	}

	private static double[] experiment(Random random) {
		int size = 100000;
		List<BigDecimal> v = IntStream.range(0, size).mapToDouble(i -> random.nextDouble())
				.mapToObj(d -> BigDecimal.valueOf(d)).collect(Collectors.toList());

		long startTime = System.currentTimeMillis();
		BigDecimal lambdaSum = v.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		long lambdaInterval = System.currentTimeMillis() - startTime;

		startTime = System.currentTimeMillis();
		BigDecimal forDistance = BigDecimal.ZERO;
		for (int i = 0; i < size; i++) {
			forDistance = forDistance.add(v.get(i));
		}

		double forInterval = System.currentTimeMillis() - startTime;
		return new double[] { lambdaInterval, forInterval };

	}
}
