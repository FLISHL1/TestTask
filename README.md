# Тестовое задание
## REST api
Выполненно 4 из 5 заданий

Эндпоинты:
* GET: /api/product - выводит весь список товаров
  Ответ:
  ```
  [
    {
        "id": 2,
        "name": "Товар1",
        "description": null,
        "price": 1.0,
        "available": true
    },
    {
        "id": 102,
        "name": "Товар331",
        "description": null,
        "price": 0.0,
        "available": false
    }
  ]
  ```
* GET: /api/product/2 - выводит конкретный товар по id сущности
  Ответ:
  ```
  {
    "id": 2,
    "name": "Товар1",
    "description": null,
    "price": 1.0,
    "available": true
  }  
  ```
* POST: /api/product
  В теле запроса указывается сущность продукта без id на основе которой создается обьект товара и сохраняется в БД, например, тело запроса:
   ```
   {
      "name": "Товар1",
      "description": "Описание1",
      "price": 1,
      "available": false
  }
  ```
  Ответ:
  ```
  {
      "id": 202,
      "name": "Товар1",
      "description": "Описание1",
      "price": 1.0,
      "available": false
  }
  ```
* PUT: /api/product/2
  В теле запроса указываются поля которые нужно изменить (id не меняетяся) пример тела запроса:
  ```
   {
    "available": false
  }
  ```
  Ответ:
  ```
  {
    "id": 2,
    "name": "Товар1",
    "description": null,
    "price": 1.0,
    "available": false
  }
  ```
* DELETE: /api/product/2
  Удаляет обьект
  Код ответа 200
  
