
## 📦 Prérequis

### Installation classique

Avant de commencer, assurez-vous d'avoir installé :

- **Java 17** ou supérieur
- **Node.js 16+** et **npm**
- **Maven 3.6+**
- **Angular CLI** (`npm install -g @angular/cli`)

### Installation avec Docker

Alternativement, vous pouvez utiliser Docker pour exécuter l'application :

- **Docker** 20.10 ou supérieur
- **Docker Compose** 2.0 ou supérieur

## 🔧 Installation

### 1. Cloner le repository
### Option 1 : Démarrage rapide avec Docker (Recommandé)

La méthode la plus simple pour démarrer l'application :

```bash
# Cloner le repository
git clone https://github.com/mbarekoussama/Emploi-FSM.git
cd Emploi-FSM

# Construire et démarrer tous les services
docker compose up -d

# Voir les logs
docker compose logs -f
```

**Alternative locale** : Si vous rencontrez des problèmes de certificats SSL, utilisez la version locale :

```bash
# 1. Construire le backend localement
cd backEnd
./mvnw clean package -DskipTests
cd ..

# 2. Utiliser docker-compose local
docker compose -f docker-compose.local.yml up -d
```

L'application sera accessible sur :
- **Frontend** : `http://localhost`
- **Backend API** : `http://localhost:8082`
- **H2 Console** : `http://localhost:8082/h2-console`
- **Swagger UI** : `http://localhost:8082/swagger-ui.html`

Pour arrêter l'application :
```bash
docker compose down
```

Pour reconstruire les images après modification du code :
```bash
docker compose up -d --build
```

📚 **Plus d'informations** : Consultez [DOCKER.md](DOCKER.md) pour la documentation complète et le dépannage.

### Option 2 : Installation classique

#### 1. Cloner le repository

```bash
git clone https://github.com/mbarekoussama/Emploi-FSM.git
cd Emploi-FSM
```

### 2. Backend (Spring Boot)
#### 2. Backend (Spring Boot)

```bash
cd backEnd
./mvnw clean install
./mvnw spring-boot:run
```

Le serveur backend démarrera sur `http://localhost:8080`
Le serveur backend démarrera sur `http://localhost:8082`

### 3. Frontend (Angular)
#### 3. Frontend (Angular)

```bash
cd frontEnd
│   │   │   │   └── settings/   # Configuration
│   │   │   └── resources/      # Fichiers de configuration
│   │   └── test/               # Tests unitaires
│   ├── Dockerfile              # Configuration Docker backend
│   ├── .dockerignore           # Fichiers à exclure du build Docker
│   └── pom.xml                 # Dépendances Maven
│
├── frontEnd/                   # Application Angular
│   │   │   └── services/       # Services HTTP
│   │   ├── assets/             # Ressources statiques
│   │   └── environments/       # Configuration d'environnement
│   ├── Dockerfile              # Configuration Docker frontend
│   ├── .dockerignore           # Fichiers à exclure du build Docker
│   ├── nginx.conf              # Configuration Nginx pour production
│   ├── angular.json            # Configuration Angular
│   └── package.json            # Dépendances npm
│
└── test/                       # Données de test
    └── dataFilieres.xlsx       # Fichier Excel de test
├── docker-compose.yml          # Orchestration des services Docker
├── test/                       # Données de test
│   └── dataFilieres.xlsx       # Fichier Excel de test
└── README.md                   # Documentation du projet
```

## 📖 Documentation API

Une fois le backend démarré, accédez à la documentation Swagger :

- **Swagger UI** : `http://localhost:8080/swagger-ui.html`
- **API Docs** : `http://localhost:8080/v3/api-docs`
- **Swagger UI** : `http://localhost:8082/swagger-ui.html`
- **API Docs** : `http://localhost:8082/v3/api-docs`

## 🐳 Commandes Docker Utiles

### Gestion des conteneurs
```bash
# Démarrer les services
docker compose up -d

# Arrêter les services
docker compose down

# Redémarrer un service spécifique
docker compose restart backend
docker compose restart frontend

# Voir les logs
docker compose logs -f
docker compose logs -f backend
docker compose logs -f frontend

# Reconstruire les images
docker compose build
docker compose up -d --build

# Supprimer les volumes (réinitialiser la base de données)
docker compose down -v
```

### Commandes de débogage
```bash
# Lister les conteneurs en cours d'exécution
docker compose ps

# Accéder au shell d'un conteneur
docker compose exec backend sh
docker compose exec frontend sh

# Voir l'utilisation des ressources
docker stats
```

## 🧪 Tests
