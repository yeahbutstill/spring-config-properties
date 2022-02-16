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

## Profile

* Profile merupakan fitur di Spring yang bisa kita gunakan untuk menentukan component jalan di profile mana
* Profile cocok sekali ketika kita butuh component berbeda pada kondisi tertentu, misal kita buat component untuk
  koneksi ke Memory Database, tapi jika di Local misal, kita ingin component nya diganti dengan koneksi di memory
  aplikasi saja
* Untuk menandai sebuah component dengan informasi Profile, kita bisa menggunakan Annotation Profile
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html

## Profile Properties

* Untuk menentukan profile apa yang berjalan, kita bisa menentukannya di application properties dengan menggunakan key
  spring.profiles.active
* Dimana kita bisa menentukan active profile lebih dari satu jika kita mau

## Active Profile

* Kadang jika harus mengubah profile di application properties akan menyulitkan ketika kita membuat unit test untuk
  beberapa profile
* Untuk mengubah profile di unit test, kita bisa menggunakan annotation ActiveProfiles
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/ActiveProfiles.html

## Profile di Environment

* Kadang kita ingin mendapatkan profile pada saat aplikasi berjalan
* Jika ada kasus seperti ini, kita bisa menggunakan Environment
* Terdapat method getActiveProfiles() untuk mendapatkan profile yang sedang aktif
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html#getActiveProfiles--

## Profile Properties File

* Saat kita menggunakan fitur profile, kita juga bisa membuat file properties sesuai dengan profile yang aktif
* Penamaan properties file adalah application-{profile}.properties
* Misal jika active profile adalah dev, maka application-dev.properties akan di load
* Jika active profile lebih dari satu, maka semua files properties tiap profile akan di load
* Jangan lupa application.properties akan tetap di load disemua profile

## Configuration Properties

* Spring Boot memiliki sebuah fitur canggih bernama Configuration Properties
* Fitur ini bisa digunakan melakukan binding secara otomatis key yang ada di application properties ke Java Bean
  property secara otomatis
* Namun untuk menggunakan fitur ini, kita perlu menambahkan dependency yang dibutuhkan, yaitu
  spring-boot-configuration-processor

## Configuration Properties Annotation

* Untuk menandai Java Bean agar secara otomatis di binding ke Application Properties, kita perlu menandai class nya
  dengan annotation ConfigurationProperties
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConfigurationProperties.html
* Selanjutnya kita perlu menentukan prefix untuk key di application properties nya

## Spring Configuration Metadata

* Sebenarnya, untuk membuat Spring melakukan automatic binding ke Configuration Properties, kita harus membuat sebuah
  file metadata
* Namun hal tersebut tidak perlu kita lakukan manual, secara otomatis ketika menambahkan dependency configuration
  properties, dependency tersebut akan melakukan auto generate file metadata dari class yang kita tandai menggunakan
  annotation ConfigurationProperties
* Cara untuk membuat file metadata secara auto generate cukup kita lakukan kompilasi saja project kita, misal jika
  menggunakan maven, tinggal gunakan perintah : mvn compile

## Enable Configuration Properties

* Secara default, Configuration Properties tidak akan berjalan jika kita tidak beritahukan ke Spring Boot Application
* Kita perlu memberitahu bahwa kita membuat class Configuration Properties dengan menggunakan Annotation
  EnableConfigurationProperties
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/EnableConfigurationProperties.html

## Complex Configuration Properties

* Configuration Properties juga mendukung Java Bean yang kompleks, misal yang berisikan Java Bean object lain
* Hal ini membuat pembuatan Configuration Properties menjadi lebih mudah, karena tidak perlu kita lakukan secara manual

## Collection Configuration Properties

* Configuration Properties juga mendukung binding properties untuk jenis collection seperti List atau Map
* Hal ini kadang bermanfaat ketika memang data yang kita butuhkan sangat kompleks, bisa Collection yang berisi data
  sederhana, atau bahkan collection yang berisi Java Bean lagi

## Embedded Collection

* Configuration Properties juga mendukung jika kita membuat Java Bean di dalam collection

## Conversion

* Saat kita menggunakan config properties di Spring, ada pertanyaan, bagaimana Spring melakukan konversi data yang ada
  di properties file ke tipe data di Java?
* Jawabannya adalah karena Spring memiliki mekanisme konversi tipe data.
* Secara default, hampir semua tipe data umum di Java didukung, namun bagaimana jika tipe data yang kita buat sendiri?
* Jika ada kasus seperti itu, kita bisa membuat class Conversion sendiri

## Converter Interface

* Semua konversi tipe data di Spring sudah dibuat standarisasinya, yaitu menggunakan interface Converter
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/converter/Converter.html

## Default Converter

* Secara default, Spring juga sudah menyediakan Converter untuk tipe data bawaan Java, seperti Number, Boolean, Date,
  Calendar, Duration, dan lain-lain
* Kita bisa lihat secara semua class turunan dari Converter

## Custom Converter

* Jika ada kasus yang akhirnya mengharuskan kita membuat converter sendiri, kita bisa dengan mudah membuat class turunan
  interface Converter
* Misal kita coba buat Converter untuk tipe data String ke Date

## Kenapa Error?

* Secara default, jika kita ingin menggunakan custom Converter, kita harus registrasikan ke ConversionService
* ConversionService akan kita bahas di materi selanjutnya

## Conversion Service

* Conversion Service merupakan inti dari logic untuk melakukan konversi tipe data di Spring
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/ConversionService.html
* Saat kita membuat custom converter, maka kita harus registrasikan ke conversion service
* Kita tidak perlu membuat Conversion Service secara manual, karena implementasi class nya sudah disediakan oleh Spring,
  yaitu ApplicationConversionService
* Jika membuat aplikasi berbasis Web, kita tidak perlu melakukannya secara manual, karena sudah otomatis ada di Spring
  Boot Web, namun karena sekarang kita belum belajar Spring Boot Web, jadi kita perlu membuat Conversion Service secara
  manual

## Menggunakan Conversion Service

* Conversion Service selain bisa digunakan untuk melakukan konversi tipe data secara otomatis ketika kita menggunakan
  config properties, tapi juga bisa digunakan secara programmatically untuk melakukan konversi tipe data
* Caranya cukup kita ambil object ConversionService

## Externalized Properties File

* Saat aplikasi Spring Boot kita sudah selesai, semua config properties akan dibungkus di dalam jar file
* Pertanyaannya bagaimana jika kita ingin mengubah isi informasi nya?
* Misal konfigurasi database tidak mungkin kita simpan di dalam kode program
* Ada beberapa cara untuk menggunakan configuration dari luar aplikasi, ketika aplikasi kita sudah menjadi jar file

## External Properties File

* Pertama kita bisa membuat application.properties file dari luar, lalu ketika menjalankan aplikasi Jar Spring Boot
  kita, kita bisa menyebutkan lokasi application.properties nya
* Caranya kita bisa gunakan perintah :
* java -jar lokasi/file.jar --spring.config.location=lokasi/file/application.properties

## Environment Variable

* Saat kita menggunakan external properties file, properties file yang ada di dalam Jar tidak akan digunakan Hal ini
* menyebabkan kita harus menulis ulang semua properties key yang ada di properties file, dan kadang jika isinya terlalu
* banyak, ini sangat menyulitkan Spring Boot juga mendukung mengambil properties dari environment variable Hal ini
* membuat kita lebih mudah, karena tidak harus semua properties dibuat ulang di file external properties, cukup yang
* dibutuhkan aja Selain itu, kita juga bisa membuat default value ketika environment variable nya tidak ada
