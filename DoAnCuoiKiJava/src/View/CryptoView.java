package View;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MyController;
import Model.Crypto;
import Runner.Client;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.util.List;


import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CryptoView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Client client;
	private JPanel contentPane;
	private JLabel currentPriceValue;
	private JLabel marketCapValue;
	private JLabel marketCapRankValue;
	private JLabel fullyDilutedValuationValue;
	private JLabel totalVolumeValue;
	private JLabel high24hValue;
	private JLabel low24hValue;
	private JLabel priceChange24hValue;
	private JLabel priceChangePercentage24hValue;
	private JLabel marketCapChange24hValue;
	private JLabel marketCapChangePercentage24hValue;
	private JLabel circulatingSupplyValue;
	private JLabel totalSupplyValue;
	private JLabel maxSupplyValue;
	private JLabel athValue;
	private	JLabel athChangePercentageValue;
	private JLabel athDateValue;
	private JLabel atlValue;
	private JLabel atlChangePercentageValue;
	private JLabel atlDateValue;
	private JLabel timesValue;
	private JLabel currencyValue;
	private JLabel percentageValue;
	private JLabel lastUpdatedValue;
	private JLabel priceChangePercentage1hInCurrencyValue;
	private JLabel priceChangePercentage24hInCurrencyValue;
	private JLabel cryptoName;
	private JLabel symbolCrypto;
	private JLabel cryptoImage;
	private JComboBox<String> listSymbol;

	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CryptoView frame = new CryptoView();
