# ICI – Intelligent Collaboration Infrastructure

A **Spring Modulith** application for **matching task requesters with nearby task providers**, based on location. Built using **Domain-Driven Design (DDD)** and modular architecture to ensure clear separation of concerns and scalability.

---

## Overview

ICI enables users to create tasks that are automatically matched with nearby eligible providers. When a requester creates a task, the system:

1. **Saves the task** to the database.
2. **Publishes a domain event** (`TaskCreatedEvent`).
3. The **Matching module** listens for this event and finds nearby providers using the **Location module**.
4. Notifications (optional) are sent to matched providers.

---

## Modular Structure (Spring Modulith)

Each package under `com.hoderick.ici` represents a standalone **application module**.

### Modules

#### `task`
Handles task creation and persistence.

- `TaskController` (API layer)
- `TaskService` (business logic)
- `TaskRepository` (data persistence)
- `TaskCreatedEvent` (published when a task is created)

#### 📍 `location`
Manages provider locations using Redis Geo commands.

- `LocationController` allows updating provider location.
- `LocationService` saves and retrieves geo positions.
- Uses Redis to efficiently find nearby providers.

#### 🔄 `matching`
Listens for `TaskCreatedEvent` and initiates provider matching.

- `MatchingService` queries the location module and applies business rules to find best-suited providers.

#### 👤 `user`
Manages users, requesters, and providers.

- Handles user registration, status updates, and retrieval.
- Exposes `ProviderService` and `RequesterService` used across other modules.

#### 📢 `notification` *(planned/optional)*
Responsible for notifying matched providers about new tasks.

---

## 🧪 Example Flow: Creating and Matching a Task

1. **POST** `/tasks` with task details
2. `TaskServiceImpl#createTask()` is called
3. A `TaskCreatedEvent` is published
4. `TaskCreatedListener` in the `matching` module reacts to the event
5. `MatchingService` queries `LocationService` for nearby providers
6. Matching logic selects candidates and (optionally) notifies them

---

## 🔧 Technology Stack

- **Java 21**
- **Spring Boot**
- **Spring Modulith**
- **Redis (for geospatial queries)**
- **Spring Data JPA**
- **RESTful APIs (Spring Web)**

---

