package star.test.methods;

import java.security.MessageDigest;


public class Md5Test {

	public static String MdString(String mdString) throws Exception
	{
		byte[] bytes = mdString.getBytes();
		MessageDigest mdDigest = MessageDigest.getInstance("MD5");
		mdDigest.update(bytes);
		return mdDigest.digest().toString();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(Md5Test.MdString("test"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
