package da.village.MangreDan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

	@GetMapping("/about")
	public String getAboutPageContent() {
		// Code pour récupérer le contenu de la page "À propos" depuis la base de
		// données ou autre source
		return "about";
	}
}
