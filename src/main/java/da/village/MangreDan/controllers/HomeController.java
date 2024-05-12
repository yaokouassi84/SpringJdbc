package da.village.MangreDan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String getHomePageContent() {
		// Code pour récupérer le contenu de la page d'accueil depuis la base de données
		// ou autre source
		return "home";
	}
}
