package edu.bsu.sportshop.client;

/**
 *Title: Client
 *Description: information about client of th shop
 *Copyright: Ivan Andronchik Copyright (c) 2017
 * Company:
 * @author Ivan Andronchik
 * @version 0.1
 *
 */

public class Client implements Comparable<Client> {

	private static int id_count = 0;
	private int id;//client's id
	private String name;//client's name
	private String surname;//client's surname

	/**
	  * Constructor Shop
	  */
	
	Client() {
		setId(0);
		setName("");
		setSurname("");
	}

	/**
	  * Constructor Shop
	  */
	
	public Client(String name, String surname) {
		setId(++id_count);
		this.setName(name);
		this.setSurname(surname);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int compareTo(Client c) {
		if (c.getId() < this.getId())
			return -1;
		if (c.getId() > this.getId())
			return 1;
		return 0;
	}
}
