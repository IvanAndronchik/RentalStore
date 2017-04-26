package edu.bsu.sportshop.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import edu.bsu.sportshop.client.Client;

/**
 *Title: Rental sporting goods store
 *Description:store information about clients and rented goods,
 *allow rent and return goods
 *Copyright: Ivan Andronchik Copyright (c) 2017
 * Company:
 * @author Ivan Andronchik
 * @version 0.1
 *
 */

public class Shop {
	private final String FILENAME = "FILENAME.txt";//file to initialize shop
	private Map<SportEquipment, Integer> goods;//goods in the shop
	private TreeMap<Client, RentUnit> clientRentUnits;//clients and their rented goods

	 /**
	  * Constructor Shop
	  */
	
	public Shop() {
		setGoods(new HashMap<SportEquipment, Integer>());
		setClientRentUnits(new TreeMap<Client, RentUnit>());
		init();
	}

	//add a new good
	public void addGood(SportEquipment good, int amount) {
		if (getGoods().containsKey(good))//if the good exist, add amount to it
			getGoods().replace(good, getGoods().get(good) + amount);
		getGoods().put(good, amount);
	}

	//allow to rent good to client
	public boolean rentGood(SportEquipment good, Client client) {
		if (!getClientRentUnits().containsKey(client))//unknown client
			getClientRentUnits().put(client, new RentUnit());//add new client
		if (good == null)
			return false;
		if ((getClientRentUnits().get(client).addSportEquipment(good))) {//add good to the client's rental unit
			getGoods().replace(good, getGoods().get(good) - 1);//take good from shop
			return true;
		}
		return false;
	}
	
	//allow to return good to the shop
	public boolean returnGood(SportEquipment good, Client client) {
		if (good != null
				|| getClientRentUnits().get(client).deleteSportEquipment(good)) {//delete good from clients rental unit
			getGoods().replace(good, getGoods().get(good) + 1);//put good to shop
			return true;
		}
		return false;
	}
	
	//rent good by it's title
	public boolean rentByTitle(String title, Client client) {
		return (rentGood(getByTitle(title), client)) ? true : false;
	}

	//return good by it's title
	public boolean returnByTitle(String title, Client client) {
		return (returnGood(getByTitle(title), client)) ? true : false;
	}

	//initialize from file
	public void init() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String data;
			SportEquipment good;

			while ((data = br.readLine()) != null) {//read data and convert it in good
				good = getSportEquipment(data);
				if (good != null)
					getGoods().put(good, good.getQuantity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//convert data in good
	private SportEquipment getSportEquipment(String data) {
		if (data.length() == 0)
			return null;
		StringTokenizer tok = new StringTokenizer(data, "|");

		String title;
		int price, quantity;

		title = tok.nextToken();

		try {
			price = Integer.parseInt(tok.nextToken());
			quantity = Integer.parseInt(tok.nextToken());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}

		return new SportEquipment(title, price, quantity);
	}

	//is the good contains in the shop?
	public boolean findSportEquipment(SportEquipment good) {
		return (!getGoods().containsKey(good)) || (getGoods().get(good) == 0) ? false
				: true;
	}

	//get good by it's title
	public SportEquipment getByTitle(String title) {
		for (SportEquipment good : getGoods().keySet()) {
			String t = good.getTitle();
			if (title.equals(t)) {
				return good;
			}
		}
		return null;
	}

	//print all goods in the shop
	public void printGoods() {
		String key, value;

		System.out.println("Goods in the shop: ");
		for (SportEquipment good : getGoods().keySet()) {
			key = good.toString();
			value = getGoods().get(good).toString();
			System.out.println(key + " Amount: " + value);
		}
		System.out.println();
	}

	//print rented goods in the shop
	public void printRentedGoods() {
		System.out.println("Rented sport goods: ");

		for (SportEquipment good : getGoods().keySet()) {
			if (good.getQuantity() != getGoods().get(good)) {//if good was taken
				String key = good.toString();
				System.out.println(key);
			}
			System.out.println();
		}
	}

	public Map<SportEquipment, Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<SportEquipment, Integer> goods) {
		this.goods = goods;
	}

	public TreeMap<Client, RentUnit> getClientRentUnits() {
		return clientRentUnits;
	}

	public void setClientRentUnits(TreeMap<Client, RentUnit> clientRentUnits) {
		this.clientRentUnits = clientRentUnits;
	}
}
