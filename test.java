package tp_Exception;

public class test{
	static void checkneg(int n) {
		if (n<0) {
			throw new IllegalArgumentException("negative ??,");
		}
		else {
			System.out.println("goood");
		}
	}

}