//					frame.setVisible(true);
//					Client client = new Client();
//					client.setView(frame);
//					client.start();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CryptoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 cryptoName = new JLabel("Crypto Name");
		cryptoName.setFont(new Font("Open Sans", Font.BOLD, 14));
		cryptoName.setBounds(90, 10, 155, 35);
		contentPane.add(cryptoName);
		
		cryptoImage = new JLabel("");
		cryptoImage.setBounds(10, 10, 70, 70);
		contentPane.add(cryptoImage);
		
		symbolCrypto = new JLabel("Symbol");
		symbolCrypto.setFont(new Font("Open Sans", Font.BOLD, 14));
		symbolCrypto.setBounds(90, 45, 155, 35);
		contentPane.add(symbolCrypto);
		
		JLabel currentPrice = new JLabel("Current Price:");
		currentPrice.setFont(new Font("Open Sans", Font.BOLD, 14));
		currentPrice.setBounds(10, 90, 100, 35);
		contentPane.add(currentPrice);
		
		JLabel marketCap = new JLabel("Market Cap:");
		marketCap.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCap.setBounds(10, 135, 87, 35);
		contentPane.add(marketCap);
		
		JLabel marketCapRank = new JLabel("Market Cap Rank:");
		marketCapRank.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCapRank.setBounds(10, 180, 128, 35);
		contentPane.add(marketCapRank);
		
		JLabel fullyDilutedValuation = new JLabel("Fully Diluted Valuation:");
		fullyDilutedValuation.setFont(new Font("Open Sans", Font.BOLD, 14));
		fullyDilutedValuation.setBounds(10, 225, 172, 35);
		contentPane.add(fullyDilutedValuation);
		
		JLabel totalVolume = new JLabel("Total Volume:");
		totalVolume.setFont(new Font("Open Sans", Font.BOLD, 14));
		totalVolume.setBounds(10, 270, 112, 35);
		contentPane.add(totalVolume);
		
		JLabel high24h = new JLabel("High 24 Hours:");
		high24h.setFont(new Font("Open Sans", Font.BOLD, 14));
		high24h.setBounds(10, 315, 112, 35);
		contentPane.add(high24h);
		
		JLabel low24h = new JLabel("Low 24 Hours:");
		low24h.setFont(new Font("Open Sans", Font.BOLD, 14));
		low24h.setBounds(10, 360, 112, 35);
		contentPane.add(low24h);
		
		JLabel priceChange24h = new JLabel("Price Change 24 Hours:");
		priceChange24h.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChange24h.setBounds(10, 405, 165, 35);
		contentPane.add(priceChange24h);
		
		JLabel priceChangePercentage24h = new JLabel("Price Change Percent 24 Hours:");
		priceChangePercentage24h.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChangePercentage24h.setBounds(10, 450, 235, 35);
		contentPane.add(priceChangePercentage24h);
		
		JLabel marketCapChange24h = new JLabel("Market Cap Change 24 Hours:");
		marketCapChange24h.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCapChange24h.setBounds(10, 495, 235, 35);
		contentPane.add(marketCapChange24h);
		
		JLabel marketCapChangePercentage24h = new JLabel("Market Cap Change Percent 24 Hours:");
		marketCapChangePercentage24h.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCapChangePercentage24h.setBounds(10, 540, 272, 35);
		contentPane.add(marketCapChangePercentage24h);
		
		JLabel circulatingSupply = new JLabel("Circulating Supply:");
		circulatingSupply.setFont(new Font("Open Sans", Font.BOLD, 14));
		circulatingSupply.setBounds(10, 585, 272, 35);
		contentPane.add(circulatingSupply);
		
		JLabel totalSupply = new JLabel("Total Supply:");
		totalSupply.setFont(new Font("Open Sans", Font.BOLD, 14));
		totalSupply.setBounds(10, 628, 272, 35);
		contentPane.add(totalSupply);
		
		JLabel maxSupply = new JLabel("Max Supply:");
		maxSupply.setFont(new Font("Open Sans", Font.BOLD, 14));
		maxSupply.setBounds(10, 673, 272, 35);
		contentPane.add(maxSupply);
		
		JLabel ath = new JLabel("ATH:");
		ath.setFont(new Font("Open Sans", Font.BOLD, 14));
		ath.setBounds(563, 90, 45, 35);
		contentPane.add(ath);
		
		JLabel athChangePercentage = new JLabel("ATH Change Percentage:");
		athChangePercentage.setFont(new Font("Open Sans", Font.BOLD, 14));
		athChangePercentage.setBounds(563, 135, 182, 35);
		contentPane.add(athChangePercentage);
		
		JLabel athDate = new JLabel("ATH Date:");
		athDate.setFont(new Font("Open Sans", Font.BOLD, 14));
		athDate.setBounds(563, 180, 80, 35);
		contentPane.add(athDate);
		
		JLabel atl = new JLabel("ATL:");
		atl.setFont(new Font("Open Sans", Font.BOLD, 14));
		atl.setBounds(563, 225, 45, 35);
		contentPane.add(atl);
		
		JLabel atlChangePercentage = new JLabel("ATL Change Pesentage:");
		atlChangePercentage.setFont(new Font("Open Sans", Font.BOLD, 14));
		atlChangePercentage.setBounds(563, 270, 182, 35);
		contentPane.add(atlChangePercentage);
		
		JLabel atlDate = new JLabel("ATL Date:");
		atlDate.setFont(new Font("Open Sans", Font.BOLD, 14));
		atlDate.setBounds(563, 315, 80, 35);
		contentPane.add(atlDate);
		
		JLabel roi = new JLabel("Roi:");
		roi.setFont(new Font("Open Sans", Font.BOLD, 14));
		roi.setBounds(563, 360, 45, 35);
		contentPane.add(roi);
		
		JLabel times = new JLabel("Times:");
		times.setFont(new Font("Open Sans", Font.BOLD, 14));
		times.setBounds(605, 405, 57, 35);
		contentPane.add(times);
		
		JLabel currency = new JLabel("Currency:");
		currency.setFont(new Font("Open Sans", Font.BOLD, 14));
		currency.setBounds(605, 450, 70, 35);
		contentPane.add(currency);
		
		JLabel percentage = new JLabel("Percentage:");
		percentage.setFont(new Font("Open Sans", Font.BOLD, 14));
		percentage.setBounds(605, 495, 87, 35);
		contentPane.add(percentage);
		
		JLabel priceChangePercentage1hInCurrency = new JLabel("Price Change Percentage 1 Hours In Currency:");
		priceChangePercentage1hInCurrency.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChangePercentage1hInCurrency.setBounds(563, 583, 330, 35);
		contentPane.add(priceChangePercentage1hInCurrency);
		
		JLabel lastUpdated = new JLabel("Last Updated:");
		lastUpdated.setFont(new Font("Open Sans", Font.BOLD, 14));
		lastUpdated.setBounds(563, 540, 112, 35);
		contentPane.add(lastUpdated);
		
		JLabel priceChangePercentage24hInCurrency = new JLabel("Price Change Percentage 24 hours In Currency:");
		priceChangePercentage24hInCurrency.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChangePercentage24hInCurrency.setBounds(563, 628, 342, 35);
		contentPane.add(priceChangePercentage24hInCurrency);
		
		currentPriceValue = new JLabel("Current Price Value");
		currentPriceValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		currentPriceValue.setBounds(292, 90, 242, 35);
		contentPane.add(currentPriceValue);
		
		marketCapValue = new JLabel("Market Cap Value");
		marketCapValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCapValue.setBounds(292, 135, 242, 35);
		contentPane.add(marketCapValue);
		
		marketCapRankValue = new JLabel("Market Cap Rank Value");
		marketCapRankValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCapRankValue.setBounds(292, 180, 242, 35);
		contentPane.add(marketCapRankValue);
		
		fullyDilutedValuationValue = new JLabel("Fully Diluted Valuation Value");
		fullyDilutedValuationValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		fullyDilutedValuationValue.setBounds(292, 225, 242, 35);
		contentPane.add(fullyDilutedValuationValue);
		
		totalVolumeValue = new JLabel("Total Volume Value");
		totalVolumeValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		totalVolumeValue.setBounds(292, 270, 242, 35);
		contentPane.add(totalVolumeValue);
		
		high24hValue = new JLabel("High 24 Hours Value");
		high24hValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		high24hValue.setBounds(292, 315, 242, 35);
		contentPane.add(high24hValue);
		
		low24hValue = new JLabel("Low 24 Hours Value");
		low24hValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		low24hValue.setBounds(292, 360, 242, 35);
		contentPane.add(low24hValue);
		
		priceChange24hValue = new JLabel("Price Change 24 Hours Value");
		priceChange24hValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChange24hValue.setBounds(292, 405, 242, 35);
		contentPane.add(priceChange24hValue);
		
		priceChangePercentage24hValue = new JLabel("Price Change Percent 24 Hours Value");
		priceChangePercentage24hValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChangePercentage24hValue.setBounds(292, 450, 242, 35);
		contentPane.add(priceChangePercentage24hValue);
		
		marketCapChangePercentage24hValue = new JLabel("Market Cap Change Percent 24 Hours Value");
		marketCapChangePercentage24hValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCapChangePercentage24hValue.setBounds(292, 540, 242, 35);
		contentPane.add(marketCapChangePercentage24hValue);
		
		marketCapChange24hValue = new JLabel("Market Cap Change 24 Hours Value");
		marketCapChange24hValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		marketCapChange24hValue.setBounds(292, 495, 242, 35);
		contentPane.add(marketCapChange24hValue);
		
		circulatingSupplyValue = new JLabel("Circulating Supply Value");
		circulatingSupplyValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		circulatingSupplyValue.setBounds(292, 585, 242, 35);
		contentPane.add(circulatingSupplyValue);
		
		totalSupplyValue = new JLabel("Total Supply Value");
		totalSupplyValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		totalSupplyValue.setBounds(292, 628, 242, 35);
		contentPane.add(totalSupplyValue);
		
		maxSupplyValue = new JLabel("Max Supply Value");
		maxSupplyValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		maxSupplyValue.setBounds(292, 673, 242, 35);
		contentPane.add(maxSupplyValue);
		
		
		 priceChangePercentage24hInCurrencyValue = new JLabel("Price Change Percentage 24 hours In Currency Value");
		priceChangePercentage24hInCurrencyValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChangePercentage24hInCurrencyValue.setBounds(915, 628, 292, 35);
		contentPane.add(priceChangePercentage24hInCurrencyValue);
		
		 priceChangePercentage1hInCurrencyValue = new JLabel("Price Change Percentage 1 Hours In Currency Value");
		priceChangePercentage1hInCurrencyValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		priceChangePercentage1hInCurrencyValue.setBounds(915, 585, 292, 35);
		contentPane.add(priceChangePercentage1hInCurrencyValue);
		
		lastUpdatedValue = new JLabel("Last Updated Value");
		lastUpdatedValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		lastUpdatedValue.setBounds(915, 540, 292, 35);
		contentPane.add(lastUpdatedValue);
		
		 percentageValue = new JLabel("Percentage Value");
		percentageValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		percentageValue.setBounds(915, 495, 292, 35);
		contentPane.add(percentageValue);
		
		currencyValue = new JLabel("Currency Value");
		currencyValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		currencyValue.setBounds(915, 450, 292, 35);
		contentPane.add(currencyValue);
		
		 timesValue = new JLabel("Times Value");
		timesValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		timesValue.setBounds(915, 405, 292, 35);
		contentPane.add(timesValue);
		
		 atlDateValue = new JLabel("ATL Date Value");
		atlDateValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		atlDateValue.setBounds(915, 315, 292, 35);
		contentPane.add(atlDateValue);
		
		 atlChangePercentageValue = new JLabel("ALT Change Pesentage Value");
		atlChangePercentageValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		atlChangePercentageValue.setBounds(915, 270, 292, 35);
		contentPane.add(atlChangePercentageValue);
		
		 atlValue = new JLabel("ATL Value");
		atlValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		atlValue.setBounds(915, 225, 292, 35);
		contentPane.add(atlValue);
		
		athDateValue = new JLabel("ATH Date Value");
		athDateValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		athDateValue.setBounds(915, 180, 292, 35);
		contentPane.add(athDateValue);
		
		athValue = new JLabel("ATH Value");
		athValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		athValue.setBounds(915, 90, 292, 35);
		contentPane.add(athValue);
		
		athChangePercentageValue = new JLabel("ATH Change Percentage Value");
		athChangePercentageValue.setFont(new Font("Open Sans", Font.BOLD, 14));
		athChangePercentageValue.setBounds(915, 135, 292, 35);
		contentPane.add(athChangePercentageValue);
		
		listSymbol = new JComboBox<>();
