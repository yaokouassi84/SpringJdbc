/*package da.village.MangreDan;



public class SeleniumTest {
	private WebDriver driver;

    @Before
    public void setUp() {
       
        System.setProperty("webdriver.chrome.driver", "chemin/vers/chromedriver.exe");
        
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePageTitle() {
       
        driver.get("http://localhost:8080");

        
        assertEquals("Titre de votre page d'accueil", driver.getTitle());
    }

    @After
    public void tearDown() {
       
        driver.quit();
    }
}
*/