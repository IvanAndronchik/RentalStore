package edu.bsu.sportshop.shop;

/**
 * Title: Rented goods 
 * Description:store information rented goods, Copyright:
 * Ivan Andronchik Copyright (c) 2017 
 * Company:
 * 
 * @author Ivan Andronchik
 * @version 0.1
 *
 */

public class RentUnit {
	private final int goodsLimit = 3;//maximum  good that ou can rent
	private int goods;//amount of rented goods
	private SportEquipment[] units;//rented goods

	/**
	  * Constructor Shop
	  */
	
	RentUnit() {
		this.units = new SportEquipment[goodsLimit];
		this.goods = 0;
	}

	//find good
	public int findSportEquipment(SportEquipment good) {
		for (int i = 0; i < goods; i++) {
			if (units[i] == good)
				return i;
		}
		return -1;

	}
	
	//return good
	public boolean deleteSportEquipment(SportEquipment good) {
		int i = findSportEquipment(good);
		if (i < 0)//no such good in rental unit
			return false;
		units[i] = units[goods];
		goods--;
		return true;

	}

	//rent good 
	public boolean addSportEquipment(SportEquipment good) {
		if (goods >= goodsLimit)//over the limit
			return false;
		units[goods] = good;
		goods++;
		return true;
	}
}
