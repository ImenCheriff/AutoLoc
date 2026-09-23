# AutoLoc API

API REST Spring Boot pour la gestion d'une agence de location de véhicules (projet pédagogique — UP ASI, Atelier 1).

## Stack technique

- Java 17+
- Spring Boot (Spring Web, Spring Data JPA, Validation, DevTools)
- MySQL 8+
- Lombok
- Maven

## Prérequis

- JDK 17 ou supérieur
- Maven (ou le wrapper `mvnw` fourni par le projet)
- Un SGBD MySQL installé et démarré
- IntelliJ IDEA (Community ou Ultimate)

## Installation

1. Cloner le dépôt :
   ```bash
   git clone <url-du-depot>
   cd autoloc-api
   ```

2. Copier le fichier de configuration d'exemple et le compléter avec tes propres identifiants :
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```
   Puis éditer `spring.datasource.password` (et `username` si besoin) dans le fichier copié.

   > ⚠️ `application.properties` contient des informations sensibles et n'est **pas** versionné (voir `.gitignore`).

3. S'assurer que MySQL est démarré. La base `autoloc_db` sera créée automatiquement au premier lancement grâce à `createDatabaseIfNotExist=true`.

4. Dans IntelliJ, activer l'annotation processing pour Lombok :
   `File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors` → cocher **Enable annotation processing**.

## Lancer le projet

Depuis IntelliJ : ouvrir `AutolocApiApplication.java` puis clic droit → **Run**.

Ou en ligne de commande :
```bash
./mvnw spring-boot:run
```

Le démarrage réussi affiche `Started AutolocApiApplication in … seconds` dans la console, suivi des requêtes DDL générées par Hibernate (création des tables).

## Structure du projet

```
tn.esprit.autoloc
├── domain          # Entités JPA et énumérations
├── repository      # Interfaces Spring Data JPA
├── service          # Couche métier
├── web.controller   # Contrôleurs REST
└── web.dto          # DTO
```

## Modèle de données

Entités principales : `Vehicule`, `Agence`, `Client`, `Employe`, `Equipement`, `Reservation`, `Contrat`, `Paiement`, `Maintenance`.

## Configuration Hibernate

`spring.jpa.hibernate.ddl-auto=update` — Hibernate met à jour automatiquement le schéma à partir des entités (adapté au développement, à ne jamais utiliser tel quel en production).

## Auteur

Imen — ESPRIT, UP ASI 2026-2027