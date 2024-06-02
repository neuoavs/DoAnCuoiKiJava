package Runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.MyController;
import Model.Crypto;


public class main {
	public static void main(String[] args) throws JSONException, IOException{
		 String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&price_change_percentage=1h%2C24h%2C7h&locale=en"; 
		 
		 JSONArray json = (JSONArray) MyController.readJsonFromUrl(url);
		 ObjectMapper mapper = new ObjectMapper();
		 
		 List<Crypto> listCrypto = new ArrayList<Crypto>();
		 
		 for (Object object : json) {
			 
			 listCrypto.add(mapper.readValue(((JSONObject) object).toString(), Crypto.class)); 
		 }
		 
		 System.out.println(listCrypto.get(0));
	}
}
