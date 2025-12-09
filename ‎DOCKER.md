# Docker Configuration for Emploi-FSM

This directory contains Docker configuration for containerizing the Emploi-FSM application.

## Quick Start

### Using Docker Compose (Recommended)

From the project root directory:

```bash
# Build and start all services
docker compose up -d

# View logs
docker compose logs -f

# Stop all services
docker compose down
```

### Individual Container Build

#### Backend
```bash
cd backEnd
docker build -t emploi-fsm-backend .
docker run -p 8082:8082 emploi-fsm-backend
```

#### Frontend
```bash
cd frontEnd
docker build -t emploi-fsm-frontend .
docker run -p 80:80 emploi-fsm-frontend
```

## Troubleshooting

### SSL Certificate Issues During Build

If you encounter SSL certificate errors during Maven dependency download in Docker, you have two options:

#### Option 1: Build JAR locally first

```bash
# Build the JAR locally
cd backEnd
./mvnw clean package -DskipTests

# Then use this alternative Dockerfile
```

Create `Dockerfile.simple` in the backend directory:
```dockerfile
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the pre-built jar
COPY target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
```

Build with:
```bash
docker build -f Dockerfile.simple -t emploi-fsm-backend .
```

#### Option 2: Update Docker Compose

Update `docker-compose.yml` backend service to use the simple Dockerfile:
```yaml
backend:
  build:
    context: ./backEnd
    dockerfile: Dockerfile.simple
```

### Port Conflicts

If ports 80 or 8082 are already in use:

```yaml
# In docker-compose.yml, change the port mappings:
services:
  backend:
    ports:
      - "8083:8082"  # Use port 8083 instead
  frontend:
    ports:
      - "8080:80"    # Use port 8080 instead
```

### Checking Container Health

```bash
# Check container status
docker compose ps

# Check container logs
docker compose logs backend
docker compose logs frontend

# Execute commands in running container
docker compose exec backend sh
docker compose exec frontend sh
```

## Configuration

### Backend Environment Variables

You can override Spring Boot properties using environment variables in `docker-compose.yml`:

```yaml
backend:
  environment:
    - SPRING_DATASOURCE_URL=jdbc:h2:mem:emplois_temps-db
    - SERVER_PORT=8082
```

### Frontend API URL

The frontend is configured to connect to the backend at `http://localhost:8082/api`. If you change the backend port, update `frontEnd/src/environments/environment.prod.ts`.

## Production Deployment

For production deployment:

1. Update environment variables for production
2. Consider using a persistent database instead of H2 in-memory
3. Set up proper logging and monitoring
4. Use Docker secrets for sensitive information
5. Configure proper resource limits

Example production docker-compose.yml snippet:
```yaml
backend:
  deploy:
    resources:
      limits:
        cpus: '2'
        memory: 2G
      reservations:
        cpus: '1'
        memory: 1G
    restart_policy:
      condition: on-failure
      delay: 5s
      max_attempts: 3
```
