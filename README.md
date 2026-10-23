# Diplom_3 — автотесты UI для Stellar Burgers

Задание 3 второй части дипломного проекта «Автоматизатор тестирования на Java» (Яндекс Практикум): UI-автотесты веб-приложения [Stellar Burgers](https://stellarburgers.education-services.ru/) с паттерном Page Object, прогоном в двух браузерах и Allure-отчётом.

> ⚠️ На момент сдачи основной адрес приложения на технических работах, поэтому тесты выполняются на QA-адресе: `https://qa-stellarburgers.education-services.ru/` (константа `BASE_URL` в `UrlConstants`). Для переключения на прод достаточно поменять одну константу.

## Стек

- Java 11, Maven
- JUnit 4.13.2
- Selenium Java 4.29.0, WebDriverManager 5.9.2
- REST Assured 5.5.0 + Gson — фикстура (подготовка данных через API)
- Lombok
- Allure 2.15.0

## Покрытые сценарии (9 тестов)

| Класс | Сценарии |
|---|---|
| `RegistrationTests` | успешная регистрация; регистрация с паролем короче 6 символов (ошибка «Некорректный пароль») |
| `LoginTests` | вход по кнопке «Войти в аккаунт»; через «Личный кабинет»; через кнопку в форме регистрации; через кнопку в форме восстановления пароля |
| `ConstructorTests` | переходы к разделам конструктора: «Булки», «Соусы», «Начинки» |

## Структура проекта

```
src/test/java/
├── client/StellarBurgersClient.java   — API-клиент для фикстуры (создание/удаление пользователя)
├── constants/
│   ├── DriverConfig.java              — браузеры, пути, ожидания
│   └── UrlConstants.java              — адреса страниц и эндпоинтов API
├── core/
│   ├── BaseTest.java                  — жизненный цикл теста (@Before/@After)
│   └── DriverFactory.java             — создание драйвера для Chrome и Яндекс Браузера
├── model/UserModel.java               — модель пользователя
├── page/objects/                      — Page Object: MainPage, LoginPage, RegisterPage, ForgotPasswordPage
├── tests/                             — RegistrationTests, LoginTests, ConstructorTests
└── utils/TestDataGenerator.java       — генерация уникальных тестовых данных
```

## Запуск тестов

Google Chrome:

```bash
mvn clean test
```

Яндекс Браузер:

```bash
mvn clean test -Dbrowser=yandex
```

WebDriverManager сам скачивает chromedriver под установленный браузер. Для Яндекс Браузера версия его движка Chromium задаётся в `DriverConfig.YANDEX_CHROMIUM_VERSION` (у Яндекса движок может отличаться от версии Chrome — константу нужно обновлять при обновлении браузера).

## Allure-отчёт

Самый простой способ — готовый скрипт с закоммиченными результатами финального прогона:

```bash
bash scripts/run-allure-report.sh
```

Отчёт откроется в браузере. Чтобы собрать отчёт из собственного прогона:

```bash
mvn clean test                 # Chrome
mvn test -Dbrowser=yandex      # Яндекс Браузер (результаты складываются в один отчёт)
mvn allure:serve
```
