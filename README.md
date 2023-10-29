#Test

"Test" - это проект на Java, реализующий задачу поставленную мне на техническом собеседовании со следующими условиями...

"У нас есть большой файл справочник и есть ограничение по памяти, мы не можем выгрузить файл целиком, нам нужно отсортировать данный файл в лексикографическом порядке"

Для решения поставленной задачи мною был реализован процесс внешней сортировки для сортировки данных из текстового файла. Внешняя сортировка предполагает сортировку данных, которые не могут полностью поместиться в оперативной памяти компьютера. 
Вместо этого данные разделяются на более мелкие "куски" и сортируются в памяти, прежде чем объединиться в окончательный отсортированный файл.

#Как это работает

Процесс сортировки включает в себя несколько этапов:

Чтение данных из исходного файла.
Разделение данных на более мелкие "куски" для сортировки.
Сортировка каждого "куска" в памяти.
Сохранение временных файлов с отсортированными данными.
Объединение временных файлов в окончательный отсортированный файл.

#Логика проекта

Проект включает несколько классов, каждый выполняет конкретные задачи:

ExternalSorter: Этот класс является основным компонентом проекта. Он обрабатывает внешнюю сортировку данных из текстового файла. Вы найдете методы для чтения, сортировки и записи данных в этом классе.

SortingAlgorithm: Интерфейс, предоставляющий абстракцию для различных алгоритмов сортировки. В проекте используется этот интерфейс для сортировки "кусков" данных.

SimpleSortingAlgorithm: Класс, реализующий интерфейс SortingAlgorithm. Он предоставляет конкретную реализацию алгоритма сортировки. В проекте этот класс использует алгоритм сортировки из стандартной библиотеки Java, обычно основанный на алгоритме слияния (merge sort).

FileIO: Интерфейс, который определяет методы для чтения и записи файлов, предоставляя абстракцию для операций ввода/вывода.

SimpleFileIO: Класс, реализующий интерфейс FileIO. Он предоставляет конкретную реализацию операций ввода/вывода файлов, используемых для взаимодействия с файлами.

Эти классы взаимодействуют между собой для выполнения различных задач, необходимых для внешней сортировки данных из текстового файла. Внимательное изучение их кода позволит вам лучше понять, как они работают и как взаимодействуют друг с другом.

#Архитектура проекта

Архитектура проекта придерживается принципов SOLID, чтобы обеспечить его обслуживаемость и гибкость. Классы разработаны так, чтобы иметь четкие обязанности и способствовать модульности.

#Использование

Для начала процесса сортировки выполните следующие шаги:

Подготовьте исходный текстовый файл, который вы хотите отсортировать.

Укажите пути к исходному файлу и файлу для записи отсортированного результата в коде вашего приложения:

String inputFilePath = "путь/к/исходному_файлу.txt";

String outputFilePath = "путь/к/результирующему_файлу.txt";

Убедитесь, что у вас есть правильные пути к файлам перед запуском проекта.


#Автор

Артур Вакульчук Алексеевич (telegram -- +79156421554)

(Этим кодом мной было отсортировано 10000 тыс англоязычных книг, в лексикографическом порядке -- так что все работает в соответствии с условием задачи)


