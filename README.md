# sporcle

> Тестовый автоматизированный фреймворк

```
protected Response getResponse(String endpoint, Map<String, String> headers, Map<String, String> formParams) {
        return given()
                .headers(headers)
                //.body("email=test%40test.xyz&passwd=7298472839432&remember=1")
                .formParams(formParams)
                .when()
                .post(endpoint);
    }
```

[Официальный сайт sporcle](https://www.sporcle.com/)

[Онлайн магазин](https://www.sporcle.com/)

#### Романовская Анета

можно добавить картинки (в проекте папка docs) или описать тестовые сценарии. Мб перечисления использованных утилит