# phonenumber-validator-4j

## A propos

SDK Java permettant de valider, qualifier un numéro de téléphone calédonien.


## Comment utiliser le sdk

### Configurer le pom.xml

- ajouter la repo Github
```xml
<repositories>
    <repository>
        <id>github</id>
        <name>GitHub OPT-NC Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/opt-nc/phonenumber-validator-4j</url>
    </repository>
</repositories>
```


## Exemples de code

Plusieurs exemples sont disponibles dans la class Main du projet.

La classe utilitaire `PhoneNumberValidator` ne prend en entrée que des chaines de caractères respectant la norme `e164`, i.e de la forme "+687123456".

La méthode `format`, permet de convertir le numéro de téléphone dans la norme `e164`.


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


#### Formatter un numéro de téléphone avec la norme e164

```java
String mobilePhoneNumber = PhoneNumberValidator.format("514243");
System.out.println("Numéro de téléphone formatté : " + mobilePhoneNumber);
```
```shell
Numéro de téléphone formatté : +687514243
```
