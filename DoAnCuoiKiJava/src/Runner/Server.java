package Runner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.MyController;
import Model.Crypto;

public class Server extends Thread{
	private final String api = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&price_change_percentage=1h%2C24h%2C7h&locale=en";
	private List<Crypto> listCrypto;
	

	@Override
	public void run() {
		try {
			listCrypto = loadListCrypto(api);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (listCrypto == null) {
			System.out.println("List Crypto is null. Program is closed");
			return;
		} else {
			new Thread(() -> {
				while (true) {
					try {
						Thread.sleep(7000);
						listCrypto = loadListCrypto(api);
					} catch (InterruptedException |JSONException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(1714);
			serverSocket.setReuseAddress(true);
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				
				System.out.println("Client is conecting to server: " + clientSocket.getInetAddress().getHostAddress());
				ServerProcess process = new ServerProcess(clientSocket, listCrypto);
				new Thread(process).start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public List<Crypto> getListCrypto() {
		return listCrypto;
	}

	public void setListCrypto(List<Crypto> listCrypto) {
		this.listCrypto = listCrypto;
	}
	
	public List<Crypto> loadListCrypto(String url) throws JSONException, IOException {
		JSONArray json = (JSONArray) MyController.readJsonFromUrl(url);
		ObjectMapper mapper = new ObjectMapper();
		 
		List<Crypto> list = new ArrayList<Crypto>();
		 
		for (Object object : json) {
			list.add(mapper.readValue(((JSONObject) object).toString(), Crypto.class)); 
		}
		
		return list;
	}
}
