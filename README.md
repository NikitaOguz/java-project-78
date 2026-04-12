### Hexlet tests and linter status:
[![Actions Status](https://github.com/NikitaOguz/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/NikitaOguz/java-project-78/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-78&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-78)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-78&metric=bugs)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-78)

Валидатор данных (Java)

Данный проект направлен на создание библиотеки для проверки различных типов данных (чисел, строк и объектов типа Map) на основе определённых правил.

Схема StringSchema содержит следующий набор методов:

required() — делает данные обязательными для заполнения. Иными словами, добавляет в схему ограничение, которое не позволяет использовать null или пустую строку в качестве значения.

minLength() — добавляет в схему ограничение минимальной длины строки. Строка должна быть равна или длиннее указанного числа.

contains() — добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку.
