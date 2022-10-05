import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver.get("http://training.appline.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @Test
    public void test() {
        //Шаг 1: Авторизация
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Prohorova Alla");
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));

        //Шаг 2: Перейти к командировке
        WebElement costsList = driver.findElement(By.xpath(
                "//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']"));
        costsList.click();
        wait.until(ExpectedConditions.visibilityOf(costsList.findElement(By.xpath(
                "./ancestor::li//ul[@class='dropdown-menu menu_level_1']"))));
        driver.findElement(By.xpath("//span[text()='Командировки']")).click();

        //Шаг 3: Перейти к форме создания командировки
        driver.findElement(By.xpath(
                "//a[contains(@href, '/business-trip/create/') and @title='Создать командировку']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='user-name']"))));

        //Шаг 4: Заполнение формы создания командировки

        //Подразделение
        WebElement subdivisions = driver.findElement(By.xpath(
                "//select[contains(@name, 'crm_business_trip[businessUnit]')]"));
        subdivisions.click();
        wait.until(ExpectedConditions.attributeContains(subdivisions.findElement(By.xpath(
                "../../*")), "class", "focus"));
        subdivisions.findElement(By.xpath("//option[@value='6']")).click();

        //Организация
        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        WebElement organization = driver.findElement(By.xpath("//a[@class='select2-choice select2-default']"));
        organization.click();
        driver.findElement(By.xpath(
                "//div[@class='select2-result-label' and text()='(Хром) Призрачная Организация Охотников']")).click();

        //Задача
        WebElement task = driver.findElement(By.xpath("//input[@data-name='field__1']"));
        task.click();

        //Город прибытия
        WebElement arrival_city = driver.findElement(By.xpath("//input[@name='crm_business_trip[arrivalCity]']"));
        arrival_city.sendKeys("Россия, Брянск");

        //Даты выезда и возвращения
        WebElement departure_date = driver.findElement(By.xpath(
                "//input[@placeholder='Планируемая дата выезда']/../../input"));
        departure_date.sendKeys("28.09.2022");
        String departure_date_value = datepicker_value();

        WebElement return_date = driver.findElement(By.xpath(
                "//input[@placeholder='Планируемая дата возвращения']/../../input"));
        return_date.sendKeys("01.10.2022");
        String return_date_value = datepicker_value();
        return_date.sendKeys(Keys.TAB);

        //Шаг 4: Проверка указанных значений
        String subdivision_text = subdivisions.findElement(By.xpath("../span")).getText();
        Assertions.assertEquals(subdivision_text,"Отдел проектных сервисов","Выбрано неверное значение");

        String organization_text = organization.findElement(By.xpath("span[@class='select2-chosen']")).getText();
        Assertions.assertEquals(organization_text,"(Хром) Призрачная Организация Охотников","Выбрано неверное значение");

        assert task.isSelected();

        String departure_city_value = driver.findElement(By.xpath("//input[@name='crm_business_trip[departureCity]']")).getAttribute("value");
        Assertions.assertEquals(departure_city_value,"Россия, Москва","Выбрано неверное значение");
        String arrival_city_value = arrival_city.getAttribute("value");
        Assertions.assertEquals(arrival_city_value,"Россия, Брянск","Выбрано неверное значение");

        // Значение номера месяца в элементе указано в формате от 0 до 11
        Assertions.assertEquals(departure_date_value,"28.8.2022","Выбрано неверное значение");
        Assertions.assertEquals(return_date_value,"1.9.2022","Выбрано неверное значение");

        //Шаг 5: Сохранить введенные значения
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]/..")).click();
        wait.until(ExpectedConditions.visibilityOf(subdivisions.findElement(By.xpath(
                "../../*"))));
        By.xpath("div[@class='loader-content' and contains(text(),'Загрузка...']");

        //Шаг 6: Проверить наличие ошибки на старнице
        WebElement error_container = driver.findElement(By.xpath(
                "//span[text()='Командированные сотрудники']/../..//span[@class='validation-failed']"));
        Assertions.assertEquals(error_container.getText(),
                "Список командируемых сотрудников не может быть пустым","Не найдена соответствующая ошибка");
        System.out.println("Сценарий прошёл успешно");


    }


    @AfterEach
    public void after() {
        driver.quit();
    }

    public String datepicker_value() {
        WebElement datepicker = driver.findElement(By.xpath("//a[contains(@class, 'ui-state-active')]"));
        wait.until(ExpectedConditions.visibilityOf(datepicker));
        String datepicker_value_day = datepicker.getText();
        String datepicker_value_month = datepicker.findElement(By.xpath(
                "..")).getAttribute("data-month");
        String datepicker_value_year = datepicker.findElement(By.xpath("..")).getAttribute("data-year");
        return datepicker_value_day + '.' + datepicker_value_month + '.' + datepicker_value_year;
    }
}




