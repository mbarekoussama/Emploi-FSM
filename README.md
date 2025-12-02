# Emploi-FSM

Une application de gestion d'emploi du temps. Cette plateforme a comme finalité de remplacer la gestion manuelle des plannings au sein de la Faculté des Sciences de Monastir.

## 📋 Description

Emploi-FSM est une application web complète de gestion des emplois du temps pour la Faculté des Sciences de Monastir. Elle permet de gérer efficacement les plannings des enseignants, des classes, des salles et des modules de cours.

## 🚀 Fonctionnalités

- **Gestion des emplois du temps** : Création et modification des plannings
- **Gestion des enseignants** : Ajout, modification et suivi des enseignants
- **Gestion des salles** : Attribution et disponibilité des salles
- **Gestion des classes** : Organisation des classes par filière et département
- **Gestion des modules** : Configuration des modules et éléments de module
- **Gestion des disponibilités** : Suivi des non-disponibilités des enseignants
- **Import Excel** : Importation de données depuis des fichiers Excel
- **Export PDF** : Génération des emplois du temps en format PDF
- **API Documentation** : Documentation Swagger intégrée

## 🛠️ Technologies Utilisées

### Backend
- **Java 17**
- **Spring Boot 3.0.5**
- **Spring Data JPA**
- **H2 Database** (base de données en mémoire)
- **Lombok**
- **Apache POI** (gestion des fichiers Excel)
- **OpenPDF / PDFBox** (génération de PDF)
- **Swagger / SpringDoc OpenAPI** (documentation API)

### Frontend
- **Angular 16**
- **Bootstrap 5**
- **FontAwesome 6**
- **SweetAlert2**
- **RxJS**

## 📦 Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- **Java 17** ou supérieur
- **Node.js 16+** et **npm**
- **Maven 3.6+**
- **Angular CLI** (`npm install -g @angular/cli`)

## 🔧 Installation

### 1. Cloner le repository

```bash
git clone https://github.com/mbarekoussama/Emploi-FSM.git
cd Emploi-FSM
```

### 2. Backend (Spring Boot)

```bash
cd backEnd
./mvnw clean install
./mvnw spring-boot:run
```

Le serveur backend démarrera sur `http://localhost:8080`

### 3. Frontend (Angular)

```bash
cd frontEnd
npm install
ng serve
```

L'application frontend sera accessible sur `http://localhost:4200`

## 📁 Structure du Projet

```
Emploi-FSM/
├── backEnd/                    # Application Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/pi/enset/
│   │   │   │   ├── entities/   # Entités JPA
│   │   │   │   ├── repository/ # Repositories Spring Data
│   │   │   │   ├── services/   # Logique métier
│   │   │   │   ├── web/        # Contrôleurs REST
│   │   │   │   ├── GAlgo/      # Algorithmes de génération
│   │   │   │   └── settings/   # Configuration
│   │   │   └── resources/      # Fichiers de configuration
│   │   └── test/               # Tests unitaires
│   └── pom.xml                 # Dépendances Maven
│
├── frontEnd/                   # Application Angular
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/     # Composants Angular
│   │   │   ├── models/         # Modèles TypeScript
│   │   │   └── services/       # Services HTTP
│   │   ├── assets/             # Ressources statiques
│   │   └── environments/       # Configuration d'environnement
│   ├── angular.json            # Configuration Angular
│   └── package.json            # Dépendances npm
│
└── test/                       # Données de test
    └── dataFilieres.xlsx       # Fichier Excel de test
```

## 📖 Documentation API

Une fois le backend démarré, accédez à la documentation Swagger :

- **Swagger UI** : `http://localhost:8080/swagger-ui.html`
- **API Docs** : `http://localhost:8080/v3/api-docs`

## 🧪 Tests

### Backend
```bash
cd backEnd
./mvnw test
```

### Frontend
```bash
cd frontEnd
ng test
```

## 👥 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :

1. Fork le projet
2. Créer une branche pour votre fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Commiter vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Pusher sur la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

## 📄 Licence

Ce projet est développé dans le cadre d'un projet académique pour la Faculté des Sciences de Monastir.

## 📧 Contact

Pour toute question ou suggestion, n'hésitez pas à ouvrir une issue sur ce repository.
