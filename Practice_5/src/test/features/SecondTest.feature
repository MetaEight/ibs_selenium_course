@all
@severity=blocker
@issue=1234
@tmslink=12345
Feature: Электроника

@SecondTest
  Scenario: На странице товаров раздела "Наушники" отображается 12 товаров, первый товар в списке сравнить с товаром, найденым при поиске по такому же имени
    Given Главная страница: раскрываем список всех сервисов, находим 'Яндекс маркет' и открываем
    And Главная страница Маркета: открываем раздел 'Электроника'
    And Электроника: выберем раздел 'Наушники и аудиотехника', а затем раздел 'Наушники и Bluetooth-гарнитуры'
    And Страница товаров: откроем страницу 'Все фильтры'
    And Все фильтры: стоимость товаров от "5000"
    And Все фильтры: производитель "JBL"
    And Все фильтры: показать товары
    And Страница товаров: проверим что на странице отображается 12 товаров
    And Страница товаров/Наушники: получим имя первого товара в списке и проверим, найдется ли он через строку поиска