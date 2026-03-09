# Hive Desk

Company task & calendar management – users, roles, tasks, events, assignments.

## Tech stack (Phase 1)

- Java 21
- Maven
- JUnit 5
- In-memory storage

## Quick start

```bash
# Compile
mvn compile

# Compile & run
mvn clean compile exec:java -Dexec.mainClass=agurchu.hivedesk.HiveDesk

# or shorter (if profile is activated)
mvn -Prun compile exec:java

# Tests
mvn test

# Create normal JAR
mvn clean package

java -jar target/hivedesk-1.0-SNAPSHOT.jar

# Docker
docker build -t hivedesk:latest .
docker run --rm -it hivedesk:latest
```

UI 
Hive Desk  v0.1.0
───────────────────────────────────────────────

Login
Username: alice
Password: ********
→ Welcome, Alice (Manager)

[1]  My Dashboard

[2]  Assign Task to someone

[3]  Schedule Meeting / Deadline / Training

[4]  View All Open Tasks (team)

[5]  View Upcoming Events

[6]  Logout

> 1

Your Dashboard ─────────────────────────────────

Upcoming deadlines & events
────────────────────────────
• Fix payment gateway       HIGH    due 2025-04-05   assigned to bob
• Sprint Planning           MEETING tomorrow 14:00   you + bob + carol
• Q2 Goals review           DEADLINE 2025-04-10

Your open tasks
───────────────
(none)

Team workload
─────────────
bob   : 3 open tasks
carol : 1 open task
you   : 0 open tasks

[← back]