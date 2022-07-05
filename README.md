# ❔ phonenumber-validator

SDK Java permettant de valider, qualifier un numéro de téléphone calédonien.


## ⬇️ Import de la dépendance publique

Cette dépendance est disponible publiquement via [Jitpack](https://jitpack.io/#opt-nc/phonenumber-validator).

### 🪶 Maven

Ajouter la repo [Jitpack](https://jitpack.io/) :

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Puis la dépendance :

```xml
<dependency>
  <groupId>com.github.opt-nc</groupId>
  <artifactId>phonenumber-validator</artifactId>
  <version>Tag</version>
</dependency>
```

### 🐘 Gradle

Ajouter la repo :

```
allprojects {
  repositories {
			...
  maven { url 'https://jitpack.io' }
		}
}
````

Puis la dépendance :

```
dependencies {
  implementation 'com.github.opt-nc:phonenumber-validator:Tag'
}
```


## ✍️ Exemples de code

Plusieurs exemples sont disponibles dans la classe Main du projet.

La classe utilitaire `PhoneNumberValidator` ne prend en entrée que des chaines de caractères respectant la norme `E.164`, i.e de la forme "+687123456".

La méthode `format`, permet de convertir un numéro de téléphone sur 6 digits dans la norme `E.164`.


#### Connaitre le type de numéro de téléphone

```java
    System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType("+687514243").name());
    System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile("+687514243") ? "oui" : "non"));
    System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe("+687514243") ? "oui" : "non"));
```

```shell
Type de numéro : MOBILE
Mobile ? : oui
Fixe ? : non
```


#### Formatter un numéro de téléphone en respectant la norme E.164

```java
String mobilePhoneNumber = PhoneNumberValidator.format("514243");
System.out.println("Numéro de téléphone formatté : " + mobilePhoneNumber);
```
```shell
Numéro de téléphone formatté : +687514243
```
