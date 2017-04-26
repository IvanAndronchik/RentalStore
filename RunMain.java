package edu.bsu.sportshop.runmain;

/**
 *Title: Test
 *Description:test program
 *Copyright: Ivan Andronchik Copyright (c) 2017
 * Company:
 * @author Ivan Andronchik
 * @version 0.1
 *
 */

import edu.bsu.sportshop.client.Client;
import edu.bsu.sportshop.shop.Shop;


public class RunMain {

	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.printGoods();

		Client c1 = new Client("Andronchik1", "Ivan");
		Client c2 = new Client("Andronchik2", "Ivan");
		Client c3 = new Client("Andronchik3", "Ivan");
		
		shop.rentByTitle("Basketball boots", c1);
		shop.rentByTitle("Ping Pong", c2);
		shop.rentByTitle("Balls", c3);
		shop.printGoods();
		shop.printRentedGoods();
	}

}
