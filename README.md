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

## Kode : Properties

```properties

```