//		listSymbol.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				updateView(client.findBySymbol((String) listSymbol.getSelectedItem()));
//			}
//		});
		listSymbol.setFont(new Font("Open Sans", Font.BOLD, 14));
		listSymbol.setBounds(915, 10, 291, 42);
		contentPane.add(listSymbol);
	}



	
	public void updateView(Crypto crypto) {
		EventQueue.invokeLater(() -> {
			try {
				MyController.addImageToLabel(crypto.getImage(), cryptoImage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listSymbol.setSelectedItem(crypto.getSymbol());
			cryptoName.setText(crypto.getName());
			symbolCrypto.setText(crypto.getSymbol());
			currentPriceValue.setText(String.format("%.9f", crypto.getCurrent_price()) + "$");
			marketCapValue.setText(String.format("%.0f", crypto.getMarket_cap()));
			marketCapRankValue.setText(crypto.getMarket_cap_rank() + "");
			fullyDilutedValuationValue.setText(String.format("%.0f", crypto.getFully_diluted_valuation()));
			totalVolumeValue.setText(String.format("%.0f", crypto.getTotal_volume()));
			high24hValue.setText(String.format("%.9f", crypto.getHigh_24h()) + "$");
			low24hValue.setText(String.format("%.9f", crypto.getLow_24h()) + "$");
			priceChange24hValue.setText(String.format("%.9f", crypto.getPrice_change_24h()) + "$");
			if (crypto.getPrice_change_percentage_24h() < 0.0) {
				priceChangePercentage24hValue.setForeground(Color.RED);
			} else {
				priceChangePercentage24hValue.setForeground(Color.GREEN);
			}
			priceChangePercentage24hValue.setText(String.format("%.9f", crypto.getPrice_change_percentage_24h()) + "%");
			marketCapChange24hValue.setText(String.format("%.0f", crypto.getMarket_cap_change_24h()));
			if (crypto.getMarket_cap_change_percentage_24h() < 0.0) {
				marketCapChangePercentage24hValue.setForeground(Color.RED);
			} else {
				marketCapChangePercentage24hValue.setForeground(Color.GREEN);
			}
			
			marketCapChangePercentage24hValue.setText(String.format("%.9f", crypto.getMarket_cap_change_percentage_24h()) + "%");
			circulatingSupplyValue.setText(String.format("%.9f", crypto.getCirculating_supply()));
			totalSupplyValue.setText(String.format("%.9f", crypto.getTotal_supply()));
			maxSupplyValue.setText(String.format("%.9f", crypto.getMax_supply()));
			athValue.setText(String.format("%.9f", crypto.getAth()) + "$");
			if (crypto.getAth_change_percentage() < 0.0) {
				athChangePercentageValue.setForeground(Color.RED);
			} else {
				athChangePercentageValue.setForeground(Color.GREEN);
			}
			athChangePercentageValue.setText(String.format("%.9f", crypto.getAth_change_percentage()) + "%");
			athDateValue.setText(crypto.getAth_date());
			atlValue.setText(String.format("%.9f", crypto.getAtl()) + "$");
			if (crypto.getAtl_change_percentage() < 0.0) {
				atlChangePercentageValue.setForeground(Color.RED);
			} else {
				atlChangePercentageValue.setForeground(Color.GREEN);
			}
			
			atlChangePercentageValue.setText(String.format("%.9f", crypto.getAtl_change_percentage()) + "%");
			atlDateValue.setText(crypto.getAtl_date());
			if (crypto.getRoi() != null) {
				timesValue.setText(String.format("%.9f", crypto.getRoi().getTimes()));
				currencyValue.setText(crypto.getRoi().getCurrency());
				if (crypto.getRoi().getPercentage() < 0.0) {
					percentageValue.setForeground(Color.RED);
				} else {
					percentageValue.setForeground(Color.GREEN);
				}
				percentageValue.setText(String.format("%.9f", crypto.getRoi().getPercentage()) + "%");
			} else {
				timesValue.setText("None");
				currencyValue.setText("None");
				percentageValue.setForeground(Color.BLACK);
				percentageValue.setText("None");	
			}
			
			lastUpdatedValue.setText(crypto.getLast_updated());
			
			if (crypto.getPrice_change_percentage_1h_in_currency() < 0.0) {
				priceChangePercentage1hInCurrencyValue.setForeground(Color.RED);
			} else {
				priceChangePercentage1hInCurrencyValue.setForeground(Color.GREEN);
			}
			priceChangePercentage1hInCurrencyValue.setText(String.format("%.9f", crypto.getPrice_change_percentage_1h_in_currency()) + "%");
			
			if (crypto.getPrice_change_percentage_24h_in_currency() < 0.0) {
				priceChangePercentage24hInCurrencyValue.setForeground(Color.RED);
			} else {
				priceChangePercentage24hInCurrencyValue.setForeground(Color.GREEN);
			}
			
			priceChangePercentage24hInCurrencyValue.setText(String.format("%.9f", crypto.getPrice_change_percentage_24h_in_currency()) + "%");
		});
	}
	
	public void updateComboBox(List<Crypto> listCrypto) {
		for (Crypto crypto : listCrypto) {
			listSymbol.addItem(crypto.getSymbol());
		}
	
	}


	


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
