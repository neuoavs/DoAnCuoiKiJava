package Runner;

import java.awt.EventQueue;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;


import Model.Crypto;
import View.CryptoView;

public class Client extends Thread{
	
	private List<Crypto> listCryto;
	private CryptoView view;
	private int index = 0;
	@Override
	public void run() {
		Socket socketServer = null;
		ObjectInputStream in = null;
		DataOutputStream out = null;
		
		Thread change = new Thread(() -> {

			int range = listCryto.size() - 1;
			
			EventQueue.invokeLater(() -> {
				view = new CryptoView();
				view.setClient(this);
				view.updateComboBox(listCryto);
				view.updateView(listCryto.get(0));
				view.setVisible(true);
			});
			
			while (true) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (index == range) {
					index = 0;
				}
				
				view.updateView(listCryto.get(++index));
			}
		});

		try {
			while (true) {
				socketServer = new Socket("localhost", 1714);
				in = new ObjectInputStream(socketServer.getInputStream());
				out = new DataOutputStream(socketServer.getOutputStream());
				out.writeUTF("Update List");
				
				while ((listCryto = (List<Crypto>) in.readObject()) != null) {
					if (!change.isAlive()) {
						change.start();
					}
//					System.out.println("Added List");
//					System.out.println("Size of List " + listCryto.size());
					if (socketServer != null) {
						socketServer.close();
					}
					
					if (in != null) {
						in.close();
					}
					
					if (out != null) {
						out.close();
					}
					break;
				}
				
				Thread.sleep(10000);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Crypto findBySymbol(String symbol) {
		for (int i = 0; i < listCryto.size(); i++) {
			if (listCryto.get(i).getSymbol().equals(symbol)) {
				index = i;
				return listCryto.get(i);
			}
		}
		return null;
	}


	
}
