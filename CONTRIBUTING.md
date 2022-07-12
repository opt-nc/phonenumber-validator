# Comment contribuer au projet

Merci de contribuer à Phonenumber-validator-4j !

En tant que contributeur, il y a de bonnes pratiques à suivre :

- chaque contribution doit être sous la même licence que Phonenumber-validator-4j, c'est-à-dire GNU General Public License version 3.
- chaque contribution devra rester aussi simple que possible, et devra être spécifique à un bug, problème ou fonctionnalité particulier.
- chaque contribution ne devra pas faire échouer les test unitaires.
- chaque contribution (quand cela est possible) devra être accompagnée de test unitaires assurants que la contribution fonctionne comme attendue.
- chaque commit devra respecter la convention des commits sémantiques ou commits conventionnels.
   

### Comment contribuer à un projet Open-Source

Nous vous recommandons de lire : 
- [comment contribuer à un projet open source](https://opensource.guide/how-to-contribute/)
- [comment contribuer à un projet Github](https://www.dataschool.io/how-to-contribute-on-github/)

### Commits sémantiques

Voici à quoi ressemble un message qui suit la convention des commits conventionnels

```
fix(bazel): pin `@microsoft/api-extractor` (#32187)

The API of `@microsoft/api-extractor` changed in a minor version which
is causes an error when using dts flattening downstream.

API wil be updated on master #32185

PR Close #32187
```

On reconnait la structure suivante:

```
<type>[optional scope]: <description>

[optional body]

[optional footer]
```

Voici les «types»  utilisés:


| Type   |   Signification / utilisation    |
|--------|:---------------------------------|
| feat   |Introduction d’une nouvelle feature (fonctionnalité)|
| fix    |Correction d’une erreur (bug)|
| docs   |Modification de la documentation uniquement|
| style  |Changement qui n’affecte pas la signification du code (espace, formatage, points-virgules manquants, etc.)|
| refactor |Changement de code qui ne corrige pas d’erreur et n’ajoute pas de fonctionnalité|
| perf   |Changement de code qui améliore les performances|
| test   |Ajout de tests manquants ou correction des tests existants|
| revert |Annule un commit précédent. Le message commencer par «revert:» : suivi du message du commit à annuler|
| build  |Changement qui affectent le système de compilation ou les dépendances externes|
| ci     |Modification des fichiers de configuration d’intégration continue (CI)|
| chore	 |Changement des scripts de construction du logiciel uniquement (pas de changement du code de l’application)|
