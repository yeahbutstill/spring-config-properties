# spring-config-properties

## Pengenalan Config Properties

- Saat kita membuat aplikasi, sudah dipastikan bahwa kita pasti akan menambahkan konfigurasi pada aplikasi
- Misal saja konfigurasi database misalnya
- Spring sendiri memiliki fitur yang sangat baik dalam mendukung pengaturan konfigurasi aplikasi
- Pada kelas ini, kita akan bahas bagaimana cara melakukan konfigurasi pada aplikasi Spring yang kita buat

## Membuat Project

- https://start.spring.io/

## Resource

- Sebelum kita belajar tentang Config Properties di Spring, kita perlu belajar dulu tentang Resource di Spring
- Di Java terdapat fitur bernama Java IO (Input Output) sebagai management resource
- Spring membungkus resource dalam sebuah interface bernama Resource
- https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/Resource.html
- Walaupun Resource adalah sebuah interface, untuk membuatnya kita tidak perlu mengimplementasikan secara manual, sudah
  banyak implementasi class Resource di Spring

## Resource Implementation

- [Di sini](/images/img.png)

## Resource Loader

- Spring memiliki fitur yang bisa kita gunakan untuk mengambil data resource secara otomatis, tanpa kita harus membuat
  object resource nya, namanya ResourceLoader
- https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/ResourceLoader.html
- ResourceLoader memiliki method bernama getResource(String) yang bisa kita gunakan untuk mengambil sebuah resource
- ResourceLoader akan mendeteksi jenis Resource yang butuh diambil dari data String nya

## Resource Protocol

| Prefix     | Sample                                          | Description                                     |
|------------|-------------------------------------------------|-------------------------------------------------|
| classpath: | classpath:/com/pzn/application.properties       | Mengambil resource dari classpath (isi project) |
| file       | file:///Users/khannedy/file.properties          | Mengambil resource dari file system             |                        
| https:     | https://www.programmerzamannow/file.properties  | Mengambil resource dari http                    |                        

## Resource Loader Aware

- ResourceLoader adalah sebuah interface, sehingga untuk menggunakannya, kita perlu implementasi class nya
- ApplicationContext adalah turunan dari ResourceLoader, sehingga kita juga bisa menggunakan ApplicationContext untuk
  mendapatkan Resource
- Atau kita juga bisa menggunakan ResourceLoaderAware untuk mendapatkan ResourceLoader secara otomatis
- https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ResourceLoaderAware.html

## Message Source

* Spring memiliki fitur yang bernama Message Source, yaitu fitur untuk mengambil message dari resource
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSource.html
* MessageSource mengkombinasikan Properties dan MessageFormat, sehingga kita tidak perlu melakukannya secara manual
  seperti yang pernah kita praktekan di kelas Java Internationalization

## Properties

* Pada Kelas Java, kita sudah belajar tentang Properties dan juga cara melakukan Internationalization menggunakan
  Properties
* Di Spring, kita juga melakukan hal yang sama, dengan cara yang lebih baik, tidak perlu melakukannya secara manual

## Message Source Implementation

* MessageSource adalah sebuah interface, untuk menggunakannya, kita butuh implementasi class nya
* Kita tidak butuh membuatnya secara manual, kita bisa menggunakan class implementasi yang sudah disediakan oleh Spring,
  yaitu ResourceBundleMessageSource
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/ResourceBundleMessageSource.html

## Spring Boot Message Source

* Jika kita menggunakan Spring Boot, secara otomatis Spring Boot telah membuat Message Source secara otomatis, kita
  tidak perlu membuat bean untuk Message Source secara manual
* Selain itu secara default, Spring Boot akan membuat Message Source dengan mengambil data resource bundle di
  messages.properties

## Message Source Aware

* Jika kita ingin menggunakan MessageSource, kita juga bisa menggunakan MessageSourceAware
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSourceAware.html
* Atau sebenarnya, ApplicationContext adalah turunan dari MessageSource

## Application Properties

* Saat kita membuat project Spring menggunakan start.spring.io, secara otomatis terdapat sebuah file
  application.properties
* File ini adalah pusat dari file properties untuk konfigurasi aplikasi Spring yang kita buat
* Secara otomatis, Spring Boot akan membaca konfigurasi yang kita masukkan ke dalam file application.properties
* Ini bukanlah file untuk Internationalization, melainkan file ini digunakan untuk konfigurasi aplikasi, jika kita butuh
  pesan untuk Internationalization, gunakan file messages.properties seperti yang sudah kita bahas sebelumnya

## Mengakses Application Properties

* Ada banyak cara untuk mengakses konfigurasi yang terdapat di application.properties, nanti akan dibahas di chapter
  masing-masing

## Environment

* Environment tidak hanya bisa digunakan untuk mengakses Application Properties
* Environment juga bisa digunakan untuk mengakses data environment variable pada sistem operasi
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html
* Kita bisa menggunakan EnvironmentAware jika ingin mendapatkan object Environment

## Value

* Value merupakan Annotation yang bisa kita gunakan untuk melakukan inject data dari properties ke field yang kita
  tandai
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html

## Value Application Properties

* Annotation Value bisa kita gunakan untuk mengambil data dari application properties
* Kita bisa menggunakan kode ${nama.properties.nya}
* Secara otomatis akan diambil valuenya, dan secara otomatis akan melakukan konversi juga

## Value System Variable

* Selain application properties, Annotation Value juga bisa digunakan untuk mengambil data dari system properties atau
  environment variable
* Caranya sama seperti mengambil application properties
* Secara otomatis akan diambil valuenya, dan secara otomatis akan melakukan konversi juga

## Property Source

* Secara default, application properties hanya akan mengambil dari file di application.properties yang terdapat di
  classpath project
* Namun, Spring memiliki fitur yang bisa kita gunakan jika kita ingin menambahkan application properties dari file lain,
  namanya adalah PropertySource
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html
* Kita bisa sebutkan Resource mana yang kita tambahkan ke application properties
* Jika kita ingin menambah lebih dari satu property source, kita bisa gunakan annotation PropertySources

## Test Property Source

* Saat membuat unit test, kadang-kadang kita ingin menggunakan properties file yang berbeda untuk mencoba skenario yang
  berbeda
* Hal ini agak sulit jika dilakukan dengan menggunakan Annotation PropertySource
* Untungnya di Spring sudah disediakan Annotation TestPropertySource untuk kebutuhan ini, jadi kita bisa menggunakan
  properties file yang kita mau di unit test
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/TestPropertySource.html
* Jika membutuhkan properties file lebih dari satu, kita bisa gunakan annotation TestPropertySources