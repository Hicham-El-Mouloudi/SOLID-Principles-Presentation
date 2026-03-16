# Principes SOLID & Design Patterns — Exemples Pratiques

Ce projet contient les **ressources du code** pratiqué lors de la présentation **« Principes SOLID & Design Patterns avec Java & Intellij IDE »**.

> *« Pour une architecture facile à comprendre, maintenir et plus flexible »*

📄 La présentation est disponible dans le dossier [`presentation/Présentation.pdf`](presentation/Présentation.pdf).

**Réalisé par :** Hicham El Mouloudi

---

## Organisation du Code

Chaque concept est illustré par **deux versions** du code :

| Dossier | Description |
|---------|-------------|
| `sale/` | ❌ Code **problématique** — illustre les mauvaises pratiques et les violations |
| `propre/` | ✅ Code **corrigé** — applique le principe ou le pattern correctement |

---

## Démos Pratiques

### IV. Le dilemme entre Composition et Héritage

#### 1. Les limites de la réutilisation du code par héritage

> **Problèmes identifiés :** duplication du code, erreurs non intentionnelles affectant les sous-classes, difficulté à connaître les comportements hérités, et implémentation statique dès l'instanciation.

**🔴 Approche par Héritage (`sale`) :**
- 📦 Package : `org.springformation.solid.principles.examples.composition_ou_heritage.sale`
- `Vehicule` → classe abstraite avec `injecterCarburant()`
- `Voiture` → hérite de `Vehicule` et réutilise `injecterCarburant()` via l'héritage
- `VoiturePerformance` → hérite de `Voiture`, change le comportement via des `if/else` statiques
- `GenerateurElectrique` → **duplique** le code de `injecterCarburant()` car il ne peut pas hériter de `Vehicule`

**🟢 Approche par Composition & Délégation (`propre`) :**
- 📦 Package : `org.springformation.solid.principles.examples.composition_ou_heritage.propre`
- `Voiture` → utilise la **composition** et l'**injection de dépendances** (`Injectable`)
- `VoiturePerformance` → change de comportement **en runtime** via le composant `Roulable` (sans `if/else`)
- `GenerateurElectrique` → réutilise `Injectable` par composition (pas de duplication)
- 📦 Sous-package `composants/` → interfaces `Injectable`, `Roulable` et leurs implémentations (`InjectionCarburant`, `RoulementNormal`, `RoulementPerformance`)

---

### V. Les Principes SOLID

#### 1. Single Responsibility Principle (SRP)

> *« Une classe ne devrait avoir qu'une seule raison de changer »*

##### a. Les niveaux de cohésion

La cohésion mesure le degré d'unité d'une classe et constitue un indicateur de bonne application du SRP.

- 📦 Classe : `org.springformation.solid.principles.examples.CohesionLevelsExamples`
  - **Cohésion forte** — `calculerSalaireCohesionForte()` : tâche complète + objectif unique
  - **Cohésion parasite** — `calculerSalaireParasite()` : tâche complète + objectifs mixtes
  - **Cohésion partielle** — `calculerPaieHeuresSup()` / `calculerPaieNormale()` : tâche partielle + objectif unique
  - **Cohésion faible** — `calculerPaie()` : tâche partielle + objectifs mixtes

##### b. Démo pratique : Le Iterator Pattern

> La collection a une seule responsabilité (stocker les éléments), et l'itérateur a une seule responsabilité (gérer la logique de parcours).

**🔴 Exemple problématique (`sale`) :**
- 📦 Package : `org.springformation.solid.principles.sale.iterator`
- `Order` → mélange la gestion des éléments et la logique de parcours

**🟢 Solution avec le pattern Iterator (`propre`) :**
- 📦 Package : `org.springformation.solid.principles.propre.iterator`
- `Iterator` → interface définissant `hasNext()` et `next()`
- `StandardArrayIterator` / `StandardOrderIterator` → implémentations concrètes interchangeables

---

#### 2. Open/Closed Principle (OCP)

> *« Une classe doit être ouverte à l'extension, mais fermée à la modification »*

##### Démo pratique : Le Decorator Pattern

> La classe de base est fermée à la modification, et le décorateur permet l'extension dynamique.

**🔴 Exemple problématique (`sale`) :**
- 📦 Package : `org.springformation.solid.principles.sale.decorator`
- `Burger` → classe unique avec des flags booléens (`extraCheese`, `extraMeat`, `glutenFreeBun`) et des `if` en cascade

**🟢 Solution avec le pattern Decorator (`propre`) :**
- 📦 Package : `org.springformation.solid.principles.propre.decorator`
- `Burger` → interface avec `getPrice()`
- `BurgerBase` → implémentation de base
- `ExtraCheeseDecorator`, `ExtraMeetDecorator`, `GlutenFreeBunDecorator` → décorateurs ajoutant des options dynamiquement sans modifier la classe existante

---

#### 3. Liskov Substitution Principle (LSP)

> *« Une classe dérivée doit pouvoir remplacer sa classe de base sans altérer le bon fonctionnement du programme »*

##### Démo pratique : Le Template Method Pattern

