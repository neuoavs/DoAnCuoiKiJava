package Runner;

import java.io.DataInputStream;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import Model.Crypto;

public class ServerProcess implements Runnable{
	private Socket clientSocket;
	private List<Crypto> listCrypto;
	
	public ServerProcess() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ServerProcess(Socket clientSocket, List<Crypto> listCrypto) {
		super();
		this.clientSocket = clientSocket;
		this.listCrypto = listCrypto;
	}


	@Override
	public void run() {
		DataInputStream in = null;
		ObjectOutputStream out = null;
		String hostClient = "";
		String messFromClient = "";
		try {
			in = new DataInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			
			hostClient = clientSocket.getInetAddress().getHostAddress();

			while ((messFromClient = in.readUTF()) != null) {
				
				System.out.println("Mess from client " + hostClient + ": " + messFromClient);	
				
				out.writeObject(listCrypto);
				
				if (out != null) {
					out.close();
				}
				
				if (in != null) {
					in.close();
					
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public Socket getClientSocket() {
		return clientSocket;
	}



	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}



	public List<Crypto> getListCrypto() {
		return listCrypto;
	}



	public void setListCrypto(List<Crypto> listCrypto) {
		this.listCrypto = listCrypto;
	}
	
	
	
}
