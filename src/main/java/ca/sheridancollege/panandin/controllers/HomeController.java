//Nandini Patel

package ca.sheridancollege.panandin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.panandin.beans.Furniture;
import ca.sheridancollege.panandin.database.DatabaseAccess;

@Controller
public class HomeController {
	
		@Autowired
		DatabaseAccess da;
		@GetMapping("/")
		public String goHome(Model model) {
			model.addAttribute("furniture", new Furniture());
			model.addAttribute("furnitureList", da.getFurniture());
			return "index";
		
		}
		
		@GetMapping("/add")
		public String add(Model model) {
			model.addAttribute("furniture", new Furniture());
			model.addAttribute("furnitureList", da.getFurniture());
			return "add";
		
		}
		
	@PostMapping("/insertFurniture")
	public String insertFurniture(Model model, @RequestParam String roomType, @RequestParam String furnitureCategory, 
			@RequestParam String furnitureName, @RequestParam String furnitureColor, @RequestParam Long furniturePrice) {
		da.insertFurniture(roomType, furnitureCategory, furnitureName, furnitureColor, furniturePrice);
		model.addAttribute("furniture", new Furniture());
		model.addAttribute("furnitureList", da.getFurniture());
		return "add";
		
	}
	
	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("furniture", new Furniture());
		model.addAttribute("furnitureList", da.getFurniture());
		return "view";
	
	}
	
	@GetMapping("/deleteFurniture/{id}")
	public String deleteFurniture(Model model, @PathVariable Long id) {
		da.deleteFurniture(id);
		model.addAttribute("furniture", new Furniture());
		model.addAttribute("furnitureList", da.getFurniture());
		return "view";
	}
	
	@GetMapping("/index")
	public String home(Model model) {
		model.addAttribute("furniture", new Furniture());
		model.addAttribute("furnitureList", da.getFurniture());
		return "index";
	
	}
}