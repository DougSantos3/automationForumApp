import io.appium.java_client.AppiumBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

class AppiumTest {

    private lateinit var driver: AndroidDriver<MobileElement>

    @Before
    fun setUp() {
        /* Configuração de DesiredCapabilities

            Capabilities: Define as capacidades para o Appium, como o nome do dispositivo, o pacote do aplicativo e a
            atividade principal.

            driver.findElement: Utiliza AppiumBy.id para localizar os elementos pelos IDs de recurso do aplicativo
            Android.

            driver.click(): Realiza cliques nos elementos da interface.

            assert: Verifica o resultado da operação realizada no aplicativo.
        */
        val capabilities = DesiredCapabilities().apply {
            setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
            setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator") // ou use o nome do seu dispositivo
            setCapability("appPackage", "com.android.calculator2") // Pacote do app de calculadora
            setCapability("appActivity", "com.android.calculator2.Calculator") // Atividade principal do app
        }

        // Inicializando o driver com Appium Server
        driver = AndroidDriver(URL("http://localhost:4723/wd/hub"), capabilities)
    }

    @Test
    fun testAddition() {
        // Localizando e interagindo com elementos da calculadora
        val digit2 = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2"))
        val plus = driver.findElement(AppiumBy.id("com.android.calculator2:id/op_add"))
        val digit3 = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_3"))
        val equals = driver.findElement(AppiumBy.id("com.android.calculator2:id/eq"))
        val result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result"))

        // Realizando a operação 2 + 3
        digit2.click()
        plus.click()
        digit3.click()
        equals.click()

        // Verificando o resultado
        assert(result.text == "5") { "O resultado esperado era 5, mas foi ${result.text}" }
    }

    @After
    fun tearDown() {
        driver.quit()
    }
    /* Abra o Appium Desktop e inicie o servidor ou inicie o Appium no terminal com appium.
     No IntelliJ IDEA, clique com o botão direito na classe AppiumTest e selecione Run 'AppiumTest'.
     O teste será executado e você verá a automação controlando o aplicativo de calculadora. */
}
