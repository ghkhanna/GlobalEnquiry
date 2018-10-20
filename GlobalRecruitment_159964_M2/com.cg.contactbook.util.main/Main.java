import com.cg.contactbook.util.ConnectionProvider;


public class Main {
	public static void main(String[] args) {
		if(ConnectionProvider.getDBConnection()!=null) System.out.println("Connection Open!!");
		else System.out.println("Some Problem :/");
	}

}
