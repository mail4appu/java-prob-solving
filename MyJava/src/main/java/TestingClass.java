import java.util.concurrent.ConcurrentHashMap;

public class TestingClass {
	private static ConcurrentHashMap<Integer, String> redissonClientForProxy = new ConcurrentHashMap <>(4);
	public static void main(String[] args) throws InterruptedException {
		String path="products/LUB12/locale/fr-FR/country/FRA/compatible";
		String redirectionPath=path.replace("products/", "products/v2/");
		System.out.println(redirectionPath);

		System.out.println(" Main thread is sleeping ");
		fillMap(1);
		fillMap(1);
		//Thread.sleep(5*60*1000);
	}

	public static String fillMap(int dataBaseNumber) {
		System.out.println("initialize only if abscent"+ dataBaseNumber);
		return redissonClientForProxy.computeIfAbsent(dataBaseNumber, dbn -> {
			try {
				System.out.println(" ###############  Initialising the redissonclient for db number"+ dbn);
				return "Redis";
			} catch (Exception e) {

				throw new RuntimeException(e);
			}
		});
	}
}
