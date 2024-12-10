import java.io.IOException;

public class HierarchialBehaviour {
	public static void main1(String[] args) {
		// check if child exception handed
		try {
			int div = 1243 / 0;
			System.out.println("Hi");
		} catch (ArithmeticException e) { // SPECIFIC EXCEPTION CHILD CLASS 1st CATCH
			System.out.println("In ArithmeticException");
		} catch (Exception e) {
			System.out.println("Exception divisor can not be zero");
		} finally {
			throw new NullPointerException();
		}
	}

	@SuppressWarnings("finally")
	public static void main(String[] args) {
		// check if child exception handed
		try {
			throw new RuntimeException("Exception in try block");
		} finally {
			RuntimeException finallyException = new RuntimeException("Exception in finally block");
			finallyException.addSuppressed(new RuntimeException("Suppressed exception"));
			throw finallyException;
		}
	}
}
