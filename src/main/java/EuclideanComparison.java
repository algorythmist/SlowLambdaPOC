import java.util.Random;
import java.util.stream.IntStream;

public class EuclideanComparison {

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
		int size = 1000000;
		double[] v1 = IntStream.range(0, size).mapToDouble(i -> random.nextDouble()).toArray();
		double[] v2 = IntStream.range(0, size).mapToDouble(i -> random.nextDouble()).toArray();

		long startTime = System.currentTimeMillis();
		double lambdaDistance = IntStream.range(0, size).mapToDouble(i -> v1[i] - v2[i]).map(d -> d * d).sum();
		long lambdaInterval = System.currentTimeMillis() - startTime;

		startTime = System.currentTimeMillis();
		double forDistance = 0;
		for (int i = 0; i < size; i++) {
			double d = v1[i] - v2[i];
			forDistance += d * d;
		}
		
		double forInterval = System.currentTimeMillis() - startTime;
		return new double[] { lambdaInterval, forInterval };
	}
}
