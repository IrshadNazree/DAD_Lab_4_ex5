import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTranslation {
	public String[] languageSelect = {"Bahasa Malaysia","Arabic","Korean"};
	public String[] defaultText = {"Good Morning","Good Night","How are you?","Thank you","Goodbye","What's up?"};

	public String clientTranslation(int langSelect, int txtSelect){
		String translatedText = null;
		try {
			Socket sc = new Socket(InetAddress.getLocalHost(),4228);
			
			PrintWriter pw = new PrintWriter(sc.getOutputStream());
			pw.println(String.valueOf(langSelect));
			pw.println(String.valueOf(txtSelect));
			pw.flush();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			
			translatedText = bf.readLine();
//			System.out.println(translatedText);
			
			bf.close();
			pw.close();
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return translatedText;
	}
	
}
