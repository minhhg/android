import java.io.*;
import java.net.*;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import java.io.File;
import java.io.FileOutputStream;


public class ETMultiServerThread extends Thread {
	 private Socket socket = null;

	 public ETMultiServerThread(Socket socket) {
		super("ETMultiServerThread");
		this.socket = socket;
		   System.out.println("Accepted connection ");
		   
	    }
	 public void run() {

			try {
			    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
						    new InputStreamReader(
						    socket.getInputStream()));
			    
			    String inputLine;
			    inputLine = in.readLine();	
			    System.out.println("Input URL:");
			    System.out.println(inputLine);
			    if (inputLine.equals("Exit."))
			    	ExtractServer.listening = false;
			    else  {
			    final URL url = new URL(inputLine);
			        
//			                //"http://www.l3s.de/web/page11g.do?sp=page11g&link=ln104g&stu1g.LanguageISOCtxParam=en"
			                //      "http://www.dn.se/nyheter/vetenskap/annu-godare-choklad-med-hjalp-av-dna-teknik"
			                        

			        // This can also be done in one line:
			         //System.out.println(ArticleExtractor.INSTANCE.getText(url));
			         out.write(ArticleExtractor.INSTANCE.getText(url));
			         out.flush();
			    }
			    out.close();			       			    
			    out.close();
			    in.close();
			    socket.close();

			} catch (IOException e) {
			    e.printStackTrace();
			} catch (BoilerpipeProcessingException e) {
				e.printStackTrace();
			} 
		}
	 
}
