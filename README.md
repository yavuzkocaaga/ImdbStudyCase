Proje Requirement 

redis :
 Sunucusu indirilmeli -https://redis.io/download 
 Sunucu 127.0.0.1:6379 üzerinden başlatılmalı eğer farklı bir  ip yada  port üzerinden yapılmak istenirse application.yml üzerinden conf değerleri değiştirilmeli

lombok  :

Annotation processor olarak lombok kullanılmıştır. Kullandığınız ide'de plugin olarak eklenmeli ve annotation processor proje icin enable edilmelidir . 

Eclipse için  : https://projectlombok.org/setup/eclipse
Intellij için : https://projectlombok.org/setup/intellij

Servislerin çalıştırılması için :

Postman Collection : https://www.getpostman.com/collections/83c6cafca0244c83e1d2

Swagger URL = http://127.0.0.1:8080/swagger-ui.html



Proje mimarisi :

Initialize kısmında Datalar sistem ayağa kalkerken insert olmakta ve her sistem tekrar çalıştırıldığında önce silip sonra insert etmektedir bu nedenler data dublicate söz konusu değildir.

Spring-data-redis implementation kullanılmıştır. Bu şekilde Spring boot repository katmanları implement edilebilmiştir.
Profesyonel sistemlerde Performans kiriterleri göz önünde bulundurulursa Spring data redis yerine RedisConnectionFactory paterni daha verimli olaracaktır. 



Test Case :

 Rest servislerin testleri yazılmıştır.


Data:

 Imdb api servindeki tsv.gz uzantılı file ile alınıp sadeleştirilerek kullanılmıştır. Uygulama içerisinde src\main\resources\data path altında json olarak bulunmaktadır.
