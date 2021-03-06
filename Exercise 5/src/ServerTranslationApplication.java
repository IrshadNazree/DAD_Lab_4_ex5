import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication {
	public String[] malayText = {"Selamat Pagi","Selamat Malam","Apa Khabars?","Terima Kasih","Selamat tinggal","Ada apa?"};
	public String[] arabicText = {"صباح الخير","طاب مساؤك","كيف حالك؟","شكرا لك","مع السلامة","ما أخبارك؟"};
	public String[] koreanText = {"좋은 아침","안녕히 주무세요","어떻게 지내세요?","감사합니다","안녕","뭐야?"};
	public static void main(String[] args) throws IOException{	
//	public void serverTranslationApplications() throws IOException{	
		System.out.println("server started");
		ServerSocket ssc = new ServerSocket(4228);
		ServerTranslationApplication sta = new ServerTranslationApplication();
		try {
			while(true) {
				Socket sc = ssc.accept();
				System.out.println("client connected");
				
				BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				
				int selectLang = Integer.parseInt(bf.readLine());
				int selectText = Integer.parseInt(bf.readLine());
				
				PrintWriter pw = new PrintWriter(sc.getOutputStream());
				
				String translateText = null;
				
				if (selectLang == 0) {
					translateText = sta.malayText[selectText];
				}else if (selectLang == 1) {
					translateText = sta.arabicText[selectText];
				}else if (selectLang == 2) {
					translateText = sta.koreanText[selectText];
				}
				
				pw.println(translateText);
				pw.flush();
			}
			
		} catch (IOException e) {
			if (ssc != null) {
				ssc.close();
			}
			e.printStackTrace();
		}	
	}
}