> La classe de base définit la structure invariable de l'algorithme, et la classe dérivée implémente les étapes spécifiques sans altérer cette structure.

**🔴 Exemple problématique (`sale`) :**
- 📦 Package : `org.springformation.solid.principles.sale.template`
- `OrderProcessor` → template method avec `checkIngredients()` dans le pipeline
- `GiftCardOrderProcessor` → lève une `UnsupportedOperationException` dans `checkIngredients()` (**violation LSP**)

**🟢 Solution avec un hook dans le Template Method (`propre`) :**
- 📦 Package : `org.springformation.solid.principles.propre.template`
- `OrderProcessor` → utilise un **hook** `hasIngredientsHook()` pour rendre `checkIngredients()` optionnel
- `GiftCardOrderProcessor` → redéfinit le hook pour retourner `false` (pas d'exception, respecte LSP)

---

#### 4. Interface Segregation Principle (ISP)

> *« Une classe ne devrait jamais être forcée de dépendre de méthodes ou d'interfaces qu'elle n'utilise pas »*

##### Démo pratique : Le Adapter Pattern

> Le client ne dépend que d'une interface cible petite et spécifique. L'adaptateur encapsule la classe tierce pour n'exposer que ce dont le client a besoin.

**🔴 Exemple problématique (`sale`) :**
- 📦 Package : `org.springformation.solid.principles.sale.adapter`
- `LegacyRestaurantSystem` → classe monolithique regroupant finance **et** inventaire
- `CashierApp` → dépend de tout le système, y compris `requestLowStockSupplies()` (**violation ISP**)

**🟢 Solution avec le pattern Adapter (`propre`) :**
- 📦 Package : `org.springformation.solid.principles.propre.adapter`
- `FinanceRestaurantSystem` → interface dédiée aux opérations financières
- `InventaireRestaurantSystem` → interface dédiée à la gestion de l'inventaire
- `FinanceAdapter` / `InventaireAdapter` → adaptateurs séparant les responsabilités
- `CashierApp` → ne dépend que de `FinanceRestaurantSystem` (respecte ISP)
- `InventoryApp` → ne dépend que de `InventaireRestaurantSystem`

---

#### 5. Dependency Inversion Principle (DIP)

> *« Les classes de haut niveau ne doivent pas dépendre des classes de bas niveau ; les deux doivent dépendre d'abstractions et non d'implémentations concrètes »*

##### Démo pratique : Le Factory Method Pattern

> Le code client (haut niveau) dépend uniquement d'une abstraction. La fabrique concrète (bas niveau) se charge de l'implémentation, inversant ainsi la dépendance.

**🔴 Exemple problématique (`sale`) :**
- 📦 Package : `org.springformation.solid.principles.sale.factory`
- `OrderService` → instancie directement `EmailNotifier` avec `new` (couplage fort)

**🟢 Solution avec le pattern Factory Method (`propre`) :**
- 📦 Package : `org.springformation.solid.principles.propre.factory`
- `OrderService` → classe abstraite dépendant de l'interface `Sender`
- `OrderServiceEmailNotif` → sous-classe fournissant l'implémentation via `createSender()`
- `Sender` → interface d'abstraction permettant l'inversion de dépendance

---

## Prérequis

- **Java 21** ou supérieur
- **Maven** pour la gestion du projet

## Comment exécuter

La classe `Main` est volontairement **vide**. Elle sert de point d'entrée pour que vous puissiez y ajouter votre propre code afin de **tester et expérimenter** les différents exemples du projet.

Par exemple, vous pouvez instancier les classes des packages `propre/` ou `sale/` pour observer les différences de comportement :

```java
public class Main {
    public static void main(String[] args) {
        // Ajoutez votre code ici pour tester les exemples
        // Ex: tester le pattern Decorator (OCP)
        Burger burger = new ExtraCheeseDecorator(new BurgerBase());
        System.out.println("Prix : " + burger.getPrice());
    }
}
```

Puis exécutez avec :

```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.springformation.solid.principles.Main"
```

---

## 📂 Arborescence des packages

```
org.springformation.solid.principles
├── examples/
│   ├── CohesionLevelsExamples              ← V.1.a  Niveaux de cohésion (SRP)
│   └── composition_ou_heritage/
│       ├── sale/                            ← IV.1   Héritage (problématique)
│       └── propre/                          ← IV.1   Composition & Délégation (solution)
│           └── composants/                  ←         Interfaces Injectable, Roulable
├── sale/                                    ← Exemples problématiques (violations SOLID)
│   ├── adapter/                             ← V.4    ISP violation
│   ├── decorator/                           ← V.2    OCP violation
│   ├── factory/                             ← V.5    DIP violation
│   ├── iterator/                            ← V.1    SRP violation
│   └── template/                            ← V.3    LSP violation
└── propre/                                  ← Solutions corrigées (Design Patterns)
    ├── adapter/                             ← V.4    Pattern Adapter (ISP)
    ├── decorator/                           ← V.2    Pattern Decorator (OCP)
    ├── factory/                             ← V.5    Pattern Factory Method (DIP)
    ├── iterator/                            ← V.1    Pattern Iterator (SRP)
    └── template/                            ← V.3    Pattern Template Method (LSP)
```
