package com.jfs.OnlineFlowers.service;

import java.util.List;
import java.util.Set;

import com.jfs.OnlineFlowers.entity.product.Category_Flowers;
import com.jfs.OnlineFlowers.entity.product.Flowers;

public interface FlowerService {
	public Flowers addFlowers(Flowers flower) throws Exception;
	public Flowers updateFlowers(Flowers flower);
	public List<Flowers> getFlowers();
	public Flowers getFlowers(String fname);
	public Flowers getFlowersByCategory(Category_Flowers categoryflower);
	public void deleteFlowers(String fname);
	public List<Flowers> getFlowerByOrder(int orderid);
}
