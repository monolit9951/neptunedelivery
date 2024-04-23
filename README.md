## Docker > Building for backend dev
1. Make sure you have Docker installed.
2. Run `docker run --name sushi -e POSTGRES_PASSWORD=sushi -e POSTGRES_USER=sushi -e POSTGRES_DB=sushi -p 5499:5432 -d postgres:14` to set up the db in Docker.
3. Change db url in `application.properties` from `spring.datasource.url=jdbc:postgresql://sushi-db:5432/sushi` to `spring.datasource.url=jdbc:postgresql://localhost:5499/sushi`
4. Check response from http://localhost:8080/api/products to make sure app is working.