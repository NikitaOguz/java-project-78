### Hexlet tests and linter status:
[![Actions Status](https://github.com/NikitaOguz/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/NikitaOguz/java-project-78/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-78&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-78)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-78&metric=bugs)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-78)

# **Валидатор данных (Java)**

Данный проект направлен на создание библиотеки для проверки различных типов данных (чисел, строк и объектов типа `Map`) на основе определённых правил.

## **Схема `StringSchema`**

Схема `StringSchema` содержит следующий набор методов:

- **`required()`** — делает данные обязательными для заполнения. Иными словами, добавляет в схему ограничение, которое не позволяет использовать `null` или пустую строку в качестве значения.

- **`minLength()`** — добавляет в схему ограничение минимальной длины строки. Строка должна быть равна или длиннее указанного числа.

- **`contains()`** — добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку.  

Пример использования:

import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

var v = new Validator();

var schema = v.string();

// Пока не вызван метод required(), null и пустая строка считаются валидным
schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

// Если один валидатор вызывался несколько раз
// то последний имеет приоритет (перетирает предыдущий)
var schema1 = v.string();
schema1.minLength(10).minLength(4).isValid("Hexlet"); // true
