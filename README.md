[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
[![🪶 Java CI with Maven](https://github.com/opt-nc/phonenumber-validator/actions/workflows/maven-build.yml/badge.svg?branch=main)](https://github.com/opt-nc/phonenumber-validator/actions/workflows/maven-build.yml)
[![](https://jitpack.io/v/opt-nc/phonenumber-validator.svg)](https://jitpack.io/#opt-nc/phonenumber-validator)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

⚠️ Repository archivé : le sdk a été intégré à [api-phonenumber-validator](https://github.com/opt-nc/api-phonenumber-validator)

# ❔ phonenumber-validator

SDK Java permettant de valider, qualifier un numéro de téléphone calédonien.

# 👶 Découvrir

Pour mieux comprendre comment est né ce projet, ce qu'il permet et les réalisations qu'il permet,
allez sur la [série dédiée PhoneNumber Validator sur DEV.to](https://dev.to/adriens/series/19561).

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

Plusieurs exemples sont disponibles dans la classe [Main](https://github.com/opt-nc/phonenumber-validator/blob/main/src/main/java/nc/opt/telecom/sdk/phonenumber/validator/Main.java) du projet.
Pour lancer l'exemple:
```shell
mvn compile exec:java
```


La classe utilitaire `PhoneNumberValidator` ne prend en entrée que des chaines de caractères respectant la norme `E.164`, i.e de la forme "+687123456".

La méthode `format`, permet de convertir un numéro de téléphone sur 6 digits dans la norme `E.164`.

#### Connaitre le type de numéro de téléphone

```java
System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType("+687514243").name());
System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile("+687514243") ? "oui" : "non"));
System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe("+687514243") ? "oui" : "non"));
System.out.println("Special ? : " + (PhoneNumberValidator.isSpecial("+687514243") ? "oui" : "non"));
```

```shell
Type de numéro : Mobile
Mobile ? : oui
Fixe ? : non
Special ? : non
```


#### Formater un numéro de téléphone en respectant la norme E.164

```java
String mobilePhoneNumber = PhoneNumberValidator.format("514243");
System.out.println("Numéro de téléphone formaté : " + mobilePhoneNumber);
```
```shell
Numéro de téléphone formaté : +687514243
```

## 🧰 Script J'Bang!

Un script Java est disponible dans le [catalogue J'Bang de l'OPT-NC](https://github.com/opt-nc/jbang-catalog).
Ce script permet d'utiliser le sdk sous forme de `CLI` [Picocli](https://picocli.info/).

### 👉 Pré-requis

- Installer J'Bang : 
  - [Tuto complet sur Killercoda](https://killercoda.com/opt-labs/course/jbang)

### 🕹️ Commandes

#### check

Le numéro est-il un numéro de mobile ?
```shell
jbang  phonenumber-validator@opt-nc/jbang-catalog -c is-mobile +687832583
```

Le numéro est-il un numéro de fixe
```shell
jbang  phonenumber-validator@opt-nc/jbang-catalog -c is-fixe +687832583
```

Le numéro est-il un numéro spécial (urgences, services OPT-NC, SOS)
```shell
jbang  phonenumber-validator@opt-nc/jbang-catalog -c is-special +68715
```

Le numéro est-il un numéro de téléphone possible/valide

```shell
jbang  phonenumber-validator@opt-nc/jbang-catalog -c is-valid +687832583
```

Avoir les infos du numéro de téléphone

```shell
jbang  phonenumber-validator@opt-nc/jbang-catalog -c info +687832583
```

### format

Formate le numéro de téléphone non formaté en numéro formaté en suivant la norme E.164
```shell
jbang  phonenumber-validator@opt-nc/jbang-catalog -f 83-25-83
```


:warning: Ne pas oublier de refraîchir regulièrement le cache J'Bang!

```shell
jbang cache clear
```


## 🙏 Remerciements

Ce projet a débuté suite à une [idée](https://github.com/orgs/opt-nc/discussions/13) lancée par [@MarketingCollectif ](https://github.com/MarketingCollectif) sur le [forum de discussion de opt-nc](https://github.com/orgs/opt-nc/discussions).

![image](https://user-images.githubusercontent.com/1823161/187096202-602060e3-2778-44a2-a487-b9b75e55ef3f.png)

Merci à [@MarketingCollectif ](https://github.com/MarketingCollectif) de nous avoir soumis sa demande, qui nous l'espérons, profitera àu plus grand nombre.
