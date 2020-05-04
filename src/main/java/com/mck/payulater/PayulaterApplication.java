package com.mck.payulater;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mck.payulater.domain.Bill;
import com.mck.payulater.domain.Category;
import com.mck.payulater.domain.User;
import com.mck.payulater.repositories.BillRepository;
import com.mck.payulater.repositories.CategoryRepository;
import com.mck.payulater.repositories.UserRepository;

@SpringBootApplication
public class PayulaterApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PayulaterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "Groceries");
		Category category2 = new Category(null, "Restaurant");
		Category category3 = new Category(null, "Internet provider");
		
		
		Bill bill1 = new Bill(null, "Walmart", null, 2.38, "Tofu", category1);
		Bill bill2 = new Bill(null, "Panera", null, 9.41, "Soup", category2);
		Bill bill3 = new Bill(null, "Internet", null, 41.24, "Rogers", category3);
		Bill bill4 = new Bill(null, "No Frills", null, 4.8, "Peanuts", category1);
		
		category1.getBills().addAll(Arrays.asList(bill1, bill4));
		category2.getBills().addAll(Arrays.asList(bill2));
		category3.getBills().addAll(Arrays.asList(bill3));
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
		billRepository.saveAll(Arrays.asList(bill1, bill2, bill3, bill4));
		
		User user1 = new User(null, "Maraur", "Marcus Aurelius", "6475640000", "mcksiq@gmail.com");
		User user2 = new User(null, "GenK", "Genghis Khan", "6475640001", "gehkan@gmail.com");
		User user3 = new User(null, "AdaL", "Ada Lovelace", "6475640002", "adalo@gmail.com");
		User user4 = new User(null, "SantosD", "Santos Dumont", "6475640003", "aviao@gmail.com");
		User user5 = new User(null, "Nero", "Nero Claudius", "6475640004", "burnkekeke@gmail.com");

		List<User> friendList1 = Arrays.asList(user2, user4, user5);
		System.out.println("Trying to create friends relations: 2 \n");
		user1.setFriends(friendList1);
		
//		user1.getFriends().addAll(Arrays.asList(user2,user5));

		System.out.println("Trying to create friends relations: 3 \n");
		user3.setFriends(Arrays.asList(user4));
		userRepository.saveAll(Arrays.asList(user1,user2, user3, user4, user5));
//		user2.get
//		userRepository.saveAll(Arrays.asList(user1));
		
	}

}
