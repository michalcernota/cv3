package com.nnpia.cv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Cv3Application {

	public static void main(String[] args) {
		SpringApplication.run(Cv3Application.class, args);
	}

	@Controller
	@RequestMapping({"/", "/store"})
	public class ShoppingCartController {
		private final ShoppingCartService shoppingCartService;
		private final StatsService statsService;

		public ShoppingCartController(ShoppingCartService shoppingCartService, StatsService usersService) {
			this.shoppingCartService = shoppingCartService;
			this.statsService = usersService;
		}

		@GetMapping({"/", "/store"})
		public String main(Model model) {
			Item item = new Item();
			item.setItemType(ItemType.Pizza);
			model.addAttribute("item", item);
			model.addAttribute("stats", statsService);
			return "store";
		}

		@PostMapping
		public String postItem(Item item, Model model) {
			shoppingCartService.add(item);
			statsService.increaseOrderCount();
			model.addAttribute("cart", shoppingCartService);
			model.addAttribute("stats", statsService);
			return "cart";
		}

		@GetMapping("/cart")
		public String getCart(Model model) {
			model.addAttribute("stats", statsService);
			model.addAttribute("cart", shoppingCartService);
			return "cart";
		}
	}
}
