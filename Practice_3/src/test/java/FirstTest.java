import extension.AllureExtension;
import extension.DriverExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.Test;

import basetestclass.BaseTest;

@DisplayName(value = "Первый тест")
@ExtendWith({DriverExtension.class, AllureExtension.class})
public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        //Шаг 1: Авторизация, переход к странице 'Все командировки' и к созданию новой командировки
        GoToPageCreateNewBusinessTrip()
        //Шаг 2: Заполнение информации о командировке
                .selectSubdivision()
                .selectOrganization()
                .selectTask()
                .selectArrivalCity()
                .selectDepartureAndReturnDates()
                //Шаг 3: Проверка введеных данных
                .validationEnteredData()
                //Шаг 4: Проверка наличия ошибки при попытке создать командировку
                .saveAndClose()
                .checkErrorMsg();
    }

}




