# Simple CRUD with Spring Boot, JPA, Hibernate, PostgreSQL

## How to run the application
1. Clone the repository
2. Open the project in your favorite IDE
3. Up the PostgreSQL database using the following command:
```bash
docker-compose up -d
```

1. Run the application
2. The base path is http://localhost:8080/api/v1/todo
3. To get all todos, use the following endpoint:
```bash
GET /todos
```
4. To get a todo by id, use the following endpoint:
```bash
GET /todos/{id}
```
5. To create a new todo, use the following endpoint:
```bash
POST /todos
content-type: application/json
{
    "title": "New todo",
    "description": "New todo description"
    "status": "IN_PROGRESS" or "COMPLETED or "CREATED"
}
```
6. To update a todo, use the following endpoint:
```bash
PUT /todos/{id}
content-type: application/json
{
    "title": "Updated todo",
    "description": "Updated todo description"
    "status": "IN_PROGRESS" or "COMPLETED or "CREATED"
}
```
7. To delete a todo, use the following endpoint:
```bash
DELETE /todos/{id}
```

## Stop db
```bash
docker-compose down
```