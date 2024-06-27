# Тестовое задания для перехода на fullStack

## Задания

1. Написать автотесты для тестирования api сервиса cleanui.com (https://cleanuri.com/docs )
   2. Выполнить тест-дизайн / составить тестовый набор (положительные + отрицательные сценарии) и покрыть его автотестами 
   3. Тестовые данные (строка со ссылкой на сайт, которая будет "укорачиваться" в рамках работы тестируемого сервиса) необходимо вычитывать из внешнего файла
   

2. Написать автотесты для тестирования api сервиса randomuser.me (https://randomuser.me/documentation#howto )
   1. Выполнить тест-дизайн / составить тестовый набор (положительные + отрицательные сценарии) и покрыть его автотестами 
   2. При выполнении api-запросов необходимо использовать query-параметры (например, gender=male или results=2)
   3. Ответы сервиса необходимо распарсить в Java-объекты и выполнить проверки (asserts) с использованием этих объектов (рекомендовано применение коллекций и stream api)
   

3. Написать автотесты для тестирования формы https://demoqa.com/automation-practice-form
   1. Заполнить форму валидными данными (все поля)+ 
   2. Нажать на кнопку Submit+ 
   3. Проверить корректность заполнения формы (результаты во всплывающем окне "Thanks for submitting the form")+- 
   4. Также реализовать негативные проверки формы (валидация полей)


4. Написать автотест для страницы сайта https://people.sovcombank.ru/vacancies20:54 27.06.2024 :
   1. Перейти на страницу https://people.sovcombank.ru/
   2. Нажать на кнопку "Вакансии"
   3. Выбрать в фильтре вакансий Город = "Москва", Компания = "Совкомбанк Технологии"
   4. Собрать в коллекцию результаты работы фильтра (все найденные после фильтрации вакансии)
   5. Проверить, что у всех найденных результатов указан город "Москва" и компания "Совкомбанк Технологии"
   6. Рекомендуется применение паттерна PageObject 
   7. Использование локаторов - css или xpath


## Требования к стеку технологий и ПО:
1. Java 17
2. Maven
3. JUnit 5
4. IDE IntelliJ Idea
5. Rest Assured для api-тестов
6. Selenide для UI-тестов (браузер - chrome)
7. Asserts - AsserJ
8. Проект с тестами разместить в github/gitlab (можно оформить все задания в рамках одного репозитория)

## Дополнительно 

В проекте добавлены allure-report для сбора отчетов и просмотр метрик прохождения тестов

## Порядок выполнения команд для запуска отчета:

1. Выполнить тесты
``mvn clean test``
2. Собрать отчет по прохождению
``allure serve``